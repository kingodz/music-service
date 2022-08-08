package se.donato.demo.model.MusicBrainzCoverArt;



import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "images",
        "release"
})
@Generated("jsonschema2pojo")
public class CoverArt {

    @JsonProperty("images")
    public List<CoverImage> images = null;
    @JsonProperty("release")
    public String release;

}