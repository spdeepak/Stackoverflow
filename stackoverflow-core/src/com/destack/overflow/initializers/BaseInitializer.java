package com.destack.overflow.initializers;

import java.text.SimpleDateFormat;

import com.destack.overflow.enums.Order;

/**
 * @author Deepak
 *
 */
public class BaseInitializer {

    protected static SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyddMM");

    private long fromDate;

    private long max;

    private long min;

    private long maxDate;

    private long minDate;

    private String minString;

    private String maxString;

    private Order order;

    private int page;

    private int pageSize;

    private long toDate;

    public long getFromDate() {
        return fromDate;
    }

    public long getMax() {
        return max;
    }

    public long getMin() {
        return min;
    }

    public Order getOrder() {
        return order;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public long getToDate() {
        return toDate;
    }

    public long getMaxDate() {
        return maxDate;
    }

    public long getMinDate() {
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

    public void setMaxDate(long maxDate) {
        this.maxDate = maxDate;
    }

    public void setMinDate(long minDate) {
        this.minDate = minDate;
    }

    public void setFromDate(long fromDate) {
        this.fromDate = fromDate;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setToDate(long toDate) {
        this.toDate = toDate;
    }

}
