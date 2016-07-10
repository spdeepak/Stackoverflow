package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.util.Set;

import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.BaseInitializer;

/**
 * @author Deepak
 *
 */
public class BaseURLComponentGenerator {

    /**
     * Get base URL Components
     * 
     * @param object
     * @return
     */
    protected String getBaseURLComponents(BaseInitializer object) {
        String url = "";
        if (object.getPage() != null && object.getPage() != 0) {
            url += "&page=".concat(String.valueOf(object.getPage()));
        }
        if (object.getPageSize() != null && object.getPageSize() != 0) {
            url += "&pagesize=".concat(String.valueOf(object.getPageSize()));
        }
        if (object.getFromDate() != null && object.getFromDate() != 0) {
            url += "&fromdate=".concat(String.valueOf(object.getFromDate()));
        }
        if (object.getToDate() != null && object.getToDate() != 0) {
            url += "&todate=".concat(String.valueOf(object.getToDate()));
        }
        if (object.getOrder() != null && !object.getOrder().toString().isEmpty()) {
            url += "&order=".concat(object.getOrder().toString());
        } else {
            url += "&order=".concat(Order.DESC.toString());
        }
        if (object.getMin() != null && object.getMin() != 0) {
            url += "&min=".concat(String.valueOf(object.getMin()));
        }
        if (object.getMinDate() != null && object.getMinDate() != 0) {
            url += "&min=".concat(String.valueOf(object.getMinDate()));
        }
        if (object.getMinString() != null && !object.getMinString().trim().isEmpty()) {
            url += "&min=".concat(String.valueOf(object.getMinString()));
        }
        if (object.getMax() != null && object.getMax() != 0) {
            url += "&max=".concat(String.valueOf(object.getMax()));
        }
        if (object.getMaxDate() != null && object.getMaxDate() != 0) {
            url += "&max=".concat(String.valueOf(object.getMaxDate()));
        }
        if (object.getMaxString() != null && !object.getMaxString().trim().isEmpty()) {
            url += "&max=".concat(String.valueOf(object.getMaxString()));
        }
        if (object.getMaxString() != null && !object.getMaxString().trim().isEmpty()) {
            url += "&max=".concat(String.valueOf(object.getMaxString()));
        }
        return url;
    }

    protected String getPageURL(Integer page) {
        if (page != 0 && page != null) {
            return "&page=".concat(String.valueOf(page));
        } else {
            return "";
        }
    }

    protected String getPageSizeURL(Integer pageSize) {
        if (pageSize != 0 && pageSize != null) {
            return "&pagesize=".concat(String.valueOf(pageSize));
        } else {
            return "";
        }
    }

    protected String getFromDate(Long fromDate) {
        if (fromDate != 0 && fromDate != null) {
            return "&fromdate=".concat(String.valueOf(fromDate));
        } else {
            return "";
        }
    }

    protected String getToDate(Long toDate) {
        if (toDate != 0 && toDate != null) {
            return "&todate=".concat(String.valueOf(toDate));
        } else {
            return "";
        }
    }

    protected String getOrder(String order) {
        if (order != null && !order.trim().isEmpty()) {
            return "&order=".concat(order);
        } else {
            return "";
        }
    }

    protected String getSortURLComponent(String sort) {
        if (sort != null && !sort.trim().isEmpty()) {
            return "&sort=".concat(sort);
        } else {
            return "";
        }
    }

    protected String getMin(String min) {
        if (min != null && !min.trim().isEmpty()) {
            return "&min=".concat(min);
        } else {
            return "";
        }
    }

    protected String getMax(String max) {
        if (max != null && !max.trim().isEmpty()) {
            return "&max=".concat(max);
        } else {
            return "";
        }
    }

    protected String getInNameURLComponent(String inName) {
        if (inName != null && !inName.trim().isEmpty()) {
            return "&inname=".concat(inName);
        } else {
            return "";
        }
    }

    protected String getSetURLComponent(Set<String> stringSet) {
        String str = null;
        if (stringSet != null && !stringSet.isEmpty()) {
            for (String st : stringSet) {
                str += st.trim().concat(";");
            }
            if (str != null && str.endsWith(";")) {
                //removes the last ;
                str = str.substring(0, str.lastIndexOf(";"));
            }
            return str;
        } else {
            return "";
        }
    }

    /**
     * Fixes {@link URL} if it contains "?&" which can be a {@link MalformedURLException}
     * 
     * @param url
     *            {@link URL} in {@link String} format
     * @return Properly Formed URL
     */
    protected String urlFixer(String url) {
        if (url.contains("?&")) {
            url = url.replace("?&", "?");
            return url.concat("&site=stackoverflow");
        }
        return url.concat("&site=stackoverflow");
    }
}
