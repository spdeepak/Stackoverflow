package com.destack.overflow.initializers;

import java.text.ParseException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.FetchFromAnswer;
import com.destack.overflow.enums.Order;
import com.destack.overflow.model.AnswerItem;

/**
 * {@link AnswerItem} initializer class.<br/>
 * 
 * @author Deepak
 *
 */
public class AnswerItemInitializer extends BaseInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerItemInitializer.class);

    private AnswerSortBy sort;

    private FetchFromAnswer fetchFromAnswer;

    private Set<Long> ids;

    private static AnswerItemInitializer answerItemInitializer;

    private static AnswerItemInitializer setup() {
        answerItemInitializer = null;
        answerItemInitializer = new AnswerItemInitializer();
        return answerItemInitializer;
    }

    /**
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param sort
     * @param min
     * @param max
     * @return
     * @throws ParseException
     */
    public static AnswerItemInitializer createAllAnswersInitializerInstance(int page, int pageSize, long fromDate,
            long toDate, Order order, AnswerSortBy sort, long min, long max) throws ParseException {
        setup();
        answerItemInitializer.setPage(page);
        answerItemInitializer.setPageSize(pageSize);
        answerItemInitializer.setFromDate(answerItemInitializer.dateVerifier(fromDate)
                ? DATE_FORMAT.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        answerItemInitializer.setToDate(answerItemInitializer.dateVerifier(toDate)
                ? DATE_FORMAT.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        answerItemInitializer.setSort(AnswerSortBy.validate(sort) ? sort : AnswerSortBy.ACTIVITY);
        answerItemInitializer.setOrder(Order.validate(order) ? order : Order.DESC);
        if (answerItemInitializer.getSort().equals(AnswerSortBy.VOTES)) {
            LOGGER.info("Answer Sort By VOTES");
            answerItemInitializer.setMin(min);
            answerItemInitializer.setMax(max);
        }
        if (!answerItemInitializer.getSort().equals(AnswerSortBy.VOTES)
                && answerItemInitializer.datesVerifier(min, max)) {
            answerItemInitializer.setMin(DATE_FORMAT.parse(String.valueOf(min)).getTime() / 1000);
            answerItemInitializer.setMax(DATE_FORMAT.parse(String.valueOf(max)).getTime() / 1000);
        }
        return answerItemInitializer;
    }

    /**
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param sort
     * @param min
     * @param max
     * @param ids
     * @param fetchFromAnswer
     * @return
     * @throws ParseException
     */
    public static AnswerItemInitializer createAnswerIdInitializerInstance(int page, int pageSize, long fromDate,
            long toDate, Order order, AnswerSortBy sort, long min, long max, Set<Long> ids,
            FetchFromAnswer fetchFromAnswer) throws ParseException {
        answerItemInitializer = createAllAnswersInitializerInstance(page, pageSize, fromDate, toDate, order, sort, min,
                max);
        if (ids != null && !ids.isEmpty()) {
            answerItemInitializer.setIds(ids);
            if (FetchFromAnswer.validate(fetchFromAnswer)) {
                answerItemInitializer.setFetchFromAnswer(fetchFromAnswer);
            } else if (!FetchFromAnswer.validate(fetchFromAnswer)) {
                LOGGER.error("FetchFromAnswer is not valid");
                throw new IllegalArgumentException("FetchFromAnswer is not valid");
            } else {
                LOGGER.error("Use createAllAnswersInitializerInstance to get Fetch");
                throw new IllegalArgumentException("Use createAllAnswersInitializerInstance to get Fetch");
            }
        } else {
            LOGGER.error("IDs cannot be null or empty");
            throw new IllegalArgumentException("IDs cannot be null or empty");
        }
        return answerItemInitializer;
    }

    public AnswerSortBy getSort() {
        return sort;
    }

    public void setSort(AnswerSortBy sort) {
        this.sort = sort;
    }

    public FetchFromAnswer getFetchFromAnswer() {
        return fetchFromAnswer;
    }

    public void setFetchFromAnswer(FetchFromAnswer fetchFromAnswer) {
        this.fetchFromAnswer = fetchFromAnswer;
    }

    public Set<Long> getIds() {
        return ids;
    }

    public void setIds(Set<Long> ids) {
        this.ids = ids;
    }

}
