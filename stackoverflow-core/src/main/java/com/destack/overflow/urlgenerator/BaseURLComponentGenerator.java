package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.BaseInitializer;

/**
 * @author Deepak
 *
 */
public class BaseURLComponentGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseURLComponentGenerator.class);

    /**
     * Get base URL Components
     * 
     * @param object
     * @return
     */
    protected String getBaseURLComponents(BaseInitializer object) {
        String url = "";
        url += getPageURL(object.getPage());
        url += getPageSizeURL(object.getPageSize());
        url += getFromDate(object.getFromDate());
        url += getToDate(object.getToDate());
        url += getOrder(object.getOrder());
        if (object.getMin() != null && object.getMin() != 0) {
            LOGGER.info("Min component value : {}", object.getMin());
            url += "&min=".concat(String.valueOf(object.getMin()));
        }
        if (object.getMinDate() != null && object.getMinDate() != 0) {
            LOGGER.info("Min Date component value : {}", object.getMinDate());
            url += "&min=".concat(String.valueOf(object.getMinDate()));
        }
        if (object.getMinString() != null && !object.getMinString().trim().isEmpty()) {
            LOGGER.info("Min String component value : {}", object.getMinString());
            url += "&min=".concat(String.valueOf(object.getMinString()));
        }
        if (object.getMax() != null && object.getMax() != 0) {
            LOGGER.info("Max component value : {}", object.getMaxString());
            url += "&max=".concat(String.valueOf(object.getMax()));
        }
        if (object.getMaxDate() != null && object.getMaxDate() != 0) {
            LOGGER.info("Max Date component value : {}", object.getMaxDate());
            url += "&max=".concat(String.valueOf(object.getMaxDate()));
        }
        if (object.getMaxString() != null && !object.getMaxString().trim().isEmpty()) {
            LOGGER.info("Max String component value : {}", object.getMaxString());
            url += "&max=".concat(String.valueOf(object.getMaxString()));
        }
        return url;
    }

    protected String getPageURL(Integer page) {
        if (page != 0 && page != null) {
            LOGGER.info("page number component value : {}", page);
            return "&page=".concat(String.valueOf(page));
        } else {
            return "";
        }
    }

    protected String getPageSizeURL(Integer pageSize) {
        if (pageSize != 0 && pageSize != null) {
            LOGGER.info("page size component value : {}", pageSize);
            return "&pagesize=".concat(String.valueOf(pageSize));
        } else {
            return "";
        }
    }

    protected String getFromDate(Long fromDate) {
        if (fromDate != 0 && fromDate != null) {
            LOGGER.info("From date component value : {}", fromDate);
            return "&fromdate=".concat(String.valueOf(fromDate));
        } else {
            return "";
        }
    }

    protected String getToDate(Long toDate) {
        if (toDate != 0 && toDate != null) {
            LOGGER.info("To date component value : {}", toDate);
            return "&todate=".concat(String.valueOf(toDate));
        } else {
            return "";
        }
    }

    protected String getOrder(Order order) {
        if (order != null && !order.toString().isEmpty()) {
            LOGGER.info("Order component value : {}", order.toString());
            return "&order=".concat(order.toString());
        } else {
            LOGGER.info("given Order component value is null so using default i.e., : {}", order.toString());
            return "&order=".concat(Order.DESC.toString());
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
                str = str.substring(0, str.lastIndexOf(';'));
            }
            stringSet.clear();
            return str;
        } else {
            return "";
        }
    }

    protected String getIdSetURLComponent(Set<Long> idSet) {
        Set<String> stringSet = new HashSet();
        if (idSet != null && !idSet.isEmpty()) {
            for (Long ids : idSet) {
                stringSet.add(String.valueOf(ids));
            }
        }
        return getSetURLComponent(stringSet);
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
