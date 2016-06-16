package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.TagRetriever;
import com.destack.overflow.enums.TagSortBy;
import com.destack.overflow.initializers.TagItemInitializer;

public class TagItemURLGenerator extends BaseURLComponentGenerator implements URLGenerator<TagItemInitializer> {

    @Override
    public URL urlGenerator(TagItemInitializer tagItemInitializer)
            throws MalformedURLException, IllegalAccessException {
        String url = "https://api.stackexchange.com/2.2/tags?";
        String postFix = "&site=stackoverflow&filter=!-*f(6qOIRgw-";
        if (tagItemInitializer.getPage() != 0) {
            url += getPageURL(tagItemInitializer.getPage());
        }
        if (tagItemInitializer.getPageSize() != 0) {
            url += getPageSizeURL(tagItemInitializer.getPageSize());
        }
        if (tagItemInitializer.getTagRetriever() != null) {
            TagRetriever tr = tagItemInitializer.getTagRetriever();
            if (tr.equals(TagRetriever.DEFAULT) || tr.equals(TagRetriever.TAGS)
                    || tr.equals(TagRetriever.MODERATORY_ONLY) || tr.equals(TagRetriever.SYNONYMS)
                    || tr.equals(TagRetriever.TAGS_SYNONYMS)) {
                if (tagItemInitializer.getFromDate() != 0) {
                    url += getFromDate(tagItemInitializer.getFromDate());
                }
                if (tagItemInitializer.getToDate() != 0) {
                    url += getToDate(tagItemInitializer.getToDate());
                }
                if (tagItemInitializer.getOrder() != null && !tagItemInitializer.getOrder().toString().isEmpty()) {
                    url += getOrder(tagItemInitializer.getOrder().toString());
                } else {
                    url += getOrder(Order.DESC.toString());
                }
                if (tagItemInitializer.getSort() != null && !tagItemInitializer.getSort().toString().isEmpty()) {
                    url += getSort(tagItemInitializer.getSort().toString());
                } else {
                    url += getSort(TagSortBy.POPULAR.toString());
                }
                if (tagItemInitializer.getMin() != 0) {
                    url += getMin(String.valueOf(tagItemInitializer.getMin()));
                }
                if (tagItemInitializer.getMax() != 0) {
                    url += getMax(String.valueOf(tagItemInitializer.getMax()));
                }
                if (tagItemInitializer.getTags() != null && tagItemInitializer.getTags().size() != 0) {
                    if (tr.equals(TagRetriever.TAGS)) {
                        url = urlFixer(url);
                        String str=null;
                        for(String st:tagItemInitializer.getTags()){
                            str+=st.concat(";");
                        }
                        if (str!= null && str.endsWith(";")) {
                            //removes the last ;
                            str= str.substring(0, str.lastIndexOf(";"));
                        }
                        url = url.replace("tags?", "tags?".concat(str));

                    }
                }
                if (tr.equals(TagRetriever.SYNONYMS)) {
                    //TODO
                }
                if (tr.equals(TagRetriever.TAGS) || tr.equals(TagRetriever.TAGS_SYNONYMS)) {
                    //TODO
                }
            }
            if (tr.equals(TagRetriever.DEFAULT) || tr.equals(TagRetriever.TAGS)
                    || tr.equals(TagRetriever.MODERATORY_ONLY)) {
                if (tagItemInitializer.getInName() != null && !tagItemInitializer.getInName().trim().isEmpty()) {
                    url += "&inname=".concat(tagItemInitializer.getInName());
                }
                if (tr.equals(TagRetriever.DEFAULT)) {
                    url = url.replace("?&", "&");
                    url += postFix;
                    return new URL(url);
                }
            }
            if (tr.equals(TagRetriever.TAGS_FAQ) || tr.equals(TagRetriever.TAGS_RELATED)) {
                String tags = null;
                if (tagItemInitializer.getTags() != null && tagItemInitializer.getTags().size() > 0) {
                    for (String s : tagItemInitializer.getTags()) {
                        tags += s.concat(";");
                    }
                    if (tags != null && tags.endsWith(";")) {
                        //removes the last ;
                        tags = tags.substring(0, tags.lastIndexOf(";"));
                    }
                } else {
                    throw new IllegalArgumentException("Tags are mandatory");
                }
                if (tr.equals(TagRetriever.TAGS_FAQ)) {
                    url = url.replace("https://api.stackexchange.com/2.2/tags",
                            "https://api.stackexchange.com/2.2/tags/".concat(tags).concat("/faq"));
                }
                if (tr.equals(TagRetriever.TAGS_RELATED)) {
                    url = url.replace("https://api.stackexchange.com/2.2/tags",
                            "https://api.stackexchange.com/2.2/tags/".concat(tags).concat("/related"));
                }
                if (url.contains("?&")) {
                    url = url.replace("?&", "&");
                }
                url += postFix;
                return new URL(url);
            }
        }
        return null;
    }

}