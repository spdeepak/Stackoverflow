package com.destack.overflow.initializers;

import java.text.ParseException;
import java.util.Set;

import com.destack.overflow.enums.CommentSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.model.CommentItem;
import com.destack.overflow.util.DateUtils;

/**
 * {@link CommentItem} initializer class.<br/>
 * 
 * @author Deepak
 *
 */
public class CommentInitializer extends BaseInitializer {

    private CommentSortBy sort;

    private Set<Long> comment_id;

    private static CommentInitializer commentInitializer;

    private static void setup() {
        commentInitializer = null;
        commentInitializer = new CommentInitializer();
    }

    private CommentInitializer() {
    }

    public static CommentInitializer createAllCommentInitializer(Integer page, Integer pageSize, Long fromDate,
            Long toDate, Order order, CommentSortBy sort, Long min, Long max) throws ParseException {
        setup();
        commentInitializer.setPage(page);
        commentInitializer.setPageSize(pageSize);
        commentInitializer.setFromDate(DateUtils.dateToMilliSecondsConverter(fromDate));
        commentInitializer.setToDate(DateUtils.dateToMilliSecondsConverter(toDate));
        commentInitializer.setOrder(Order.isValid(order) ? order : Order.DESC);
        commentInitializer.setSort(CommentSortBy.isValid(sort) ? sort : CommentSortBy.CREATION);
        if (CommentSortBy.VOTES.equals(commentInitializer.getSort())) {
            commentInitializer.setMin(min);
            commentInitializer.setMax(max);
        } else {
            commentInitializer.setMinDate(DateUtils.dateToMilliSecondsConverter(min));
            commentInitializer.setMaxDate(DateUtils.dateToMilliSecondsConverter(max));
        }
        return commentInitializer;
    }

    public static CommentInitializer createIdCommentInitializer(Integer page, Integer pageSize, Long fromDate,
            Long toDate, Order order, CommentSortBy sort, Long min, Long max, Set<Long> comment_id)
                    throws ParseException {
        commentInitializer = createAllCommentInitializer(page, pageSize, fromDate, toDate, order, sort, min, max);
        commentInitializer.setComment_id(comment_id);
        return commentInitializer;
    }

    public CommentSortBy getSort() {
        return sort;
    }

    public Set<Long> getComment_id() {
        return comment_id;
    }

    public void setSort(CommentSortBy sort) {
        this.sort = sort;
    }

    public void setComment_id(Set<Long> comment_id) {
        this.comment_id = comment_id;
    }
}
