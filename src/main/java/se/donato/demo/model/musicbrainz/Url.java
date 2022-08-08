
package se.donato.demo.model.musicbrainz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "resource",
        "id"
})
@Generated("jsonschema2pojo")
public class Url {

    @JsonProperty("resource")
    public String resource;
    @JsonProperty("id")
    public String id;


}