package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.enums.CommentSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.CommentInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class CommentURLGeneratorTest {

    @Resource
    CommentURLGenerator commentURLGenerator;

    @Test
    public void test() throws ParseException, MalformedURLException {
        CommentInitializer commentInitializer = new CommentInitializer(1, 10, 20160101L, 20160102L, Order.ASC,
                CommentSortBy.CREATION, 20160101L, 20163101L, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/comments?page=1&pagesize=10&fromdate=1451606400&todate=1454284800&order=asc&min=1451606400&max=1454198400&sort=creation&site=stackoverflow",
                commentURLGenerator.urlGenerator(commentInitializer).toString());
        commentInitializer = new CommentInitializer(null, null, null, null, Order.DESC, CommentSortBy.CREATION, null,
                null,
                2068027L);
        assertEquals(
                "https://api.stackexchange.com/2.2/comments/2068027?order=desc&sort=creation&site=stackoverflow",
                commentURLGenerator.urlGenerator(commentInitializer).toString());
    }

}
