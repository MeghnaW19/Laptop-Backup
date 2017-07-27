package com.stackroute.swisit.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stackroute.swisit.domain.ContentSchema;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.neo4j.annotation.Query;

import java.util.Arrays;
import java.util.Date;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CrawlerResult {

    @NotEmpty
    @JsonProperty("query")
    private String query;
    @NotEmpty
    @JsonProperty("link")
    private String link;
    @NotEmpty
    @JsonProperty("terms")
    private ContentSchema[] terms;
    @NotEmpty
    @JsonProperty("title")
    private String title;
    @NotEmpty
    @JsonProperty("snippet")
    private String snippet;
    @NotNull
    @JsonProperty("lastindexedof")
    private Date lastindexedof;
    
    

    public CrawlerResult() { }

    public CrawlerResult(String query, String link, ContentSchema[] terms, String title, String snippet,Date lastindexof) {
        this.query = query;
        this.link = link;
        this.terms = terms;
        this.title = title;
        this.snippet = snippet;
        this.lastindexedof=lastindexof;
    }

    public Date getLastindexedof() {
		return lastindexedof;
	}

	public void setLastindexedof(Date lastindexedof) {
		this.lastindexedof = lastindexedof;
	}

	@Override
    public String toString() {
        return "IntentParserInput{" +
                "query='" + query + '\'' +
                ", link='" + link + '\'' +
                ", contentSchema=" + Arrays.toString(terms) +
                ", title='" + title + '\'' +
                ", snippet='" + snippet + '\'' +
                '}';
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    
    public ContentSchema[] getTerms() {
		return terms;
	}

	public void setTerms(ContentSchema[] terms) {
		this.terms = terms;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}