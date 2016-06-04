package com.destack.overflow.urlgenerator;

/**
 * @author Deepak
 *
 */
public class BaseURLGenerator {

    protected String getPage(Integer i) {
        return "&page=".concat(String.valueOf(i));
    }

    protected String getPageSize(Integer i) {
        return "&pagesize=".concat(String.valueOf(i));
    }

    protected String getFromDate(Long l) {
        return "&fromdate=".concat(String.valueOf(l));
    }

    protected String getToDate(Long l) {
        return "&todate=".concat(String.valueOf(l));
    }

    protected String getOrder(String s) {
        return "&order=".concat(s);
    }

    protected String getSort(String s) {
        return "&sort=".concat(s);
    }

    protected String getMin(String min) {
        return "&min=".concat(min);
    }

    protected String getMax(String max) {
        return "&max=".concat(max);
    }

    protected String getInName(String inName) {
        return "&inname=".concat(inName);
    }

    protected String urlFixer(String url) {
        if (url.contains("?&")) {
            url = url.replace("?&", "?");
            return url;
        }
        return "";
    }
}
