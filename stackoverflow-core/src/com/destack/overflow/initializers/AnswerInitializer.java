package com.destack.overflow.initializers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.model.AnswerItem;

/**
 * {@link AnswerItem} initializer class.<br/>
 * 
 * @author Deepak
 *
 */
public class AnswerInitializer extends BaseInitializer {

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
     *            required page
     * @param pageSize
     *            number of {@link AnswerItem} in a page
     * @param fromDate
     * @param toDate
     * @param order
     *            Sort {@link Order} of {@link AnswerItem}'s
     * @param sort
     * @param min
     *            is a Date if {@link AnswerSortBy} is not {@link AnswerSortBy}.VOTES
     * @param max
     *            is a Date if {@link AnswerSortBy} is not {@link AnswerSortBy}.VOTES
     * @throws ParseException
     */
    public AnswerInitializer(int page, int pageSize, long fromDate, long toDate, Order order, AnswerSortBy sort,
            Integer min, Integer max) throws ParseException {
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

    @Override
    public long getFromDate() {
        return fromDate;
    }

    /**
     * Used when {@link AnswerSortBy} is Activity or Creation
     * 
     * @return
     */
    @Override
    public long getMax() {
        return max;
    }

    /**
     * Used when {@link AnswerSortBy} is Activity or Creation
     * 
     * @return
     */
    @Override
    public long getMin() {
        return min;
    }

    @Override
    public Order getOrder() {
        return order;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    public AnswerSortBy getSort() {
        return sort;
    }

    @Override
    public long getToDate() {
        return toDate;
    }

    @Override
    public void setFromDate(long fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public void setMax(long max) {
        this.max = max;
    }

    @Override
    public void setMin(long min) {
        this.min = min;
    }

    @Override
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSort(AnswerSortBy sort) {
        this.sort = sort;
    }

    @Override
    public void setToDate(long toDate) {
        this.toDate = toDate;
    }
}
