package com.destack.overflow.initializers;

import java.text.ParseException;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.CommentSortBy;
import com.destack.overflow.enums.Order;

/**
 * @author Deepak
 *
 */
public class CommentInitializer extends BaseInitializer {

    private long fromDate;

    private long max;

    private long min;

    private Order order;

    private int page;

    private int pageSize;

    private CommentSortBy sort;

    private long toDate;

    private long comment_id;

    public CommentInitializer(int page, int pageSize, long fromDate, long toDate, Order order, CommentSortBy sort,
            Integer min, Integer max, Integer comment_id) throws ParseException {
        this.page = page;
        this.pageSize = pageSize;

        if (this.fromDate > this.toDate) {
            throw new IllegalArgumentException("From Date(" + fromDate + ") is after (" + toDate + ")");
        }

        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate != 0 ? originalFormat.parse(String.valueOf(toDate)).getTime() / 1000 : 0;
        this.order = order != null ? order : Order.DESC;
        this.sort = sort != null ? sort : CommentSortBy.CREATION;

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
        if (comment_id != null) {
            this.comment_id = comment_id;
        } else {
            this.comment_id = 0;
        }
    }

    @Override
    public long getFromDate() {
        return fromDate;
    }

    @Override
    public long getMax() {
        return max;
    }

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

    public CommentSortBy getSort() {
        return sort;
    }

    @Override
    public long getToDate() {
        return toDate;
    }

    public long getComment_id() {
        return comment_id;
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

    public void setSort(CommentSortBy sort) {
        this.sort = sort;
    }

    @Override
    public void setToDate(long toDate) {
        this.toDate = toDate;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }
}
