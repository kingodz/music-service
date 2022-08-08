package se.donato.demo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import se.donato.demo.model.musicbrainz.MusicBrainzProfile;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class MusicBrainzServiceTest {

    MusicBrainzService sut;

    @Mock
    RestTemplate restTemplate;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        sut = new MusicBrainzService(restTemplate);
    }


    @Test
    void when_quertying_for_a_MusicBrainzProfile_expect_exception() {

        //given
        MusicBrainzProfile profile = new MusicBrainzProfile();
        profile.id = "2312";

        when(restTemplate.exchange(anyString(), any(), any(),
                eq(MusicBrainzService.class), anyString())).thenThrow(new RuntimeException("a"));

        //when
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            sut.getMusicBrainzProfile("123");
        });

        //then
        Assertions.assertTrue(thrown.getMessage().contains("musicBrainz REST API call failed."));
    }



    @Test
    void getAlbumCoverArtDetails() {
    }

    @Test
    void getCoverArtImagesUsingWebFlex() {
    }
}