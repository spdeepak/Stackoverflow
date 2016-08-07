package com.destack.overflow.initializers;

import java.text.ParseException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.PostRetriever;
import com.destack.overflow.enums.PostSortBy;
import com.destack.overflow.enums.PostSortBy2;
import com.destack.overflow.enums.PostSortBySuggestedEdits;
import com.destack.overflow.util.DateUtils;

/**
 * @author Deepak
 *
 */
public class PostItemInitializer extends BaseInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostItemInitializer.class);

    private PostSortBy postSortBy;

    private PostSortBy2 postSortBy2;

    private PostSortBySuggestedEdits postSortBySuggestedEdits;

    private PostRetriever postRetriever;

    private Set<Long> ids;

    private Long id;

    private String body;

    private static PostItemInitializer postItemInitializer;

    private PostItemInitializer() {

    }

    private static void setup() {
        postItemInitializer = null;
        postItemInitializer = new PostItemInitializer();
    }

    /**
     * Get all posts (questions and answers) in the system.
     * 
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param min
     * @param max
     * @param sort
     * @return
     * @throws ParseException
     */
    public static PostItemInitializer createAllPostsInitializerInstance(Integer page, Integer pageSize, Long fromDate,
            Long toDate, Order order, PostSortBy sort, Long min, Long max) throws ParseException {
        setup();
        postItemInitializer.setPage(page);
        postItemInitializer.setPageSize(pageSize);
        postItemInitializer.setFromDate(DateUtils.dateToMilliSecondsConverter(fromDate));
        postItemInitializer.setToDate(DateUtils.dateToMilliSecondsConverter(toDate));
        postItemInitializer.setOrder(Order.isValid(order) ? order : Order.DESC);
        postItemInitializer.setPostSortBy(PostSortBy.isContains(sort) ? sort : PostSortBy.ACTIVITY);
        if (PostSortBy.VOTES.equals(postItemInitializer.getPostSortBy())) {
            LOGGER.info("PostSortBy is VOTES");
            postItemInitializer.setMin(min);
            postItemInitializer.setMax(max);
        } else if (DateUtils.datesVerifier(min, max)) {
            LOGGER.info("PostSortBy is {}", postItemInitializer.getPostSortBy());
            postItemInitializer.setMinDate(DateUtils.dateToMilliSecondsConverter(min));
            postItemInitializer.setMaxDate(DateUtils.dateToMilliSecondsConverter(max));
        } else {
            throw new IllegalArgumentException(
                    "As PostSortBy is not by Votes Min & Max should be dates and in 'yyyyddMM' format");
        }
        postItemInitializer.setPostRetriever(PostRetriever.ALL);
        return postItemInitializer;
    }

    /**
     * 
     * Get all posts identified by a set of ids. Useful for when the type of post (question or
     * answer) is not known.
     * 
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param sort
     * @param min
     * @param max
     * @param ids
     * @return
     * @throws ParseException
     */
    public static PostItemInitializer createPostsByIdInitializerInstance(Integer page, Integer pageSize, Long fromDate,
            Long toDate, Order order, PostSortBy sort, Long min, Long max, Set<Long> ids) throws ParseException {
        createAllPostsInitializerInstance(page, pageSize, fromDate, toDate, order, sort, min, max);
        if (ids != null && !ids.isEmpty()) {
            postItemInitializer.setIds(ids);
        } else {
            throw new IllegalArgumentException("IDs are mandatory");
        }
        postItemInitializer.setPostRetriever(PostRetriever.ID);
        return postItemInitializer;
    }

    /**
     * Get comments on the posts (question or answer) identified by a set of ids.
     * 
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param sort
     * @param min
     * @param max
     * @param ids
     * @return
     * @throws ParseException
     */
    public static PostItemInitializer createCommentsOfPostsByIdInitializerInstance(Integer page, Integer pageSize,
            Long fromDate, Long toDate, Order order, PostSortBy2 sort, Long min, Long max, Set<Long> ids)
                    throws ParseException {
        setup();
        postItemInitializer.setPage(page);
        postItemInitializer.setPageSize(pageSize);
        postItemInitializer.setFromDate(DateUtils.dateToMilliSecondsConverter(fromDate));
        postItemInitializer.setToDate(DateUtils.dateToMilliSecondsConverter(toDate));
        postItemInitializer.setOrder(Order.isValid(order) ? order : Order.DESC);
        postItemInitializer.setPostSortBy2(PostSortBy2.isContains(sort) ? sort : PostSortBy2.CREATION);
        if (PostSortBy.VOTES.equals(postItemInitializer.getPostSortBy())) {
            LOGGER.info("PostSortBy is VOTES");
            postItemInitializer.setMin(min);
            postItemInitializer.setMax(max);
        } else if (DateUtils.datesVerifier(min, max)) {
            LOGGER.info("PostSortBy is {}", postItemInitializer.getPostSortBy());
            postItemInitializer.setMinDate(DateUtils.dateToMilliSecondsConverter(min));
            postItemInitializer.setMaxDate(DateUtils.dateToMilliSecondsConverter(max));
        } else {
            throw new IllegalArgumentException(
                    "As PostSortBy is not by Votes Min & Max should be dates and in 'yyyyddMM' format");
        }
        if (ids != null && !ids.isEmpty()) {
            postItemInitializer.setIds(ids);
        } else {
            throw new IllegalArgumentException("IDs are mandatory");
        }
        postItemInitializer.setPostRetriever(PostRetriever.ID_COMMENT);
        return postItemInitializer;
    }

    /**
     * Renders a hypothetical comment on the given post. <br/>
     * <br/>
     * This method is meant for previewing or otherwise "faking" a comment. No validation is done
     * with this method, if you need validation you should use the create or edit methods.
     * 
     * @param ids
     * @param body
     * @return
     */
    public static PostItemInitializer createCommentsRenderPostByIdInitializerInstance(Long id, String body) {
        setup();
        postItemInitializer.setId(id);
        postItemInitializer.setBody(body);
        postItemInitializer.setPostRetriever(PostRetriever.ID_COMMENT_RENDER);
        return postItemInitializer;
    }

    /**
     * Returns edit revisions for the posts identified in ids.
     * 
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param ids
     * @return
     * @throws ParseException
     */
    public static PostItemInitializer createRevisionPostByIdInitializerInstance(Integer page, Integer pageSize,
            Long fromDate, Long toDate, Set<Long> ids) throws ParseException {
        setup();
        postItemInitializer.setPage(page);
        postItemInitializer.setPageSize(pageSize);
        postItemInitializer.setFromDate(DateUtils.dateToMilliSecondsConverter(fromDate));
        postItemInitializer.setToDate(DateUtils.dateToMilliSecondsConverter(toDate));
        postItemInitializer.setIds(ids);
        postItemInitializer.setPostRetriever(PostRetriever.ID_RETRIEVER);
        return postItemInitializer;
    }

    /**
     * Get suggested edits on the set of posts in ids.
     * 
     * @param page
     * @param pageSize
     * @param fromDate
     * @param toDate
     * @param order
     * @param sort
     * @param min
     *            Only Date in <b>yyyyddMM</b> format
     * @param max
     *            Only Date in <b>yyyyddMM</b> format
     * @param ids
     * @return
     * @throws ParseException
     */
    public static PostItemInitializer createSuggestedEditsPostByIdInitializerInstance(Integer page, Integer pageSize,
            Long fromDate, Long toDate, Order order, PostSortBySuggestedEdits sort, Long min, Long max, Set<Long> ids)
                    throws ParseException {
        setup();
        postItemInitializer.setPage(page);
        postItemInitializer.setPageSize(pageSize);
        postItemInitializer.setFromDate(DateUtils.dateToMilliSecondsConverter(fromDate));
        postItemInitializer.setToDate(DateUtils.dateToMilliSecondsConverter(toDate));
        postItemInitializer.setOrder(Order.isValid(order) ? order : Order.DESC);
        postItemInitializer.setPostSortBySuggestedEdits(
                PostSortBySuggestedEdits.isValid(sort) ? sort : PostSortBySuggestedEdits.CREATION);
        postItemInitializer.setIds(ids);
        postItemInitializer.setPostRetriever(PostRetriever.SUGGESTED_EDITS);
        return postItemInitializer;
    }

    public PostSortBy getPostSortBy() {
        return postSortBy;
    }

    public void setPostSortBy(PostSortBy postSortBy) {
        this.postSortBy = postSortBy;
    }

    public Set<Long> getIds() {
        return ids;
    }

    public void setIds(Set<Long> ids) {
        this.ids = ids;
    }

    public PostRetriever getPostRetriever() {
        return postRetriever;
    }

    public void setPostRetriever(PostRetriever postRetriever) {
        this.postRetriever = postRetriever;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostSortBy2 getPostSortBy2() {
        return postSortBy2;
    }

    public void setPostSortBy2(PostSortBy2 postSortBy2) {
        this.postSortBy2 = postSortBy2;
    }

    public PostSortBySuggestedEdits getPostSortBySuggestedEdits() {
        return postSortBySuggestedEdits;
    }

    public void setPostSortBySuggestedEdits(PostSortBySuggestedEdits postSortBySuggestedEdits) {
        this.postSortBySuggestedEdits = postSortBySuggestedEdits;
    }
}
