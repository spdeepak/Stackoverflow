package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.enums.BadgeSortBy;
import com.destack.overflow.enums.MaxMin;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.BadgeItemInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class BadgeItemURLGeneratorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BadgeItemURLGeneratorTest.class);

    @Resource
    private BadgeItemURLGenerator badgeItemURLGenerator;

    /**
     * NORMAL
     */
    @Test
    public void testCreateAllBadgeInitializer() throws ParseException, MalformedURLException, IllegalAccessException {
        BadgeItemInitializer bi = BadgeItemInitializer.createAllBadgeInitializer(1, 100, 20160101L, 20160102L,
                Order.ASC, MaxMin.BRONZE, MaxMin.GOLD, BadgeSortBy.RANK, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/badges?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&order=asc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bi).toString());
        bi = BadgeItemInitializer.createAllBadgeInitializer(1, 100, 20160101L, 20160102L, null, MaxMin.BRONZE,
                MaxMin.GOLD, BadgeSortBy.RANK, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/badges?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&order=desc&sort=rank&min=gold&max=bronze&inname=java&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bi).toString());
    }

    /**
     * NAME
     */
    @Test
    public void testCreateNameBasedBadgeInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        BadgeItemInitializer bi = BadgeItemInitializer.createNameBasedBadgeInitializer(1, 100, 20160101L, 20160102L,
                null, MaxMin.BRONZE, MaxMin.GOLD, BadgeSortBy.RANK, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/badges/name?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&order=desc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bi).toString());
    }

    /**
     * TAG
     */
    @Test
    public void testCreateTagBasedBadgeInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        BadgeItemInitializer bii = BadgeItemInitializer.createTagBasedBadgeInitializer(1, 100, 20160101L, 20160102L,
                Order.DESC, MaxMin.BRONZE, MaxMin.GOLD, BadgeSortBy.RANK, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/badges/tags?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&order=desc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bii).toString());
    }

    /**
     * RECIPIENT
     */
    @Test
    public void testCreateRecipientBasedBadgeInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        BadgeItemInitializer bii = BadgeItemInitializer.createRecipientBasedBadgeInitializer(1, 100, 20160101L,
                20160102L);
        assertEquals(
                "https://api.stackexchange.com/2.2/badges/recipients?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bii).toString());
    }

    /**
     * ID_RECIPIENT
     */
    @Test
    public void testCreateIDRecipientBasedBadgeInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        BadgeItemInitializer bii = BadgeItemInitializer.createIDRecipientBasedBadgeInitializer(1, 100, 20160101L,
                20160102L, new HashSet(Arrays.asList(222L)));
        assertEquals(
                "https://api.stackexchange.com/2.2/badges/222/recipients?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bii).toString());
        try {
            bii = BadgeItemInitializer.createIDRecipientBasedBadgeInitializer(1, 100, 20160101L, 20160102L,
                    new HashSet(Arrays.asList(0L)));
            assertEquals(
                    "https://api.stackexchange.com/2.2/badges/222/recipients?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&site=stackoverflow&filter=!-*f(6qLMLow-",
                    badgeItemURLGenerator.urlGenerator(bii).toString());
        } catch (IllegalArgumentException e) {
            assertEquals("IDs are mandatory", e.getMessage());
        }
        try {
            bii = BadgeItemInitializer.createIDRecipientBasedBadgeInitializer(1, 100, 20160101L, 20160102L, null);
            assertEquals(
                    "https://api.stackexchange.com/2.2/badges/222/recipients?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&site=stackoverflow&filter=!-*f(6qLMLow-",
                    badgeItemURLGenerator.urlGenerator(bii).toString());
        } catch (IllegalArgumentException e) {
            assertEquals("IDs are mandatory", e.getMessage());
        }
    }

    /**
     * ID
     */
    @Test
    public void testCreateIDBasedBadgeInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        BadgeItemInitializer bii = BadgeItemInitializer.createIDBasedBadgeInitializer(1, 100, 20160101L, 20160102L,
                Order.ASC, MaxMin.BRONZE, MaxMin.GOLD, BadgeSortBy.RANK, new HashSet(Arrays.asList(222L)));
        assertEquals(
                "https://api.stackexchange.com/2.2/badges/222?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&order=asc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bii).toString());
        bii = BadgeItemInitializer.createIDBasedBadgeInitializer(1, 100, 20160101L, 20160102L, Order.ASC, MaxMin.BRONZE,
                MaxMin.GOLD, null, new HashSet(Arrays.asList(222L)));
        assertEquals(
                "https://api.stackexchange.com/2.2/badges/222?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&order=asc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bii).toString());
        bii = BadgeItemInitializer.createIDBasedBadgeInitializer(1, 100, 20160101L, 20160102L, Order.ASC, MaxMin.BRONZE,
                MaxMin.GOLD, BadgeSortBy.NAME, new HashSet(Arrays.asList(222L)));
        assertEquals(
                "https://api.stackexchange.com/2.2/badges/222?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&order=asc&sort=name&min=gold&max=bronze&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bii).toString());
        bii = BadgeItemInitializer.createIDBasedBadgeInitializer(1, 100, 20160101L, 20160102L, Order.ASC, MaxMin.BRONZE,
                MaxMin.GOLD, BadgeSortBy.TYPE, new HashSet(Arrays.asList(222L)));
        assertEquals(
                "https://api.stackexchange.com/2.2/badges/222?page=1&pagesize=100&fromdate=1451606400&todate=1454284800&order=asc&sort=type&min=gold&max=bronze&site=stackoverflow&filter=!-*f(6qLMLow-",
                badgeItemURLGenerator.urlGenerator(bii).toString());
    }
}
