package com.destack.overflow.json;

import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class JsonFetcherTest {

    @Test
    public void test() throws MalformedURLException {
        assertNotNull(
                JsonFetcher
                .urlToJson("https://api.stackexchange.com/2.2/answers?order=desc&sort=activity&site=stackoverflow")
                .get("items")
                .toString());
        assertNotNull(JsonFetcher
                .urlToJson(
                        new URL("https://api.stackexchange.com/2.2/answers?order=desc&sort=activity&site=stackoverflow"))
                .get("items").toString());
    }

}
