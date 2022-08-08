
package se.donato.demo.model.musicbrainz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sort-name",
        "type",
        "disambiguation",
        "id",
        "name",
        "type-id"
})
@Generated("jsonschema2pojo")
public class EndArea {

    @JsonProperty("sort-name")
    public String sortName;
    @JsonProperty("type")
    public Object type;
    @JsonProperty("disambiguation")
    public String disambiguation;
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("type-id")
    public Object typeId;


}
