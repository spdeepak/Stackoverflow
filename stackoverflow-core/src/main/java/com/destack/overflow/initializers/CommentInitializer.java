package com.destack.overflow.initializers;

import java.text.ParseException;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.CommentSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.model.AnswerItem;
import com.destack.overflow.model.CommentItem;

/**
 * {@link CommentItem} initializer class.<br/>
 * 
 * @author Deepak
 *
 */
public class CommentInitializer extends BaseInitializer {

    private Long fromDate;

    private Long max;

    private Long min;

    private Order order;

    private Integer page;

    private Integer pageSize;

    private CommentSortBy sort;

    private Long toDate;

    private Long comment_id;

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
     * @param comment_id
     * @throws ParseException
     */
    public CommentInitializer(Integer page, Integer pageSize, Long fromDate, Long toDate, Order order,
            CommentSortBy sort, Long min, Long max, Long comment_id) throws ParseException {
        this.page = page;
        this.pageSize = pageSize;

        if (fromDate != null && toDate != null) {
            if (fromDate > toDate) {
                throw new IllegalArgumentException("From Date(" + fromDate + ") is after (" + toDate + ")");
            } else {
                this.fromDate = fromDate > 20081509 ? DATE_FORMAT.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
                this.toDate = toDate != 0 ? DATE_FORMAT.parse(String.valueOf(toDate)).getTime() / 1000 : 0;
            }
        }
        this.order = order != null ? order : Order.DESC;
        this.sort = sort != null ? sort : CommentSortBy.CREATION;

        if (max != null && min != null) {
            if (min.equals(min) || max > max) {
                if (this.sort.equals(AnswerSortBy.VOTES)) {
                    this.min = min.longValue();
                    this.max = max.longValue();
                }
                if (!this.sort.equals(AnswerSortBy.VOTES) && min > 20081509 && max > 20081509) {
                    this.min = DATE_FORMAT.parse(String.valueOf(min)).getTime() / 1000;
                    this.max = DATE_FORMAT.parse(String.valueOf(max)).getTime() / 1000;
                }
                if (!this.sort.equals(AnswerSortBy.VOTES) && min < 20081509 && max < 20081509) {
                    this.min = 0L;
                    this.max = 0L;
                }
            }
        }

        if (comment_id != null) {
            this.comment_id = comment_id;
        } else {
            this.comment_id = 0L;
        }
    }

    @Override
    public Long getFromDate() {
        return fromDate;
    }

    @Override
    public Long getMax() {
        return max;
    }

    @Override
    public Long getMin() {
        return min;
    }

    @Override
    public Order getOrder() {
        return order;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    public CommentSortBy getSort() {
        return sort;
    }

    @Override
    public Long getToDate() {
        return toDate;
    }

    public Long getComment_id() {
        return comment_id;
    }

    @Override
    public void setFromDate(Long fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public void setMax(Long max) {
        this.max = max;
    }

    @Override
    public void setMin(Long min) {
        this.min = min;
    }

    @Override
    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSort(CommentSortBy sort) {
        this.sort = sort;
    }

    @Override
    public void setToDate(Long toDate) {
        this.toDate = toDate;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }
}
