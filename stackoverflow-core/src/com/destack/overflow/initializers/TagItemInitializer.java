package com.destack.overflow.initializers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.TagPeriod;
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

    private String tag;

    private TagPeriod tagPeriod;

    /**
     * Initializer for
     * {@link TagRetriever}=={@link TagRetriever#DEFAULT}||{@link TagRetriever#TAGS}||
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
    public TagItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, long min, long max,
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
            tagRetriever = TagRetriever.DEFAULT;
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
    public TagItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, long min, long max,
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
     * Get tags on the site by their names <br/>
     * OR<br/>
     * Get the synonyms for a specific set of tags. *
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
     * @param tags
     *            {@link Set} of {@link #tags} i.e, {@link Set} of {@link #inName}
     * @throws ParseException
     */
    public TagItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, long min, long max,
            TagSortBy sort, Set<String> tags, TagRetriever tagRetriever) throws ParseException {
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
        if (tagRetriever != null
                && (tagRetriever.equals(TagRetriever.TAGS) || tagRetriever.equals(TagRetriever.TAGS_SYNONYMS))) {
            this.tagRetriever = tagRetriever;
        } else {
            throw new IllegalArgumentException("This contructor takes only ".concat(TagRetriever.TAGS.toString())
                    .concat(" and ").concat(TagRetriever.TAGS_SYNONYMS.toString()));
        }
    }

    /**
     * Get frequently asked questions in a set of tags.
     * 
     * @param page
     *            Page Number
     * @param pageSize
     *            Number of {@link TagItem}'s in a page
     * @param tags
     *            {@link Set} of {@link #inName}'s
     */
    public TagItemInitializer(int page, int pageSize, Set<String> tags, TagRetriever tagRetriever) {
        this.page = page;
        this.pageSize = pageSize;
        if (tags != null || tags.size() > 0) {
            this.tags = tags;
        } else {
            throw new IllegalArgumentException("Wrong Set of tags given Or No tags given. Tags are Required");
        }
        if (tagRetriever != null
                && (tagRetriever.equals(TagRetriever.TAGS_FAQ) || tagRetriever.equals(TagRetriever.TAGS_RELATED))) {
            this.tagRetriever = tagRetriever;
        } else {
            throw new IllegalArgumentException("This contructor takes only ".concat(TagRetriever.TAGS_FAQ.toString())
                    .concat(" and ").concat(TagRetriever.TAGS_RELATED.toString()));
        }
    }

    /**
     * Get the top answer posters in a specific tag, either in the last month or for all time i.e.,
     * {@link TagRetriever#TOP_ANSWERS} <br/>
     * OR <br/>
     * Get the top question askers in a specific tag, either in the last month or for all time i.e.,
     * {@link TagRetriever#TOP_ASKERS}
     * 
     * @param page
     *            Page Number
     * @param pageSize
     *            Number of items requried in a Page
     * @param tag
     *            inName==tag
     * @param tagPeriod
     *            {@link TagPeriod}
     */
    public TagItemInitializer(int page, int pageSize, String tag, TagPeriod tagPeriod, TagRetriever tagRetriever) {
        this.page = page;
        this.pageSize = pageSize;
        if (tag != null || !tag.trim().isEmpty()) {
            this.tag = tag;
        } else {
            throw new IllegalArgumentException("Tag is mandatory");
        }
        if (tagPeriod != null) {
            this.tagPeriod = tagPeriod;
        } else {
            this.tagPeriod = TagPeriod.ALL_TIME;
        }
        if (tagRetriever != null
                && (tagRetriever.equals(TagRetriever.TOP_ANSWERS) || tagRetriever.equals(TagRetriever.TOP_ASKERS))) {
            this.tagRetriever = tagRetriever;
        } else {
            throw new IllegalArgumentException("This contructor takes only ".concat(TagRetriever.TOP_ANSWERS.toString())
                    .concat(" and ").concat(TagRetriever.TOP_ASKERS.toString()));
        }
    }

    /**
     * Get the wiki entries for a set of tags.
     * 
     * @param page
     *            Page Number
     * @param pageSize
     *            Number of Items in a Page
     * @param tags
     *            {@link Set} of {@link #inName}'s
     */
    public TagItemInitializer(int page, int pageSize, Set<String> tags) {
        this.page = page;
        this.pageSize = pageSize;
        if (tags != null || tags.size() > 0) {
            this.tags = tags;
        } else {
            throw new IllegalArgumentException("Wrong Set of tags given Or No tags given. Tags are Required");
        }
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

    public String getTag() {
        return tag;
    }

    public TagPeriod getTagPeriod() {
        return tagPeriod;
    }

    public void setTagPeriod(TagPeriod tagPeriod) {
        this.tagPeriod = tagPeriod;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
