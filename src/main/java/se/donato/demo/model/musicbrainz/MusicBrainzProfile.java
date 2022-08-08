
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
        "end-area",
        "country",
        "life-span",
        "type-id",
        "gender",
        "ipis",
        "area",
        "name",
        "begin_area",
        "disambiguation",
        "isnis",
        "type",
        "sort-name",
        "gender-id",
        "relations",
        "release-groups",
        "id"
})
@Generated("jsonschema2pojo")
public class MusicBrainzProfile {

    @JsonProperty("end-area")

    public EndArea endArea;

    @JsonProperty("country")
    public String country;
    @JsonProperty("life-span")

    public LifeSpan lifeSpan;
    @JsonProperty("type-id")
    public String typeId;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("ipis")

    public List<String> ipis = null;
    @JsonProperty("area")

    public Area area;
    @JsonProperty("name")
    public String name;
    @JsonProperty("begin_area")

    public BeginArea beginArea;

    @JsonProperty("disambiguation")
    public String disambiguation;
    @JsonProperty("isnis")

    public List<String> isnis = null;
    @JsonProperty("type")
    public String type;
    @JsonProperty("sort-name")
    public String sortName;
    @JsonProperty("gender-id")
    public String genderId;
    @JsonProperty("relations")

    public List<Relation> relations = null;
    @JsonProperty("release-groups")

    public List<ReleaseGroup> releaseGroups = null;
    @JsonProperty("id")
    public String id;

    public String getWikiDataEntityName() {
        String wantedRelationType = "wikidata";
        String wikiDataEntityUrl = this.getRelations().stream()
                .filter(relation -> wantedRelationType.equals(relation.getType()))
                .map(relation -> relation.getUrl().getResource())
                .findFirst().orElse("");

        return wikiDataEntityUrl.substring(wikiDataEntityUrl.lastIndexOf("/") + 1);
    }

}
