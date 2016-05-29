package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.enums.BadgeSortBy;
import com.destack.overflow.enums.MaxMin;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.BadgeItemInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class BadgeItemURLGeneratorTest {

    @Resource
    private BadgeItemURLGenerator badgeItemURLGenerator;

    @Test
    public void testNormalBadgeRetriever() throws ParseException, MalformedURLException, IllegalAccessException {
        String normalURL = "https://api.stackexchange.com/2.2/badges?page=1&pagesize=100&fromdate=1462057200&todate=1463698800&order=asc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!9YdnSQHcv";
        BadgeItemInitializer bii = new BadgeItemInitializer(1, 100, 20160105, 20162005, Order.ASC, MaxMin.BRONZE,
                MaxMin.GOLD, BadgeSortBy.RANK, null, false);
        assertEquals(normalURL, badgeItemURLGenerator.urlGenerator(bii).toString());
    }

    @Test
    public void testNameBadgeRetriever() throws ParseException, MalformedURLException, IllegalAccessException {
        String nameURL = "https://api.stackexchange.com/2.2/badges/name?page=1&pagesize=100&fromdate=1462057200&todate=1463698800&order=desc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!9YdnSQHcv";
        BadgeItemInitializer bii = new BadgeItemInitializer(1, 100, 20160105, 20162005, null, MaxMin.BRONZE,
                MaxMin.GOLD, BadgeSortBy.RANK, null, true);
        assertEquals(nameURL, badgeItemURLGenerator.urlGenerator(bii).toString());
    }

    @Test
    public void testTagBadgeRetriever() throws ParseException, MalformedURLException, IllegalAccessException {
        String nameURL = "https://api.stackexchange.com/2.2/badges/tags?page=1&pagesize=100&fromdate=1462057200&todate=1463698800&order=desc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!9YdnSQHcv";
        BadgeItemInitializer bii = new BadgeItemInitializer(1, 100, 20160105, 20162005, Order.DESC, MaxMin.BRONZE,
                MaxMin.GOLD, BadgeSortBy.RANK, true, null);
        assertEquals(nameURL, badgeItemURLGenerator.urlGenerator(bii).toString());
    }

    @Test
    public void testRecipientBadgeRetriever() throws ParseException, MalformedURLException, IllegalAccessException {
        String nameURL = "https://api.stackexchange.com/2.2/badges/recipients?page=1&pagesize=100&fromdate=1462057200&todate=1463698800&site=stackoverflow&filter=!9YdnSQHcv";
        BadgeItemInitializer bii = new BadgeItemInitializer(1, 100, 20160105, 20162005);
        assertEquals(nameURL, badgeItemURLGenerator.urlGenerator(bii).toString());
    }

    @Test
    public void testIdRecipientBadgeRetriever() throws ParseException, MalformedURLException, IllegalAccessException {
        String nameURL = "https://api.stackexchange.com/2.2/badges/222/recipients?page=1&pagesize=100&fromdate=1462057200&todate=1463698800&site=stackoverflow&filter=!9YdnSQHcv";
        BadgeItemInitializer bii = new BadgeItemInitializer(1, 100, 20160105, 20162005, 222);
        assertEquals(nameURL, badgeItemURLGenerator.urlGenerator(bii).toString());
    }

    @Test
    public void testIdBadgeRetriever() throws ParseException, MalformedURLException, IllegalAccessException {
        String nameURL = "https://api.stackexchange.com/2.2/badges/222?page=1&pagesize=100&fromdate=1462057200&todate=1463698800&order=asc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!9YdnSQHcv";
        BadgeItemInitializer bii = new BadgeItemInitializer(1, 100, 20160105, 20162005, Order.ASC, MaxMin.BRONZE,
                MaxMin.GOLD, BadgeSortBy.RANK, 222);
        assertEquals(nameURL, badgeItemURLGenerator.urlGenerator(bii).toString());
    }
}
