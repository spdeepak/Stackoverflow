package com.destack.overflow.initializers;

import java.text.ParseException;
import java.util.EnumSet;

import com.destack.overflow.enums.BadgeRetriever;
import com.destack.overflow.enums.BadgeSortBy;
import com.destack.overflow.enums.MaxMin;
import com.destack.overflow.enums.Order;

/**
 * @author Deepak
 *
 */
public class BadgeItemInitializer extends BaseInitializer {

    private MaxMin bMax;

    private MaxMin bMin;

    private BadgeSortBy sort;

    private String inName;

    private long badge_id;

    private BadgeRetriever br;

    /**
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param bMax
     * @param bMin
     * @param sort
     * @param inName
     * @param tagRequried
     * @param nameRequired
     * @throws ParseException
     */
    public BadgeItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, MaxMin max, MaxMin min,
            BadgeSortBy sort, String inName, boolean nameRequired) throws ParseException {
        setPage(page);
        setPageSize(pageSize);
        setFromDate(fromDate > 20081509 ? DATE_FORMAT.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? DATE_FORMAT.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        setOrder(order != null ? order : Order.DESC);
        setbMax((max.equals(MaxMin.BRONZE) || max.equals(MaxMin.GOLD) || max.equals(MaxMin.SILVER)) ? max : null);
        setbMin((max.equals(MaxMin.BRONZE) || max.equals(MaxMin.GOLD) || max.equals(MaxMin.SILVER)) ? min : null);
        setSort(!sort.equals(EnumSet.of(BadgeSortBy.NAME, BadgeSortBy.RANK, BadgeSortBy.TYPE)) ? sort
                : BadgeSortBy.RANK);
        this.inName = (inName != null && inName.trim().isEmpty()) ? null : inName;
        if (nameRequired) {
            br = BadgeRetriever.NAME;
        } else {
            br = BadgeRetriever.NORMAL;
        }
    }

    public BadgeItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, MaxMin max, MaxMin min,
            BadgeSortBy sort, boolean tagRequired, String inName) throws ParseException {
        setPage(page);
        setPageSize(pageSize);
        setFromDate(fromDate > 20081509 ? DATE_FORMAT.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? DATE_FORMAT.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        setOrder(order != null ? order : Order.DESC);
        setbMax((max.equals(MaxMin.BRONZE) || max.equals(MaxMin.GOLD) || max.equals(MaxMin.SILVER)) ? max : null);
        setbMin((max.equals(MaxMin.BRONZE) || max.equals(MaxMin.GOLD) || max.equals(MaxMin.SILVER)) ? min : null);
        setSort(!sort.equals(EnumSet.of(BadgeSortBy.NAME, BadgeSortBy.RANK, BadgeSortBy.TYPE)) ? sort
                : BadgeSortBy.RANK);
        this.inName = (inName != null && inName.trim().isEmpty()) ? null : inName;
        if (tagRequired) {
            br = BadgeRetriever.TAG;
        } else {
            br = BadgeRetriever.NORMAL;
        }
    }

    /**
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param bMax
     * @param bMin
     * @param sort
     * @param badge_id
     * @throws ParseException
     */
    public BadgeItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, MaxMin max, MaxMin min,
            BadgeSortBy sort, long badge_id) throws ParseException {
        setPage(page);
        setPageSize(pageSize);
        setFromDate(fromDate > 20081509 ? DATE_FORMAT.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? DATE_FORMAT.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        setOrder(order != null ? order : Order.DESC);
        setbMax((max.equals(MaxMin.BRONZE) || max.equals(MaxMin.GOLD) || max.equals(MaxMin.SILVER)) ? max : null);
        setbMin((max.equals(MaxMin.BRONZE) || max.equals(MaxMin.GOLD) || max.equals(MaxMin.SILVER)) ? min : null);
        setSort(!sort.equals(EnumSet.of(BadgeSortBy.NAME, BadgeSortBy.RANK, BadgeSortBy.TYPE)) ? sort
                : BadgeSortBy.RANK);
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
        setPage(page);
        setPageSize(pageSize);
        setFromDate(fromDate > 20081509 ? DATE_FORMAT.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? DATE_FORMAT.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
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
        setPage(page);
        setPageSize(pageSize);
        setFromDate(fromDate > 20081509 ? DATE_FORMAT.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? DATE_FORMAT.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        this.badge_id = badge_id;
        br = BadgeRetriever.ID_RECIPIENT;
    }

    public MaxMin getbMax() {
        return bMax;
    }

    public MaxMin getbMin() {
        return bMin;
    }

    public BadgeSortBy getSort() {
        return sort;
    }

    public String getInName() {
        return inName;
    }

    public long getBadge_id() {
        return badge_id;
    }

    public BadgeRetriever getBr() {
        return br;
    }

    public void setbMax(MaxMin bMax) {
        this.bMax = bMax;
    }

    public void setbMin(MaxMin bMin) {
        this.bMin = bMin;
    }

    public void setSort(BadgeSortBy sort) {
        this.sort = sort;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public void setBadge_id(long badge_id) {
        this.badge_id = badge_id;
    }

    public void setBr(BadgeRetriever br) {
        this.br = br;
    }

}
