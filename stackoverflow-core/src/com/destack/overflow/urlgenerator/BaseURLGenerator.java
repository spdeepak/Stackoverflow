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
}
