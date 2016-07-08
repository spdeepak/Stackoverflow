package com.destack.overflow.fetcher;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.model.BadgeItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class BadgeItemFetcherTest {

    @Resource
    private BadgeItemFetcher badgeItemFetcher;

    @Test
    public void badgesExampleTest() throws FileNotFoundException, MalformedURLException, IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/JSONs/badgesexample.json");
        List<BadgeItem> badgeItems = badgeItemFetcher.objectFetcher(file.toURI().toURL());
        for (BadgeItem badgeItem : badgeItems) {
            assertNotNull(badgeItem);
        }
        assertNull(badgeItems.get(0).getBadgeUser());
        assertTrue(badgeItems.get(0).getBadge_type().equals("named"));
        assertTrue(badgeItems.get(0).getAward_count().equals(6280));
        assertTrue(badgeItems.get(0).getRank().equals("bronze"));
        assertTrue(badgeItems.get(0).getBadge_id().equals(222));
        assertTrue(badgeItems.get(0).getLink().equals("http://stackoverflow.com/badges/222/altruist"));
        assertTrue(badgeItems.get(0).getDescription()
                .equals("First bounty you manually award on another person&#39;s question"));
        assertTrue(badgeItems.get(0).getName().equals("Altruist"));
    }

    @Test
    public void badgesRecipientsExampleTest() throws FileNotFoundException, MalformedURLException, IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/JSONs/badgerecipientsexample.json");
        List<BadgeItem> badgeItems = badgeItemFetcher.objectFetcher(file.toURI().toURL());
        for (BadgeItem badgeItem : badgeItems) {
            assertNotNull(badgeItem);
        }
        assertNotNull(badgeItems.get(0).getBadgeUser());
        assertNotNull(badgeItems.get(0).getBadgeUser().getBadgeCount());
        assertTrue(badgeItems.get(0).getBadge_type().equals("named"));
        assertNull(badgeItems.get(0).getAward_count());
        assertTrue(badgeItems.get(0).getRank().equals("bronze"));
        assertTrue(badgeItems.get(0).getBadge_id().equals(2600));
        assertTrue(badgeItems.get(0).getLink().equals("http://stackoverflow.com/badges/2600/informed"));
        assertTrue(badgeItems.get(0).getDescription()
                .equals("Read the entire <a href=\"http://stackoverflow.com/tour\">tour</a> page"));
        assertTrue(badgeItems.get(0).getName().equals("Informed"));
        assertTrue(badgeItems.get(0).getBadgeUser().getDisplay_name().equals("Jason"));
        assertNotNull(badgeItems.get(0).getBadgeUser().getReputation().equals(1));
        assertNotNull(badgeItems.get(0).getBadgeUser().getUser_id().equals(6397070));
        assertNotNull(badgeItems.get(0).getBadgeUser().getUser_type().equals("registered"));
        assertNotNull(badgeItems.get(0).getBadgeUser().getProfile_image()
                .equals("https://www.gravatar.com/avatar/23b640990b54fd6ae21764ddf7fc91b9?s=128&d=identicon&r=PG&f=1"));
        assertNotNull(
                badgeItems.get(0).getBadgeUser().getLink().equals("http://stackoverflow.com/users/6397070/jason"));
        assertNotNull(badgeItems.get(0).getBadgeUser().getBadgeCount().getBronze().equals(1));
        assertNotNull(badgeItems.get(0).getBadgeUser().getBadgeCount().getSilver().equals(0));
        assertNotNull(badgeItems.get(0).getBadgeUser().getBadgeCount().getGold().equals(0));
    }

}