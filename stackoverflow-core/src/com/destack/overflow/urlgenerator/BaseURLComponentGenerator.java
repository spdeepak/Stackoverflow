package com.destack.overflow.urlgenerator;

import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.BaseInitializer;

/**
 * @author Deepak
 *
 */
public class BaseURLComponentGenerator {

    /**
     * Get base URL
     * 
     * @param object
     * @return
     */
    protected String getBaseURL(BaseInitializer object) {
        String url = null;
        if (object.getFromDate() != 0) {
            url += "&fromdate=".concat(String.valueOf(object.getFromDate()));
        }
        if (object.getMax() != 0) {
            url += "&max=".concat(String.valueOf(object.getMax()));
        }
        if (object.getMaxDate() != 0) {
            url += "&max=".concat(String.valueOf(object.getMaxDate()));
        }
        if (object.getMaxString() != null && !object.getMaxString().trim().isEmpty()) {
            url += "&max=".concat(String.valueOf(object.getMaxString()));
        }
        if (object.getMin() != 0) {
            url += "&min=".concat(String.valueOf(object.getMin()));
        }
        if (object.getMinDate() != 0) {
            url += "&min=".concat(String.valueOf(object.getMinDate()));
        }
        if (object.getMinString() != null && !object.getMinString().trim().isEmpty()) {
            url += "&min=".concat(String.valueOf(object.getMinString()));
        }
        if (object.getOrder() != null && !object.getOrder().toString().isEmpty()) {
            url += "&order=".concat(object.getOrder().toString());
        } else {
            url += "&order=".concat(Order.DESC.toString());
        }
        if (object.getPage() != 0) {
            url += "&page=".concat(String.valueOf(object.getPage()));
        }
        if (object.getPageSize() != 0) {
            url += "&pagesize=".concat(String.valueOf(object.getPageSize()));
        }
        if (object.getToDate() != 0) {
            url += "&todate=".concat(String.valueOf(object.getToDate()));
        }
        url += "&site=stackoverflow";
        return url;
    }

    protected String getPageURL(Integer i) {
        return "&page=".concat(String.valueOf(i));
    }

    protected String getPageSizeURL(Integer i) {
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
