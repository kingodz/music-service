
package se.donato.demo.model.musicbrainz;

import java.util.HashMap;
import java.util.List;
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
        "title",
        "id",
        "primary-type-id",
        "disambiguation",
        "secondary-types",
        "first-release-date",
        "primary-type",
        "secondary-type-ids"
})
@Generated("jsonschema2pojo")
public class ReleaseGroup {

    @JsonProperty("title")
    public String title;
    @JsonProperty("id")
    public String id;
    @JsonProperty("primary-type-id")
    public String primaryTypeId;
    @JsonProperty("disambiguation")
    public String disambiguation;
    @JsonProperty("secondary-types")

    public List<String> secondaryTypes = null;
    @JsonProperty("first-release-date")
    public String firstReleaseDate;
    @JsonProperty("primary-type")
    public String primaryType;
    @JsonProperty("secondary-type-ids")

    public List<String> secondaryTypeIds = null;


}
