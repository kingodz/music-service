package se.donato.demo.model.music.info.fetcher;

import lombok.Data;

import java.util.List;

@Data
public class InfoResponse {
    private String mbid;
    private String name;
    private String gender;
    private String country;
    private String disambiguation;
    private String description;
    private List<AlbumWithCoverArt> albums;
}
