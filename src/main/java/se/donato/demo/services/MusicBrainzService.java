package se.donato.demo.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import se.donato.demo.model.MusicBrainzCoverArt.CoverArt;
import se.donato.demo.model.MusicBrainzCoverArt.CoverImage;
import se.donato.demo.model.music.info.fetcher.AlbumWithCoverArt;
import se.donato.demo.model.musicbrainz.MusicBrainzProfile;
import se.donato.demo.model.musicbrainz.ReleaseGroup;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MusicBrainzService {

    private final String mbProfileUrl =
            "http://musicbrainz.org/ws/2/artist/{mbid}?&fmt=json&inc=url-rels+release-groups";
    private final String mbCoverArtRestUrl = "http://coverartarchive.org/release-group/{id}";
    private final RestTemplate restTemplate;

    public MusicBrainzService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     * This method used to get the MusicBrainz artist profile
     *
     * @param mbid
     * @return MusicBrainzProfile - the MB artist profile
     */
    public MusicBrainzProfile getMusicBrainzProfile(String mbid) {
        try {
             return restTemplate.exchange(mbProfileUrl, HttpMethod.GET,
                    new HttpEntity<>(new HttpHeaders()), MusicBrainzProfile.class, mbid).getBody();
        } catch (Exception e) {
            log.error(String.valueOf(e));
            throw new RuntimeException("musicBrainz REST API call failed." + e.getMessage());
        }
    }


    /**
     * This method used to get the Album with Cover Art details based on Release Group
     *
     * @param releaseGroups
     * @return List<AlbumWithCoverArt> - list of album with cover art details.
     */

    public List<AlbumWithCoverArt> getAlbumCoverArtDetails(List<ReleaseGroup> releaseGroups) {
        List<AlbumWithCoverArt> coverArtList = new ArrayList<>();

        releaseGroups.parallelStream().forEach(releaseGroup -> {
            AlbumWithCoverArt album = new AlbumWithCoverArt();
            album.setId(releaseGroup.getId());
            album.setTitle(releaseGroup.getTitle());
            album.setImageUrl(getCoverImageUrl(releaseGroup.getId()));
            coverArtList.add(album);
        });
        return coverArtList;
    }


    private String getCoverImageUrl(String albumId) {
        try {
            ResponseEntity<CoverArt> coverArtResponse = restTemplate.exchange(mbCoverArtRestUrl, HttpMethod.GET,
                    new HttpEntity<>(new HttpHeaders()), CoverArt.class, albumId);

            String frontCoverImageUrl = coverArtResponse.getBody().getImages().stream()
                    .filter(CoverImage::isFront)
                    .findFirst()
                    .map(CoverImage::getImage)
                    .orElse("");
            return frontCoverImageUrl;


        } catch (Exception e) {
            log.error(String.valueOf(e));
        }

        return null;
    }

    // not in use - testing , use Flux to do REST API calls in parallel
    public void getCoverArtImagesUsingWebFlex(List<String> ids) {
        Flux.fromIterable(ids)
                .flatMap(this::getCoverImageUrlFlux)
                .buffer()
                .subscribe();
        //todo fix webflux : .block* and .toStream is blocked!
    }

    // not in use - testing , use Flux to do REST API calls in parallel
    private Mono<CoverArt> getCoverImageUrlFlux(String albumId) {
        WebClient webClient = WebClient
                .builder()
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create().followRedirect(true)
                )).baseUrl("http://coverartarchive.org").build();

        Mono<CoverArt> result = webClient.get()
                .uri("/release-group/{albumId}", albumId).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CoverArt.class);

        return result;

    }

}
