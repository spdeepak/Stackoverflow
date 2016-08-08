package com.destack.overflow.initializers;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.destack.overflow.enums.PostRetriever;

public class PostItemInitializerTest {

    private PostItemInitializer pi;

    @Test
    public void testAll() {
        pi = new PostItemInitializer.Builder().build();
        assertEquals(PostRetriever.ALL, pi.getPostRetriever());
        pi = new PostItemInitializer.Builder().page(1).build();
        assertEquals(Integer.valueOf(1), pi.getPage());
        pi = new PostItemInitializer.Builder().page(1).pageSize(100).fromDate(new Date(20160607L)).build();
        assertEquals(Integer.valueOf(1), pi.getPage());
        assertEquals(Integer.valueOf(100), pi.getPageSize());
        assertEquals(new Date(20160607L).getTime(), pi.getFromDate().getTime());
    }

}
