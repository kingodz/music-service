package se.donato.demo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wikidata.wdtk.wikibaseapi.apierrors.MediaWikiApiErrorException;
import reactor.core.publisher.Mono;
import se.donato.demo.model.music.info.fetcher.InfoResponse;
import se.donato.demo.services.ArtistService;

import java.io.IOException;


@Slf4j
@RequestMapping("/")
@RestController
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/musify/music-artist/details/{mbid}")
    public Mono<InfoResponse> getProfileForArtist(@PathVariable("mbid") String mbid)
            throws IOException, MediaWikiApiErrorException {
        return artistService.getProfileForArtist(mbid);
    }

    //todo new class with @ExceptionHandler(InvalidReleaseException.class)
}