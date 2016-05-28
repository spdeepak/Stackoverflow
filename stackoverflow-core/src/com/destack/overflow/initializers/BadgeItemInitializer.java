package com.destack.overflow.initializers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EnumSet;

import com.destack.overflow.enums.BadgeRetriever;
import com.destack.overflow.enums.BadgeSortBy;
import com.destack.overflow.enums.MaxMin;
import com.destack.overflow.enums.Order;

/**
 * @author Deepak
 *
 */
public class BadgeItemInitializer {

    private static SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyddMM");

    private long fromDate;

    private MaxMin max;

    private MaxMin min;

    private Order order;

    private int page;

    private int pageSize;

    private long toDate;

    private BadgeSortBy sort;

    private String inName;

    private long badge_id;

    private BadgeRetriever br;

    /**
     * To get all the badges in the system.
     * 
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param max
     * @param min
     * @param sort
     * @param inName
     * @throws ParseException
     */
    public BadgeItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, MaxMin max, MaxMin min,
            BadgeSortBy sort, String inName) throws ParseException {
        this.page = page;
        this.pageSize = pageSize;
        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.order = !order.equals(EnumSet.of(Order.ASC, Order.DESC)) ? Order.DESC : order;
        this.max = !max.equals(EnumSet.of(MaxMin.BRONZE, MaxMin.GOLD, MaxMin.SILVER)) ? null : max;
        this.min = !min.equals(EnumSet.of(MaxMin.BRONZE, MaxMin.GOLD, MaxMin.SILVER)) ? null : min;
        this.sort = !sort.equals(EnumSet.of(BadgeSortBy.NAME, BadgeSortBy.RANK, BadgeSortBy.TYPE)) ? sort
                : BadgeSortBy.RANK;
        this.inName = inName.trim().isEmpty() ? null : inName;
        br = BadgeRetriever.NORMAL;
    }

    /**
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param max
     * @param min
     * @param sort
     * @param badge_id
     * @throws ParseException
     */
    public BadgeItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, MaxMin max, MaxMin min,
            BadgeSortBy sort, long badge_id) throws ParseException {
        this.page = page;
        this.pageSize = pageSize;
        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.order = !order.equals(EnumSet.of(Order.ASC, Order.DESC)) ? Order.DESC : order;
        this.max = !max.equals(EnumSet.of(MaxMin.BRONZE, MaxMin.GOLD, MaxMin.SILVER)) ? null : max;
        this.min = !min.equals(EnumSet.of(MaxMin.BRONZE, MaxMin.GOLD, MaxMin.SILVER)) ? null : min;
        this.sort = !sort.equals(EnumSet.of(BadgeSortBy.NAME, BadgeSortBy.RANK, BadgeSortBy.TYPE)) ? sort
                : BadgeSortBy.RANK;
        this.badge_id = badge_id;
        br = BadgeRetriever.ID;
    }

    /**
     * To get recently awarded badges in the system.
     * 
     * @param page
     * @param pageSize
     * @param formDate
     * @param toDate
     * @throws ParseException
     */
    public BadgeItemInitializer(int page, int pageSize, long fromDate, long toDate) throws ParseException {
        this.page = page;
        this.pageSize = pageSize;
        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        br = BadgeRetriever.RECIPIENT;

    }

    /**
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param badge_id
     * @throws ParseException
     */
    public BadgeItemInitializer(int page, int pageSize, long fromDate, long toDate, long badge_id)
            throws ParseException {
        this.page = page;
        this.pageSize = pageSize;
        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.badge_id = badge_id;
        br = BadgeRetriever.ID_RECIPIENT;

    }

    public long getFromDate() {
        return fromDate;
    }

    public MaxMin getMax() {
        return max;
    }

    public MaxMin getMin() {
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

    public BadgeSortBy getSort() {
        return sort;
    }

    public String getInName() {
        return inName;
    }

    public BadgeRetriever getBr() {
        return br;
    }

    public long getBadge_id() {
        return badge_id;
    }

    public void setBadge_id(long badge_id) {
        this.badge_id = badge_id;
    }

    public void setBr(BadgeRetriever br) {
        this.br = br;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public void setSort(BadgeSortBy sort) {
        this.sort = sort;
    }

    public void setFromDate(long fromDate) {
        this.fromDate = fromDate;
    }

    public void setMax(MaxMin max) {
        this.max = max;
    }

    public void setMin(MaxMin min) {
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
