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
        url += getMin(object.getMin());
        url += getMin(object.getMinDate());
        url += getMin(object.getMinString());
        url += getMax(object.getMax());
        url += getMax(object.getMaxDate());
        url += getMax(object.getMaxString());
        return url;
    }

    protected String getPageURL(Integer page) {
        if (page != null && page != 0) {
            LOGGER.info("page number component value : {}", page);
            return "&page=".concat(String.valueOf(page));
        } else {
            return "";
        }
    }

    protected String getPageSizeURL(Integer pageSize) {
        if (pageSize != null && pageSize != 0) {
            LOGGER.info("page size component value : {}", pageSize);
            return "&pagesize=".concat(String.valueOf(pageSize));
        } else {
            return "";
        }
    }

    protected String getFromDate(Long fromDate) {
        if (fromDate != null && fromDate != 0) {
            LOGGER.info("From date component value : {}", fromDate);
            return "&fromdate=".concat(String.valueOf(fromDate));
        } else {
            return "";
        }
    }

    protected String getToDate(Long toDate) {
        if (toDate != null && toDate != 0) {
            LOGGER.info("To date component value : {}", toDate);
            return "&todate=".concat(String.valueOf(toDate));
        } else {
            return "";
        }
    }

    protected String getOrder(Order order) {
        if (Order.validate(order)) {
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

    protected String getMin(Long min) {
        if (min != null && min != 0) {
            return "&min=".concat(String.valueOf(min));
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

    protected String getMax(Long max) {
        if (max != null && max != 0) {
            return "&max=".concat(String.valueOf(max));
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
        String str = "";
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
