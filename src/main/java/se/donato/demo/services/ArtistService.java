package se.donato.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wikidata.wdtk.wikibaseapi.apierrors.MediaWikiApiErrorException;
import reactor.core.publisher.Mono;
import se.donato.demo.model.music.info.fetcher.AlbumWithCoverArt;
import se.donato.demo.model.music.info.fetcher.InfoResponse;
import se.donato.demo.model.musicbrainz.MusicBrainzProfile;
import se.donato.demo.model.musicbrainz.ReleaseGroup;
import se.donato.demo.model.wikipedia.WikiSummary;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class ArtistService {


    private final WikipediaService wikipediaService;
    private final MusicBrainzService musicBrainzService;

    public ArtistService(
            WikipediaService wikipediaService,
            MusicBrainzService musicBrainzService) {
        this.wikipediaService = wikipediaService;
        this.musicBrainzService = musicBrainzService;
    }


    public Mono<InfoResponse> getProfileForArtist(String mbid) throws IOException, MediaWikiApiErrorException {
        log.debug("Starting to process mbid : " + mbid);

        MusicBrainzProfile musicBrainzProfile = musicBrainzService.getMusicBrainzProfile(mbid);

        String wikiDataEntityName = musicBrainzProfile.getWikiDataEntityName();
        WikiSummary wikiSummary = wikipediaService.getWikipediaSummary(wikiDataEntityName);

        List<ReleaseGroup> releaseGroups = musicBrainzProfile.getReleaseGroups();
        List<AlbumWithCoverArt> coverArtList = musicBrainzService.getAlbumCoverArtDetails(releaseGroups);

        InfoResponse infoResponse = generateResponse(mbid, musicBrainzProfile, wikiSummary, coverArtList);
        return Mono.just(infoResponse);
    }

    private static InfoResponse generateResponse(String mbid, MusicBrainzProfile musicBrainzProfile,
                                                 WikiSummary wikiSummary, List<AlbumWithCoverArt> coverArtList) {
        InfoResponse infoResponse = new InfoResponse();
        infoResponse.setMbid(mbid);
        infoResponse.setName(musicBrainzProfile.getName());
        infoResponse.setGender(musicBrainzProfile.getGender());
        infoResponse.setCountry(musicBrainzProfile.getCountry());
        infoResponse.setDisambiguation(musicBrainzProfile.getDisambiguation());
        infoResponse.setDescription(wikiSummary.getExtract());
        infoResponse.setAlbums(coverArtList);
        return infoResponse;
    }


}