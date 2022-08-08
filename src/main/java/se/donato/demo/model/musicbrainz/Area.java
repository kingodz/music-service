package se.donato.demo.model.musicbrainz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sort-name",
        "disambiguation",
        "iso-3166-1-codes",
        "type",
        "name",
        "type-id",
        "id"
})
public class Area {

    @JsonProperty("sort-name")
    public String sortName;

    @JsonProperty("disambiguation")
    public String disambiguation;

    @JsonProperty("iso-3166-1-codes")
    public List<String> iso31661Codes = new ArrayList<String>();

    @JsonProperty("type")
    public Object type;

    @JsonProperty("name")
    public String name;

    @JsonProperty("type-id")
    public Object typeId;

    @JsonProperty("id")
    public String id;

}
