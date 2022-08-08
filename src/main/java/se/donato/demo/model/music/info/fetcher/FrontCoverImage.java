package se.donato.demo.model.music.info.fetcher;

import lombok.Data;

@Data
public class FrontCoverImage {

    private String frontCoverImageUrl;
    private String albumId;

    public FrontCoverImage(String frontCoverImageUrl, String albumId) {
        this.frontCoverImageUrl = frontCoverImageUrl;
        this.albumId = albumId;
    }
}
