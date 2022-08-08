package se.donato.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.wikidata.wdtk.datamodel.interfaces.EntityDocument;
import org.wikidata.wdtk.datamodel.interfaces.ItemDocument;
import org.wikidata.wdtk.wikibaseapi.WikibaseDataFetcher;
import org.wikidata.wdtk.wikibaseapi.apierrors.MediaWikiApiErrorException;
import se.donato.demo.model.wikipedia.WikiSummary;

import java.io.IOException;
import java.util.Collections;


@Slf4j
@Service
public class WikipediaService {

    private final RestTemplate restTemplate;

    public WikipediaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WikiSummary getWikipediaSummary(String entityName) throws IOException, MediaWikiApiErrorException {

        String url = getWikipediaSummaryUrl(entityName);

        try {
            return restTemplate.exchange(url, HttpMethod.GET,
                    new HttpEntity<>(new HttpHeaders()), WikiSummary.class, entityName).getBody();

        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        throw new RuntimeException("error parsing wikipedia summary page");  //todo specific exception?
    }


    private String getWikipediaSummaryUrl(String entityName) throws MediaWikiApiErrorException, IOException {

        WikibaseDataFetcher wbdf = WikibaseDataFetcher.getWikidataDataFetcher();

        // Fetching data using filters to reduce data volume
        // Only site links from English Wikipedia:
        wbdf.getFilter().setSiteLinkFilter(Collections.singleton("enwiki"));
        wbdf.getFilter().setLanguageFilter(Collections.singleton("en"));


        EntityDocument document = wbdf.getEntityDocument(entityName);

        if (!(document instanceof ItemDocument)) {
            log.error("could not get wikibase description for " + entityName);
        }
        ItemDocument doc = (ItemDocument) document;

        String pageTitle = doc.getSiteLinks().get("enwiki").getPageTitle();
        return "https://en.wikipedia.org/api/rest_v1/page/summary/" + pageTitle;

    }
}


