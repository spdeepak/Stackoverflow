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
    public void test() throws ParseException, MalformedURLException {
        String url = "https://api.stackexchange.com/2.2/badges?page=1&pagesize=100&fromdate=1462057200&todate=1463698800&order=desc&sort=rank&min=gold&max=bronze&site=stackoverflow&filter=!9YdnSQHcv";
        BadgeItemInitializer bii = new BadgeItemInitializer(1, 100, 20160105, 20162005, Order.DESC, MaxMin.BRONZE,
                MaxMin.GOLD, BadgeSortBy.RANK, null);
        assertEquals(url, badgeItemURLGenerator.urlGenerator(bii).toString());
    }

}
