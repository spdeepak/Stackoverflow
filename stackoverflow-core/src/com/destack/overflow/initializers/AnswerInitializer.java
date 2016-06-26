package com.destack.overflow.initializers;

import java.text.ParseException;

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

    private AnswerSortBy sort;


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
            long min, long max) throws ParseException {
        setPage(page);
        setPageSize(pageSize);
        if (fromDate > toDate) {
            throw new IllegalArgumentException("From Date(" + fromDate + ") is after (" + toDate + ")");
        }
        setFromDate(fromDate > 20081509 ? DATE_FORMAT.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? DATE_FORMAT.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        setSort(sort != null ? sort : AnswerSortBy.ACTIVITY);
        setOrder(order != null ? order : Order.DESC);
        if (getSort().equals(AnswerSortBy.VOTES)) {
            setMin(min);
            setMax(max);
        }
        if (!getSort().equals(AnswerSortBy.VOTES) && min > 20081509 && max > 20081509) {
            setMin(DATE_FORMAT.parse(String.valueOf(min)).getTime() / 1000);
            setMax(DATE_FORMAT.parse(String.valueOf(max)).getTime() / 1000);
        }
        if (!getSort().equals(AnswerSortBy.VOTES) && min < 20081509 && max < 20081509) {
            setMin(0L);
            setMax(0L);
        }
    }

    public AnswerSortBy getSort() {
        return sort;
    }

    public void setSort(AnswerSortBy sort) {
        this.sort = sort;
    }

}
