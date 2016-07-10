package com.destack.overflow.initializers;

import java.text.SimpleDateFormat;

import com.destack.overflow.enums.Order;

/**
 * @author Deepak
 *
 */
public class BaseInitializer {

    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyddMM");

    private Long fromDate;

    private Long max;

    private Long min;

    private Long maxDate;

    private Long minDate;

    private String minString;

    private String maxString;

    private Order order;

    private Integer page;

    private Integer pageSize;

    private Long toDate;

    public Long getFromDate() {
        return fromDate;
    }

    public Long getMax() {
        return max;
    }

    public Long getMin() {
        return min;
    }

    public Order getOrder() {
        return order;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Long getToDate() {
        return toDate;
    }

    public Long getMaxDate() {
        return maxDate;
    }

    public Long getMinDate() {
        return minDate;
    }

    public String getMinString() {
        return minString;
    }

    public String getMaxString() {
        return maxString;
    }

    public void setMinString(String minString) {
        this.minString = minString;
    }

    public void setMaxString(String maxString) {
        this.maxString = maxString;
    }

    public void setMaxDate(Long maxDate) {
        this.maxDate = maxDate;
    }

    public void setMinDate(Long minDate) {
        this.minDate = minDate;
    }

    public void setFromDate(Long fromDate) {
        this.fromDate = fromDate;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setToDate(Long toDate) {
        this.toDate = toDate;
    }

    public static SimpleDateFormat getDateFormat() {
        return DATE_FORMAT;
    }

}
