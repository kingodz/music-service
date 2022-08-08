
package se.donato.demo.model.musicbrainz;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "disambiguation",
        "sort-name",
        "type-id",
        "name",
        "id"
})
@Generated("jsonschema2pojo")
public class BeginArea {

    @JsonProperty("type")
    public Object type;
    @JsonProperty("disambiguation")
    public String disambiguation;
    @JsonProperty("sort-name")
    public String sortName;
    @JsonProperty("type-id")
    public Object typeId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("id")
    public String id;


}
