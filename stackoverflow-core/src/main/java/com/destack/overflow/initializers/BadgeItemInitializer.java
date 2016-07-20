package com.destack.overflow.initializers;

import java.text.ParseException;
import java.util.Set;

import org.codehaus.plexus.util.StringUtils;

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

    private Set<Long> badge_id;

    private BadgeRetriever br;

    private static BadgeItemInitializer badgeItemInitializer;

    private BadgeItemInitializer() {
    }

    private static void setup() {
        badgeItemInitializer = null;
        badgeItemInitializer = new BadgeItemInitializer();
    }

    public static BadgeItemInitializer createAllBadgeInitializer(int page, int pageSize, long fromDate, long toDate,
            Order order, MaxMin max, MaxMin min, BadgeSortBy sort, String inName) throws ParseException {
        setup();
        badgeItemInitializer.setPage(page);
        badgeItemInitializer.setPageSize(pageSize);
        badgeItemInitializer.setFromDate(badgeItemInitializer.dateConverter(fromDate));
        badgeItemInitializer.setToDate(badgeItemInitializer.dateConverter(toDate));
        badgeItemInitializer.setOrder(Order.isValid(order) ? order : Order.DESC);
        badgeItemInitializer.setbMax(MaxMin.isValid(max) ? max : null);
        badgeItemInitializer.setbMin(MaxMin.isValid(min) ? min : null);
        badgeItemInitializer.setSort(BadgeSortBy.isValid(sort) ? sort : BadgeSortBy.RANK);
        badgeItemInitializer.setInName(!StringUtils.isEmpty(inName) ? inName : "");
        badgeItemInitializer.setBr(BadgeRetriever.NORMAL);
        return badgeItemInitializer;
    }

    public static BadgeItemInitializer createNameBasedBadgeInitializer(int page, int pageSize, long fromDate,
            long toDate, Order order, MaxMin max, MaxMin min, BadgeSortBy sort, String inName) throws ParseException {
        setup();
        badgeItemInitializer = createAllBadgeInitializer(page, pageSize, fromDate, toDate, order, max, min, sort,
                inName);
        badgeItemInitializer.setBr(BadgeRetriever.NAME);
        return badgeItemInitializer;
    }

    public static BadgeItemInitializer createTagBasedBadgeInitializer(int page, int pageSize, long fromDate,
            long toDate, Order order, MaxMin max, MaxMin min, BadgeSortBy sort, String inName) throws ParseException {
        setup();
        badgeItemInitializer = createAllBadgeInitializer(page, pageSize, fromDate, toDate, order, max, min, sort,
                inName);
        badgeItemInitializer.setBr(BadgeRetriever.TAG);
        return badgeItemInitializer;
    }

    public static BadgeItemInitializer createIDBasedBadgeInitializer(int page, int pageSize, long fromDate, long toDate,
            Order order, MaxMin max, MaxMin min, BadgeSortBy sort, Set<Long> badge_id) throws ParseException {
        setup();
        badgeItemInitializer = createAllBadgeInitializer(page, pageSize, fromDate, toDate, order, max, min, sort, null);
        badgeItemInitializer.setBadge_id(badge_id);
        badgeItemInitializer.setBr(BadgeRetriever.ID);
        return badgeItemInitializer;
    }

    public static BadgeItemInitializer createRecipientBasedBadgeInitializer(int page, int pageSize, long fromDate,
            long toDate) throws ParseException {
        setup();
        badgeItemInitializer.setPage(page);
        badgeItemInitializer.setPageSize(pageSize);
        badgeItemInitializer.setFromDate(badgeItemInitializer.dateConverter(fromDate));
        badgeItemInitializer.setToDate(badgeItemInitializer.dateConverter(toDate));
        badgeItemInitializer.setBr(BadgeRetriever.RECIPIENT);
        return badgeItemInitializer;
    }

    public static BadgeItemInitializer createIDRecipientBasedBadgeInitializer(int page, int pageSize, long fromDate,
            long toDate, Set<Long> badge_id) throws ParseException {
        setup();
        badgeItemInitializer.setPage(page);
        badgeItemInitializer.setPageSize(pageSize);
        badgeItemInitializer.setFromDate(badgeItemInitializer.dateConverter(fromDate));
        badgeItemInitializer.setToDate(badgeItemInitializer.dateConverter(toDate));
        badgeItemInitializer.setBadge_id(badge_id);
        badgeItemInitializer.setBr(BadgeRetriever.ID_RECIPIENT);
        return badgeItemInitializer;
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

    public Set<Long> getBadge_id() {
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

    public void setBadge_id(Set<Long> badge_id) {
        this.badge_id = badge_id;
    }

    public void setBr(BadgeRetriever br) {
        this.br = br;
    }

}
