package com.destack.overflow.initializers;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerInitializer.class);

    private AnswerSortBy sort;

    /**
     * <b>NOTE</b>:Dates in the format of 'yyyyddMM'
     * 
     * @param page
     *            required page
     * @param pageSize
     *            number of {@link AnswerItem} in a page
     * @param fromDate
     *            Dates in the format of 'yyyyddMM'
     * @param toDate
     *            Dates in the format of 'yyyyddMM'
     * @param order
     *            Sort {@link Order} of {@link AnswerItem}'s
     * @param sort
     *            {@link AnswerSortBy}
     * @param min
     *            see {@link AnswerSortBy} for type of value to give
     * @param max
     *            see {@link AnswerSortBy} for type of value to give
     * @throws ParseException
     */
    public AnswerInitializer(int page, int pageSize, long fromDate, long toDate, Order order, AnswerSortBy sort,
            long min, long max) throws ParseException {
        setPage(page);
        setPageSize(pageSize);
        if (fromDate > toDate) {
            LOGGER.error("from date {} comes after to date {}", new Object[] { fromDate, toDate });
            throw new IllegalArgumentException("From Date(" + fromDate + ") is after (" + toDate + ")");
        }
        setFromDate(fromDate != 0 ? DATE_FORMAT.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? DATE_FORMAT.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        setSort(AnswerSortBy.validate(sort) ? sort : AnswerSortBy.ACTIVITY);
        setOrder(Order.validate(order) ? order : Order.DESC);
        if (getSort().equals(AnswerSortBy.VOTES)) {
            LOGGER.info("Answer Sort By VOTES");
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
