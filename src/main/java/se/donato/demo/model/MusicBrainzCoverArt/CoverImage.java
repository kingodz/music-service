package se.donato.demo.model.MusicBrainzCoverArt;



import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "approved",
        "back",
        "comment",
        "edit",
        "front",
        "id",
        "image",
        "thumbnails",
        "types"
})
@Generated("jsonschema2pojo")
public class CoverImage {

    @JsonProperty("approved")
    public boolean approved;
    @JsonProperty("back")
    public boolean back;
    @JsonProperty("comment")
    public String comment;
    @JsonProperty("edit")
    public long edit;
    @JsonProperty("front")
    public boolean front;
    @JsonProperty("id")
    public long id;
    @JsonProperty("image")
    public String image;
//    @JsonProperty("thumbnails")
//    public Thumbnails thumbnails;
    @JsonProperty("types")
    public List<String> types = null;

}