package com.destack.overflow.initializers;

import com.destack.overflow.enums.BadgeSortBy;
import com.destack.overflow.enums.Order;

/**
 * @author Deepak
 *
 */
public class BadgeItemInitializer {

    private long fromDate;

    private String max;

    private String min;

    private Order order;

    private int page;

    private int pageSize;

    private long toDate;

    private long badge_id;

    private BadgeSortBy sort;

    /**
     * 
     */
    public BadgeItemInitializer() {
    }

    public long getFromDate() {
        return fromDate;
    }


    public String getMax() {
        return max;
    }


    public String getMin() {
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

    public long getBadge_id() {
        return badge_id;
    }

    public BadgeSortBy getSort() {
        return sort;
    }

    public void setSort(BadgeSortBy sort) {
        this.sort = sort;
    }

    public void setBadge_id(long badge_id) {
        this.badge_id = badge_id;
    }


    public void setFromDate(long fromDate) {
        this.fromDate = fromDate;
    }


    public void setMax(String max) {
        this.max = max;
    }


    public void setMin(String min) {
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
