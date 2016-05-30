package com.destack.overflow.initializers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.TagRetriever;
import com.destack.overflow.enums.TagSortBy;
import com.destack.overflow.model.TagItem;

/**
 * @author Deepak
 *
 */
public class TagItemInitializer {

    private static SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyddMM");

    private long fromDate;

    private long max;

    private long min;

    private Order order;

    private int page;

    private int pageSize;

    private long toDate;

    private TagSortBy sort;

    private String inName;

    private long badge_id;

    private TagRetriever tagRetriever;

    private Set<String> tags;

    /**
     * Initializer for
     * {@link TagRetriever}=={@link TagRetriever#NORMAl}||{@link TagRetriever#TAGS}||
     * {@link TagRetriever#MODERATORY_ONLY}
     * 
     * @param page
     *            Page Number
     * @param pageSize
     *            Number of items in one page
     * @param fromDate
     * @param toDate
     * @param order
     * @param min
     *            Minimum {@link TagItem#getCount()}
     * @param max
     *            Maximum {@link TagItem#getCount()}
     * @param sort
     *            {@link TagSortBy}
     * @param inName
     *            Name of the tag
     * @param tagRetriever
     *            {@link TagRetriever}
     * @throws ParseException
     */
    public TagItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, int min, int max,
            TagSortBy sort, String inName, TagRetriever tagRetriever) throws ParseException {
        this.page = page;
        this.pageSize = pageSize;
        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate > 20081509 ? originalFormat.parse(String.valueOf(toDate)).getTime() / 1000 : 0;
        this.order = (order != null && (order.equals(Order.ASC) || order.equals(Order.DESC))) ? order : Order.DESC;
        this.min = min != 0 ? min : 0;
        this.max = max != 0 ? max : 0;
        this.sort = (sort != null)
                && (sort.equals(TagSortBy.ACTIVITY) || sort.equals(TagSortBy.POPULAR) || sort.equals(TagSortBy.NAME))
                ? sort : TagSortBy.POPULAR;
        this.inName = inName;
        if (tagRetriever != null) {
            this.tagRetriever = tagRetriever;
        } else {
            tagRetriever = TagRetriever.NORMAl;
        }
    }

    /**
     * Initializer to get all the tag synonyms on the site.
     * 
     * @param page
     *            Page Number
     * @param pageSize
     *            Number of items in one page
     * @param fromDate
     * @param toDate
     * @param order
     * @param min
     *            Minimum {@link TagItem#getCount()}
     * @param max
     *            Maximum {@link TagItem#getCount()}
     * @param sort
     *            {@link TagSortBy}
     * @throws ParseException
     */
    public TagItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, int min, int max,
            TagSortBy sort) throws ParseException {
        this.page = page;
        this.pageSize = pageSize;
        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate > 20081509 ? originalFormat.parse(String.valueOf(toDate)).getTime() / 1000 : 0;
        this.order = (order != null && (order.equals(Order.ASC) || order.equals(Order.DESC))) ? order : Order.DESC;
        this.min = min != 0 ? min : 0;
        this.max = max != 0 ? max : 0;
        this.sort = (sort != null)
                && (sort.equals(TagSortBy.ACTIVITY) || sort.equals(TagSortBy.POPULAR) || sort.equals(TagSortBy.NAME))
                ? sort : TagSortBy.POPULAR;
        tagRetriever = TagRetriever.SYNONYMS;

    }

    /**
     * @param page
     *            Page Number
     * @param pageSize
     *            Number of items in one page
     * @param fromDate
     * @param toDate
     * @param order
     * @param min
     *            Minimum {@link TagItem#getCount()}
     * @param max
     *            Maximum {@link TagItem#getCount()}
     * @param sort
     *            {@link TagSortBy}
     * @param tags
     *            {@link Set} of {@link #tags} i.e, {@link Set} of {@link #inName}
     * @throws ParseException
     */
    public TagItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, int min, int max,
            TagSortBy sort, Set<String> tags) throws ParseException {
        this.page = page;
        this.pageSize = pageSize;
        this.fromDate = fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0;
        this.toDate = toDate > 20081509 ? originalFormat.parse(String.valueOf(toDate)).getTime() / 1000 : 0;
        this.order = (order != null && (order.equals(Order.ASC) || order.equals(Order.DESC))) ? order : Order.DESC;
        this.min = min != 0 ? min : 0;
        this.max = max != 0 ? max : 0;
        this.sort = (sort != null)
                && (sort.equals(TagSortBy.ACTIVITY) || sort.equals(TagSortBy.POPULAR) || sort.equals(TagSortBy.NAME))
                ? sort : TagSortBy.POPULAR;
        if (tags != null && tags.size() > 0) {
            this.tags = tags;
        } else {
            throw new IllegalArgumentException("Wrong Set of tags given");
        }
        tagRetriever = TagRetriever.TAGS;
    }

    public long getFromDate() {
        return fromDate;
    }

    public long getMax() {
        return max;
    }

    public long getMin() {
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

    public TagSortBy getSort() {
        return sort;
    }

    public String getInName() {
        return inName;
    }

    public long getBadge_id() {
        return badge_id;
    }

    public TagRetriever getTagRetriever() {
        return tagRetriever;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTagRetriever(TagRetriever tagRetriever) {
        this.tagRetriever = tagRetriever;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public void setFromDate(long fromDate) {
        this.fromDate = fromDate;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public void setMin(long min) {
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

    public void setSort(TagSortBy sort) {
        this.sort = sort;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public void setBadge_id(long badge_id) {
        this.badge_id = badge_id;
    }

}
