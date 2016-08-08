package com.destack.overflow.initializers;

import java.util.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.PostRetriever;
import com.destack.overflow.enums.PostSortBy;
import com.destack.overflow.enums.PostSortBySuggestedEdits;
import com.destack.overflow.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * @author Deepak
 *
 */
public class PostItemInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostItemInitializer.class);

    private Set<Long> ids;

    private Long id;

    private String body;

    private Date fromDate;

    private Long max;

    private Long min;

    private Date maxDate;

    private Date minDate;

    private String minString;

    private String maxString;

    private Order order;

    private Integer page;

    private Integer pageSize;

    private Date toDate;

    private PostSortBy postSortBy;

    private PostSortBySuggestedEdits postSortBySuggestedEdits;

    private PostRetriever postRetriever;

    private PostItemInitializer() {

    }

    private PostItemInitializer(Builder builder) {
        page = builder.page;
        pageSize = builder.pageSize;
        fromDate = builder.fromDate;
        toDate = builder.toDate;
        min = builder.min;
        max = builder.max;
        minDate = builder.minDate;
        maxDate = builder.maxDate;
        minString = builder.minString;
        maxString = builder.maxString;
        order = builder.order;
        id = builder.id;
        ids = builder.ids;
        postSortBy = builder.postSortBy;
        postSortBySuggestedEdits = builder.postSortBySuggestedEdits;
        postRetriever = builder.postRetriever;
        body = builder.body;
    }

    /**
     * 
     * {@link PostItemInitializer}'s {@link Builder}
     * 
     * @author Deepak
     *
     */
    public static class Builder implements BaseBuilder<PostItemInitializer> {

        private Set<Long> ids;

        private Long id;

        private String body;

        private Date fromDate;

        private Long max;

        private Long min;

        private Date maxDate;

        private Date minDate;

        private String minString;

        private String maxString;

        private Order order;

        private Integer page;

        private Integer pageSize;

        private Date toDate;

        private PostSortBy postSortBy;

        private PostSortBySuggestedEdits postSortBySuggestedEdits;

        private PostRetriever postRetriever;

        /**
         * Except {@link PostRetriever#ALL} & {@link PostRetriever#ID_COMMENT_RENDER},
         * {@link #ids(Set)} are mandatory<br/>
         * For {@link PostRetriever#ID_COMMENT_RENDER} {@link Id} is mandatory
         */
        public Builder() {
            super();
        }

        @Override
        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        @Override
        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        @Override
        public Builder order(Order order) {
            this.order = Order.isValid(order) ? order : Order.DESC;
            return this;
        }

        @Override
        public PostItemInitializer build() {
            if (postRetriever == null) {
                postRetriever = PostRetriever.ALL;
            }
            return new PostItemInitializer(this);
        }

        public Builder fromDate(Date fromDate) {
            if (DateUtils.dateVerifier(fromDate.getTime())) {
                this.fromDate = fromDate;
            }
            return this;
        }

        public Builder toDate(Date toDate) {
            if (DateUtils.dateVerifier(toDate)) {
                this.toDate = toDate;
            }
            return this;
        }

        /**
         * sort by <i>score</i>
         * 
         * @param min
         *            Minimum score
         * @param max
         *            Maximum score
         * @return
         */
        public Builder sortByVotes(Long min, Long max) {
            LOGGER.info("Post Sort By Votes");
            postSortBy = PostSortBy.VOTES;
            this.min = min;
            this.max = max;
            return this;
        }

        /**
         * sort By <i>last activity date</i>
         * 
         * @param minDate
         *            From Date in "yyyyddMM" format
         * @param maxDate
         *            To Date in "yyyyddMM" format
         * @return
         */
        public Builder sortByActivity(Date minDate, Date maxDate) {
            LOGGER.info("Post Sort By Activity");
            postSortBy = PostSortBy.ACTIVITY;
            this.minDate = minDate;
            this.maxDate = maxDate;
            return this;
        }

        /**
         * sort by <i>creation date</i><br/>
         * Date Should be in the format of
         * 
         * @param minDate
         *            From Date in "yyyyddMM" format
         * @param maxDate
         *            To Date in "yyyyddMM" format
         * @return
         */
        public Builder sortByCreation(Date minDate, Date maxDate) {
            LOGGER.info("Post Sort By Creatoin");
            postSortBy = PostSortBy.CREATION;
            this.minDate = minDate;
            this.maxDate = maxDate;
            return this;
        }

        /**
         * Default is {@link PostRetriever#ALL}
         * 
         * @param postRetriever
         * @return
         */
        public Builder retreiver(PostRetriever postRetriever) {
            this.postRetriever = PostRetriever.isValid(postRetriever) ? postRetriever : PostRetriever.ALL;
            return this;
        }

        /**
         * Use only for {@link PostRetriever#ID_COMMENT_RENDER} <br/>
         * It requires only {@link Id} and {@link #body} other builders will be discarded
         * 
         * @param id
         *            ID is <b>Mandatory</b>
         * @param body
         * @return
         */
        public Builder retriever(Long id, String body) {
            LOGGER.info("Retrieving a comment given its body and the post it's on");
            this.id = id;
            this.body = body;
            postRetriever = PostRetriever.ID_COMMENT_RENDER;
            return this;
        }

        /**
         * @param id
         * @return
         */
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * @param ids
         * @return
         */
        public Builder ids(Set<Long> ids) {
            this.ids = ids;
            return this;
        }

        /**
         * @param postSortBySuggestedEdits
         * @param ids
         * @return
         */
        public Builder suggestedEdits(PostSortBySuggestedEdits postSortBySuggestedEdits, Set<Long> ids) {
            this.postSortBySuggestedEdits = PostSortBySuggestedEdits.isValid(postSortBySuggestedEdits)
                    ? postSortBySuggestedEdits : PostSortBySuggestedEdits.CREATION;
            this.ids = ids;
            return this;
        }

    }

    public PostSortBy getPostSortBy() {
        return postSortBy;
    }

    public Set<Long> getIds() {
        return ids;
    }

    public PostRetriever getPostRetriever() {
        return postRetriever;
    }

    public String getBody() {
        return body;
    }

    public Long getId() {
        return id;
    }

    public PostSortBySuggestedEdits getPostSortBySuggestedEdits() {
        return postSortBySuggestedEdits;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Long getMax() {
        return max;
    }

    public Long getMin() {
        return min;
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public Date getMinDate() {
        return minDate;
    }

    public String getMinString() {
        return minString;
    }

    public String getMaxString() {
        return maxString;
    }

    public Order getOrder() {
        return order;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Date getToDate() {
        return toDate;
    }
}
