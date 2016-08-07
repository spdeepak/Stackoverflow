package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.HashSet;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.BaseInitializer;
import com.destack.overflow.util.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class BaseURLComponentGeneratorTest {

    @Resource
    private BaseURLComponentGenerator baseURLComponentGenerator;

    @Test
    public void testGetPageURL() {
        assertEquals("&page=123", baseURLComponentGenerator.getPageURL(123));
        assertEquals("", baseURLComponentGenerator.getPageURL(null));
    }

    @Test
    public void testGetPageSizeURL() {
        assertEquals("&pagesize=123", baseURLComponentGenerator.getPageSizeURL(123));
        assertEquals("", baseURLComponentGenerator.getPageSizeURL(null));
    }

    @Test
    public void testGetFromDate() throws ParseException {
        assertEquals("&fromdate=1470009600",
                baseURLComponentGenerator.getFromDate(DateUtils.dateToMilliSecondsConverter(20160108L)));
        assertEquals("", baseURLComponentGenerator.getFromDate(null));
    }

    @Test
    public void testGetToDate() throws ParseException {
        assertEquals("&todate=1470009600",
                baseURLComponentGenerator.getToDate(DateUtils.dateToMilliSecondsConverter(20160108L)));
        assertEquals("", baseURLComponentGenerator.getToDate(null));
    }

    @Test
    public void testGetOrder() {
        assertEquals("&order=asc", baseURLComponentGenerator.getOrder(Order.ASC));
        assertEquals("&order=desc", baseURLComponentGenerator.getOrder(Order.DESC));
        assertEquals("&order=desc", baseURLComponentGenerator.getOrder(null));
    }

    @Test
    public void testGetSortURLComponent() {
        assertEquals("&sort=sort", baseURLComponentGenerator.getSortURLComponent("sort"));
        assertEquals("", baseURLComponentGenerator.getSortURLComponent(null));
    }

    @Test
    public void testGetMin() {
        assertEquals("&min=sort", baseURLComponentGenerator.getMin("sort"));
        assertEquals("", baseURLComponentGenerator.getMin(""));

        assertEquals("&min=1234", baseURLComponentGenerator.getMin(1234L));
        assertEquals("", baseURLComponentGenerator.getMin(0L));
    }

    @Test
    public void testGetMax() {
        assertEquals("&max=sort", baseURLComponentGenerator.getMax("sort"));
        assertEquals("", baseURLComponentGenerator.getMax(""));

        assertEquals("&max=1234", baseURLComponentGenerator.getMax(1234L));
        assertEquals("", baseURLComponentGenerator.getMax(0L));
    }

    @Test
    public void testGetInNameURLComponent() {
        assertEquals("&inname=sort", baseURLComponentGenerator.getInNameURLComponent("sort"));
        assertEquals("", baseURLComponentGenerator.getInNameURLComponent(""));

    }

    @Test
    public void testGetSetURLComponent() {
        assertEquals("java;scala", baseURLComponentGenerator.getSetURLComponent(new HashSet<String>() {

            {
                add("java");
                add("scala");
            }
        }));
        assertEquals("", baseURLComponentGenerator.getSetURLComponent(null));
    }

    @Test
    public void testGetIdSetURLComponent() {
        assertEquals("1234;3214", baseURLComponentGenerator.getIdSetURLComponent(new HashSet<Long>() {

            {
                add(1234L);
                add(3214L);
            }
        }));
        assertEquals("", baseURLComponentGenerator.getIdSetURLComponent(null));
    }

    @Test
    public void testURLFixer() {
        assertEquals("?sampleURL&site=stackoverflow", baseURLComponentGenerator.urlFixer("?&sampleURL"));
        assertEquals("?sampleURL&site=stackoverflow", baseURLComponentGenerator.urlFixer("?sampleURL"));
    }

    @Test
    public void testGetBaseURLComponents() throws ParseException {
        BaseInitializer bi = new BaseInitializer();
        bi.setPage(1);
        bi.setPageSize(100);
        bi.setFromDate(DateUtils.dateToMilliSecondsConverter(20160105L));
        bi.setToDate(DateUtils.dateToMilliSecondsConverter(20160205L));
        bi.setOrder(Order.ASC);
        bi.setMin(123L);
        bi.setMax(223L);
        assertEquals("&page=1&pagesize=100&fromdate=1462060800&todate=1462147200&order=asc&min=123&max=223",
                baseURLComponentGenerator.getBaseURLComponents(bi));

        bi = null;
        bi = new BaseInitializer();
        bi.setPage(1);
        bi.setPageSize(100);
        bi.setFromDate(DateUtils.dateToMilliSecondsConverter(20160105L));
        bi.setToDate(DateUtils.dateToMilliSecondsConverter(20160205L));
        bi.setOrder(Order.ASC);
        bi.setMinString("minString");
        bi.setMaxString("maxString");
        assertEquals("&page=1&pagesize=100&fromdate=1462060800&todate=1462147200&order=asc&min=minString&max=maxString",
                baseURLComponentGenerator.getBaseURLComponents(bi));
    }
}
