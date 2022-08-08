package se.donato.demo.model.wikipedia;

import lombok.Data;

@Data
public class WikiSummary {

    private Integer pageid;
    private String title;
    private String extract;
}