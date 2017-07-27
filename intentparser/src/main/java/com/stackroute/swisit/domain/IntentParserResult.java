package com.stackroute.swisit.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.hateoas.ResourceSupport;

public class IntentParserResult extends ResourceSupport {
	@NotEmpty 
    String url;
	@NotEmpty
    String intent;
	@NotNull
    float confidenceScore;
    

    public IntentParserResult() { }

    public IntentParserResult(String url, String intent, float confidenceScore) {
        this.url = url;
        this.intent = intent;
        this.confidenceScore = confidenceScore;
        
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public float getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(float confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
}
