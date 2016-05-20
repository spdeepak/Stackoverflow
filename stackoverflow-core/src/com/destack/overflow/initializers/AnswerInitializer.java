package com.destack.overflow.initializers;

import java.util.Date;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.SortBy;
import com.destack.overflow.model.AnswerItem;

/**
 * {@link AnswerItem} initializer class.<br/>
 * This class takes input to get a {@link AnswerItem}
 * 
 * @author Deepak
 *
 */
public class AnswerInitializer {

    private Date fromDate;

    private Date max;

    private Date min;

    private Order order;

    private int page;

    private int pageSize;

    private SortBy sort;

    private Date toDate;

    private int vmax;

    private int vmin;

    public AnswerInitializer(int page, int pageSize, Date fromDate, Date toDate, Order order, SortBy sort, Date min,
            Date max) {
        if (!sort.equals(SortBy.VOTES)) {
            this.page = page;
            this.pageSize = pageSize;
            this.fromDate = fromDate;
            this.toDate = toDate;
            this.order = order;
            this.sort = sort;
            this.min = min;
            this.max = max;
        }
    }

    public AnswerInitializer(int page, int pageSize, Date fromDate, Date toDate, Order order, SortBy sort, int vmin,
            int vmax) {
        if (sort.equals(SortBy.VOTES)) {
            this.page = page;
            this.pageSize = pageSize;
            this.fromDate = fromDate;
            this.toDate = toDate;
            this.order = order;
            this.sort = sort;
            this.vmin = vmin;
            this.vmax = vmax;
        }
    }

    public Date getFromDate() {
        return fromDate;
    }

    /**
     * Used when {@link SortBy} is Activity or Creation
     * 
     * @return
     */
    public Date getMax() {
        return max;
    }

    /**
     * Used when {@link SortBy} is Activity or Creation
     * 
     * @return
     */
    public Date getMin() {
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

    public SortBy getSort() {
        return sort;
    }

    public Date getToDate() {
        return toDate;
    }

    /**
     * Used when {@link SortBy} is Votes
     * 
     * @return
     */
    public int getVmax() {
        return vmax;
    }

    /**
     * Used when {@link SortBy} is Votes
     * 
     * @return
     */
    public int getVmin() {
        return vmin;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setMax(Date max) {
        this.max = max;
    }

    public void setMin(Date min) {
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

    public void setSort(SortBy sort) {
        this.sort = sort;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    /**
     * Used when {@link SortBy} is Votes
     * 
     * @param vmax
     */
    public void setVmax(int vmax) {
        this.vmax = vmax;
    }

    /**
     * Used when {@link SortBy} is Votes
     * 
     * @param vmin
     */
    public void setVmin(int vmin) {
        this.vmin = vmin;
    }
}
