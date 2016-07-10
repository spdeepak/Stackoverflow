package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.TagRetriever;
import com.destack.overflow.enums.TagSortBy;
import com.destack.overflow.initializers.TagItemInitializer;

/**
 * @author Deepak
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class TagItemURLGeneratorTest {

    @Resource
    private TagItemURLGenerator tagItemURLGenerator;

    @Test
    public void testDefaultTagRetriever() throws ParseException, MalformedURLException, IllegalAccessException {
        TagItemInitializer tagItemInitializer = new TagItemInitializer(1, 100, 20100405L, 20160707L, Order.ASC,
                TagSortBy.POPULAR, null, null, "java", TagRetriever.DEFAULT);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=asc&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
        tagItemInitializer = new TagItemInitializer(1, 100, 20100405L, 20160707L, Order.DESC, TagSortBy.POPULAR, 1, 10,
                "java", TagRetriever.DEFAULT);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=desc&min=1&max=10&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
        tagItemInitializer = new TagItemInitializer(1, 100, 20100405L, 20160707L, Order.ASC, TagSortBy.POPULAR, null,
                null, "java", TagRetriever.MODERATOR_ONLY);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/moderator-only?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=asc&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
    }

}
