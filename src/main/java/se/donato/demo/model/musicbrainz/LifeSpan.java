
package se.donato.demo.model.musicbrainz;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ended",
        "begin",
        "end"
})
@Generated("jsonschema2pojo")
public class LifeSpan {

    @JsonProperty("ended")
    public boolean ended;
    @JsonProperty("begin")
    public String begin;
    @JsonProperty("end")
    public String end;


}
