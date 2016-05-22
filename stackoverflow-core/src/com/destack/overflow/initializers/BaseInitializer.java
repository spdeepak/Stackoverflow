package com.destack.overflow.initializers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.destack.overflow.enums.Order;

public class BaseInitializer {

    protected static SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyddMM");

    private long fromDate;

    private long max;

    private long min;

    private Order order;

    private int page;

    private int pageSize;

    private long toDate;

    public BaseInitializer() {

    }
    public BaseInitializer(int page, int pageSize, long fromDate, long toDate, Order order, Integer min, Integer max)
            throws ParseException {
        this.page = page;
        this.pageSize = pageSize;

        if (this.fromDate > this.toDate) {
            throw new IllegalArgumentException("From Date(" + fromDate + ") is after (" + toDate + ")");
        }

        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate != 0 ? originalFormat.parse(String.valueOf(toDate)).getTime() / 1000 : 0;
        this.order = order != null ? order : Order.DESC;

        if (this.min > this.max) {
            throw new IllegalArgumentException("Min (" + min + ") is greater than (" + max + ")");
        }

        if (min > 20081509 && max > 20081509) {
            this.min = originalFormat.parse(String.valueOf(min)).getTime() / 1000;
            this.max = originalFormat.parse(String.valueOf(max)).getTime() / 1000;
        } else if (min < 20081509 && max < 20081509) {
            this.min = 0;
            this.max = 0;
        } else {
            this.min = min.longValue();
            this.max = max.longValue();
        }
    }

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
