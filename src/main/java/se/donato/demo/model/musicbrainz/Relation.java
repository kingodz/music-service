
package se.donato.demo.model.musicbrainz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "source-credit",
        "attributes",
        "type-id",
        "target-credit",
        "attribute-ids",
        "ended",
        "attribute-values",
        "end",
        "begin",
        "type",
        "direction",
        "url",
        "target-type"
})
@Generated("jsonschema2pojo")
public class Relation {

    @JsonProperty("source-credit")
    public String sourceCredit;
    @JsonProperty("attributes")

    public List<Object> attributes = null;
    @JsonProperty("type-id")
    public String typeId;
    @JsonProperty("target-credit")
    public String targetCredit;
    @JsonProperty("attribute-ids")

    public AttributeIds attributeIds;
    @JsonProperty("ended")
    public boolean ended;
    @JsonProperty("attribute-values")

    public AttributeValues attributeValues;
    @JsonProperty("end")
    public Object end;
    @JsonProperty("begin")
    public Object begin;
    @JsonProperty("type")
    public String type;
    @JsonProperty("direction")
    public String direction;
    @JsonProperty("url")

    public Url url;
    @JsonProperty("target-type")
    public String targetType;


}
