package com.stackroute.swisit.subscriber;

import com.stackroute.swisit.domain.CrawlerResult;

import java.util.List;

/**
 * Created by user on 21/6/17.
 */
public interface Subscriber {
    public List<CrawlerResult> receivingMessage(String string);
}
