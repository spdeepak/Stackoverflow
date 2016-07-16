package com.destack.overflow.initializers;

import java.text.ParseException;
import java.util.Set;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.TagPeriod;
import com.destack.overflow.enums.TagRetriever;
import com.destack.overflow.enums.TagSortBy;
import com.destack.overflow.enums.TagSortBySynonyms;

/**
 * @author Deepak
 *
 */
public class TagItemInitializer extends BaseInitializer {

    private TagSortBy sort;

    private TagSortBySynonyms sortSynonyms;

    private TagRetriever tagRetriever;

    private Set<String> tags;

    private String inName;

    private TagPeriod tagPeriod;

    private String tag;

    private static TagItemInitializer tagItemInitializer;

    private TagItemInitializer() {
    }

    private static void setup() {
        tagItemInitializer = null;
        tagItemInitializer = new TagItemInitializer();
    }

    public static TagItemInitializer createAllTagsInitializer(Integer page, Integer pageSize, Long fromDate,
            Long toDate, Order order, TagSortBy sort, Object min, Object max, String inName) throws ParseException {
        setup();
        pageSizeFromToDateOrderInitializers(page, pageSize, fromDate, toDate, order);
        tagItemInitializer.setSort(TagSortBy.validate(sort) ? sort : TagSortBy.POPULAR);
        tagItemInitializer.setMinAndMax(tagItemInitializer.getSort(), min, max);
        tagItemInitializer.setInName(inName);
        tagItemInitializer.setTagRetriever(TagRetriever.DEFAULT);
        return tagItemInitializer;
    }

    private static void pageSizeFromToDateOrderInitializers(Integer page, Integer pageSize, Long fromDate, Long toDate,
            Order order) throws ParseException {
        tagItemInitializer.setPage(page);
        tagItemInitializer.setPageSize(pageSize);
        tagItemInitializer.setFromDate(tagItemInitializer.dateConverter(fromDate));
        tagItemInitializer.setToDate(tagItemInitializer.dateConverter(toDate));
        tagItemInitializer.setOrder(order != null ? order : Order.DESC);
    }

    public static TagItemInitializer createNameBasedTagInitializer(Integer page, Integer pageSize, Long fromDate,
            Long toDate, Order order, TagSortBy sort, Object min, Object max, Set<String> tagNames)
                    throws ParseException {
        setup();
        pageSizeFromToDateOrderInitializers(page, pageSize, fromDate, toDate, order);
        tagItemInitializer.setSort(TagSortBy.validate(sort) ? sort : TagSortBy.POPULAR);
        tagItemInitializer.setMinAndMax(tagItemInitializer.getSort(), min, max);
        if (tagNames != null && !tagNames.isEmpty()) {
            tagItemInitializer.setTags(tagNames);
        } else {
            throw new IllegalArgumentException("Tag names are mandatory");
        }
        tagItemInitializer.setTagRetriever(TagRetriever.TAGS);
        return tagItemInitializer;
    }

    public static TagItemInitializer createModeratorOnlyTagsInitializer(Integer page, Integer pageSize, Long fromDate,
            Long toDate, Order order, TagSortBy sort, Object min, Object max, String inName) throws ParseException {
        createAllTagsInitializer(page, pageSize, fromDate, toDate, order, sort, min, max, inName);
        tagItemInitializer.setTagRetriever(TagRetriever.MODERATOR_ONLY);
        return tagItemInitializer;
    }

    public static TagItemInitializer createRequiredNameTagInitializer(Integer page, Integer pageSize, Long fromDate,
            Long toDate, Order order, TagSortBy sort, Object min, Object max, String inName) throws ParseException {
        createAllTagsInitializer(page, pageSize, fromDate, toDate, order, sort, min, max, inName);
        tagItemInitializer.setTagRetriever(TagRetriever.REQUIRED);
        return tagItemInitializer;
    }

    public static TagItemInitializer createSynonymsTagsInitializer(Integer page, Integer pageSize, Long fromDate,
            Long toDate, Order order, TagSortBySynonyms sort, Object min, Object max) throws ParseException {
        setup();
        pageSizeFromToDateOrderInitializers(page, pageSize, fromDate, toDate, order);
        tagItemInitializer.setSortSynonyms(TagSortBySynonyms.validate(sort) ? sort : TagSortBySynonyms.APPLIED);
        tagItemInitializer.setMinAndMax(tagItemInitializer.getSortSynonyms(), min, max);
        tagItemInitializer.setTagRetriever(TagRetriever.SYNONYMS);
        return tagItemInitializer;
    }

    public static TagItemInitializer createNameBasedSynonymsTagInitializer(Integer page, Integer pageSize,
            Long fromDate, Long toDate, Order order, TagSortBy sort, Object min, Object max, Set<String> nameTags)
                    throws ParseException {
        createNameBasedTagInitializer(page, pageSize, fromDate, toDate, order, sort, min, max, nameTags);
        tagItemInitializer.setTagRetriever(TagRetriever.TAGS_SYNONYMS);
        return tagItemInitializer;
    }

    public static TagItemInitializer createFAQTagInitializer(Integer page, Integer pageSize, Set<String> tagNames) {
        setup();
        tagItemInitializer.setPage(page);
        tagItemInitializer.setPageSize(pageSize);
        if (tagNames != null && !tagNames.isEmpty()) {
            tagItemInitializer.setTags(tagNames);
        } else {
            throw new IllegalArgumentException("Tag names are mandatory");
        }
        tagItemInitializer.setTagRetriever(TagRetriever.TAGS_FAQ);
        return tagItemInitializer;
    }

    public static TagItemInitializer createRelatedTagsInitializer(Integer page, Integer pageSize,
            Set<String> nameTags) {
        createFAQTagInitializer(page, pageSize, nameTags);
        tagItemInitializer.setTagRetriever(TagRetriever.TAGS_RELATED);
        return tagItemInitializer;
    }

    /**
     * @param page
     *            Page number
     * @param pageSize
     *            number of items in a page
     * @param tag
     *            Tag name is mandatory
     * @param tagPeriod
     *            Default is {@link TagPeriod#ALL_TIME}
     * @return {@link TagItemInitializer} suitable for {@link TagRetriever#TOP_ANSWERS}
     */
    public static TagItemInitializer createTopAnswerTagInitializer(Integer page, Integer pageSize, String tag,
            TagPeriod tagPeriod) {
        setup();
        tagItemInitializer.setPage(page);
        tagItemInitializer.setPageSize(pageSize);
        if (tag != null && !tag.trim().isEmpty()) {
            tagItemInitializer.setTag(tag);
        } else {
            throw new IllegalArgumentException("Tag name is mandatory");
        }
        tagItemInitializer.setTagPeriod(TagPeriod.validate(tagPeriod) ? tagPeriod : TagPeriod.ALL_TIME);
        tagItemInitializer.setTagRetriever(TagRetriever.TOP_ANSWERS);
        return tagItemInitializer;
    }

    public static TagItemInitializer createTopAskerTagInitializer(Integer page, Integer pageSize, String tag,
            TagPeriod tagPeriod) {
        createTopAnswerTagInitializer(page, pageSize, tag, tagPeriod);
        tagItemInitializer.setTagRetriever(TagRetriever.TOP_ASKERS);
        return tagItemInitializer;
    }

    public static TagItemInitializer createWikiTagInitializer(Integer page, Integer pageSize, Set<String> tagNames) {
        setup();
        tagItemInitializer.setPage(page);
        tagItemInitializer.setPageSize(pageSize);
        if (tagNames != null && !tagNames.isEmpty()) {
            tagItemInitializer.setTags(tagNames);
        } else {
            throw new IllegalArgumentException("Tag names are mandatory");
        }
        tagItemInitializer.setTagRetriever(TagRetriever.WIKIS);
        return tagItemInitializer;
    }

    private void setMinAndMax(TagSortBy sort, Object min, Object max) throws ParseException {
        if (getSort().equals(TagSortBy.POPULAR)) {
            if (min != null && min instanceof Number) {
                setMin(((Number) min).longValue());
            } else if (min != null && !(min instanceof Number)) {
                throw new IllegalArgumentException("When TagSortBy is POPULAR min and max should be count");
            }
            if (max != null && max instanceof Number) {
                setMax(((Number) max).longValue());
            } else if (max != null && !(max instanceof Number)) {
                throw new IllegalArgumentException("When TagSortBy is POPULAR min and max should be count");
            }
        } else if (getSort().equals(TagSortBy.ACTIVITY)) {
            if (min != null && min instanceof Number) {
                setMinDate(((Number) min).longValue() > 20081509
                        ? DATE_FORMAT.parse(String.valueOf(min)).getTime() / 1000 : 0);
            } else if (min != null && !(min instanceof Number)) {
                throw new IllegalArgumentException("When TagSortBy is ACTIVITY min and max should be Date(yyyyddMM)");
            }
            if (max != null && max instanceof Number) {
                setMaxDate(((Number) max).longValue() > 20081509
                        ? DATE_FORMAT.parse(String.valueOf(max)).getTime() / 1000 : 0);
            } else if (max != null && !(max instanceof Number)) {
                throw new IllegalArgumentException("When TagSortBy is ACTIVITY min and max should be Date(yyyyddMM)");
            }
        } else if (getSort().equals(TagSortBy.NAME)) {
            if (min != null && min instanceof String) {
                setMinString((String) min);
            } else if (min != null && !(min instanceof String)) {
                throw new IllegalArgumentException("When TagSortBy is ACTIVITY min and max should be Tag Name");
            }
            if (max != null && max instanceof String) {
                setMaxString((String) max);
            } else if (max != null && !(max instanceof String)) {
                throw new IllegalArgumentException("When TagSortBy is ACTIVITY min and max should be Tag Name");
            }
        }
    }

    private void setMinAndMax(TagSortBySynonyms sort, Object min, Object max) throws ParseException {
        if (getSortSynonyms().equals(TagSortBySynonyms.APPLIED)) {
            if (min != null && min instanceof Number) {
                setMin(((Number) min).longValue());
            } else if (min != null && !(min instanceof Number)) {
                throw new IllegalArgumentException(
                        "When TagSortBySynonyms is APPLIED min and max should be count (i.e., a number)");
            }
            if (max != null && max instanceof Number) {
                setMaxDate(((Number) max).longValue());
            } else if (max != null && !(max instanceof Number)) {
                throw new IllegalArgumentException(
                        "When TagSortBySynonyms is APPLIED min and max should be count (i.e., a number)");
            }

        } else if (getSortSynonyms().equals(TagSortBySynonyms.ACTIVITY)
                || getSortSynonyms().equals(TagSortBySynonyms.CREATION)) {
            if (min != null && min instanceof Number) {
                setMinDate(dateConverter(((Number) min).longValue()));
            } else if (min != null && !(min instanceof Number)) {
                throw new IllegalArgumentException(
                        "When TagSortBySynonyms is ACTIVITY/CREATION min and max should be Date(yyyyddMM)");
            }
            if (max != null && max instanceof Number) {
                setMaxDate(dateConverter(((Number) max).longValue()));
            } else if (max != null && !(max instanceof Number)) {
                throw new IllegalArgumentException(
                        "When TagSortBySynonyms is ACTIVITY/CREATION min and max should be Date(yyyyddMM)");
            }
        }
    }

    public TagSortBy getSort() {
        return sort;
    }

    public TagRetriever getTagRetriever() {
        return tagRetriever;
    }

    public Set<String> getTags() {
        return tags;
    }

    public TagPeriod getTagPeriod() {
        return tagPeriod;
    }

    public String getInName() {
        return inName;
    }

    public TagSortBySynonyms getSortSynonyms() {
        return sortSynonyms;
    }

    public void setSortSynonyms(TagSortBySynonyms sortSynonyms) {
        this.sortSynonyms = sortSynonyms;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public void setTagPeriod(TagPeriod tagPeriod) {
        this.tagPeriod = tagPeriod;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
