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
public class TagItemInitializer extends BaseInitializer {

    private static SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyddMM");

    private TagSortBy sort;

    private long badge_id;

    private TagRetriever tagRetriever;

    private Set<String> tags;

    private String tag;

    private String inName;

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
     * @param sort
     *            {@link TagSortBy}
     * 
     *            <pre>
     *            if {@link TagSortBy#POPULAR} then min & max should be count
     *            if {@link TagSortBy#ACTIVITY} then min & max should be Date
     *            if {@link TagSortBy#NAME} then min & max should be Strting letter of the Tag Name
     *            required
     *            </pre>
     * @param min
     *            Minimum {@link TagItem#getCount()}
     * @param max
     *            Maximum {@link TagItem#getCount()}
     * @param inName
     *            Name of the tag
     * @param tagRetriever
     *            {@link TagRetriever}
     * @throws ParseException
     */
    public TagItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, TagSortBy sort,
            Object min, Object max, String inName, TagRetriever tagRetriever) throws ParseException {
        setPage(page);
        setPageSize(pageSize);
        setFromDate(fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? originalFormat.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        setOrder(order != null ? order : Order.DESC);
        setSort((sort != null)
                && (sort.equals(TagSortBy.ACTIVITY) || sort.equals(TagSortBy.POPULAR) || sort.equals(TagSortBy.NAME))
                ? sort : TagSortBy.POPULAR);
        setMinAndMax(getSort(), min, max);
        this.setInName(inName);
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
    public TagItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, TagSortBy sort,
            Object min, Object max) throws ParseException {
        setPage(page);
        setPageSize(pageSize);
        setFromDate(fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? originalFormat.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        setOrder(order != null ? order : Order.DESC);
        setSort((sort != null)
                && (sort.equals(TagSortBy.ACTIVITY) || sort.equals(TagSortBy.POPULAR) || sort.equals(TagSortBy.NAME))
                ? sort : TagSortBy.POPULAR);
        setMinAndMax(getSort(), min, max);
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
    public TagItemInitializer(int page, int pageSize, long fromDate, long toDate, Order order, TagSortBy sort,
            Object min, Object max, Set<String> tags, TagRetriever tagRetriever) throws ParseException {
        setPage(page);
        setPageSize(pageSize);
        setFromDate(fromDate > 20081509 ? originalFormat.parse(String.valueOf(fromDate)).getTime() / 1000 : 0);
        setToDate(toDate != 0 ? originalFormat.parse(String.valueOf(toDate)).getTime() / 1000 : 0);
        setOrder(order != null ? order : Order.DESC);
        setSort((sort != null)
                && (sort.equals(TagSortBy.ACTIVITY) || sort.equals(TagSortBy.POPULAR) || sort.equals(TagSortBy.NAME))
                ? sort : TagSortBy.POPULAR);
        setMinAndMax(getSort(), min, max);
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
        setPage(page);
        setPageSize(pageSize);
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
        setPage(page);
        setPageSize(pageSize);
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
        setPage(page);
        setPageSize(pageSize);
        if (tags != null || tags.size() > 0) {
            this.tags = tags;
        } else {
            throw new IllegalArgumentException("Wrong Set of tags given Or No tags given. Tags are Required");
        }
    }

    private void setMinAndMax(TagSortBy sort, Object min, Object max) throws ParseException {
        if (getSort().equals(TagSortBy.POPULAR)) {
            if (min.getClass().equals(Number.class) && max.getClass().equals(Number.class)) {
                setMin((long) min);
                setMax((long) max);
            } else {
                throw new IllegalArgumentException("When TagSortBy is POPULAR min and max should be count");
            }
        } else if (getSort().equals(TagSortBy.ACTIVITY)) {
            if (min.getClass().equals(Number.class) && max.getClass().equals(Number.class)) {
                setMinDate((long) min > 20081509 ? originalFormat.parse(String.valueOf(min)).getTime() / 1000 : 0);
                setMaxDate((long) max > 20081509 ? originalFormat.parse(String.valueOf(max)).getTime() / 1000 : 0);
            } else {
                throw new IllegalArgumentException("When TagSortBy is ACTIVITY min and max should be Date(yyyyddMM)");
            }
        } else if (getSort().equals(TagSortBy.NAME)) {
            if (min.getClass().equals(String.class) && max.getClass().equals(String.class)) {
                setMinString((String) min);
                setMaxString((String) max);
            } else {
                throw new IllegalArgumentException("When TagSortBy is ACTIVITY min and max should be Tag Name");
            }
        }
    }

    public TagSortBy getSort() {
        return sort;
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

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
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

    public void setSort(TagSortBy sort) {
        this.sort = sort;
    }

    public void setBadge_id(long badge_id) {
        this.badge_id = badge_id;
    }

}
