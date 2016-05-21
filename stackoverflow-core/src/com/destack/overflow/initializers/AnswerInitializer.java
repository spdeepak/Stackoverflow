package com.destack.overflow.initializers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.model.AnswerItem;

/**
 * {@link AnswerItem} initializer class.<br/>
 * This class takes input to get a {@link AnswerItem}
 * 
 * @author Deepak
 *
 */
public class AnswerInitializer {

    private static SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyddMM");

    private long fromDate;

    private long max;

    private long min;

    private Order order;

    private int page;

    private int pageSize;

    private AnswerSortBy sort;

    private long toDate;

    /**
     * <b>NOTE</b>:Dates in the format of 'yyyyddMM'
     * 
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param sort
     * @param min
     * @param max
     * @throws ParseException
     */
    public AnswerInitializer(int page, int pageSize, long fromDate, long toDate, Order order, AnswerSortBy sort, Integer min,
            Integer max) throws ParseException {
        this.page = page;
        this.pageSize = pageSize;

        if (this.fromDate > this.toDate) {
            throw new IllegalArgumentException("From Date(" + fromDate + ") is after (" + toDate + ")");
        }

        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate != 0 ? originalFormat.parse(String.valueOf(toDate)).getTime() / 1000 : 0;
        this.order = order != null ? order : Order.DESC;
        this.sort = sort != null ? sort : AnswerSortBy.ACTIVITY;

        if (this.min > this.max) {
            throw new IllegalArgumentException("Min (" + min + ") is greater than (" + max + ")");
        }

        if (this.sort.equals(AnswerSortBy.VOTES)) {
            this.min = min.longValue();
            this.max = max.longValue();
        }

        if (!this.sort.equals(AnswerSortBy.VOTES) && min > 20081509 && max > 20081509) {
            this.min = originalFormat.parse(String.valueOf(min)).getTime() / 1000;
            this.max = originalFormat.parse(String.valueOf(max)).getTime() / 1000;
        }
        if (!this.sort.equals(AnswerSortBy.VOTES) && min < 20081509 && max < 20081509) {
            this.min = 0;
            this.max = 0;
        }
    }

    public long getFromDate() {
        return fromDate;
    }

    /**
     * Used when {@link AnswerSortBy} is Activity or Creation
     * 
     * @return
     */
    public long getMax() {
        return max;
    }

    /**
     * Used when {@link AnswerSortBy} is Activity or Creation
     * 
     * @return
     */
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

    public AnswerSortBy getSort() {
        return sort;
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

    public void setSort(AnswerSortBy sort) {
        this.sort = sort;
    }

    public void setToDate(long toDate) {
        this.toDate = toDate;
    }
}
