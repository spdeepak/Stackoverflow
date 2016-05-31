package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import com.destack.overflow.enums.TagRetriever;
import com.destack.overflow.initializers.TagItemInitializer;

public class TagItemURLGenerator extends BaseURLGenerator implements URLGenerator<TagItemInitializer> {

    @Override
    public URL urlGenerator(TagItemInitializer tagItemInitializer)
            throws MalformedURLException, IllegalAccessException {
        String url = "https://api.stackexchange.com/2.2/tags?order=desc&sort=popular";
        String postFix = "&site=stackoverflow&filter=!-*f(6qOIRgw-";
        if (tagItemInitializer.getPage() != 0) {
            url += getPage(tagItemInitializer.getPage());
        }
        if (tagItemInitializer.getPageSize() != 0) {
            url += getPageSize(tagItemInitializer.getPageSize());
        }
        if (tagItemInitializer.getTagRetriever() != null) {
            TagRetriever tr = tagItemInitializer.getTagRetriever();
            if (tr.equals(TagRetriever.NORMAl) || tr.equals(TagRetriever.TAGS)
                    || tr.equals(TagRetriever.MODERATORY_ONLY) || tr.equals(TagRetriever.SYNONYMS)
                    || tr.equals(TagRetriever.TAGS_SYNONYMS)) {
                if (tagItemInitializer.getFromDate() != 0) {
                    url += getFromDate(tagItemInitializer.getFromDate());
                }
                if (tagItemInitializer.getToDate() != 0) {
                    url += getToDate(tagItemInitializer.getToDate());
                } //order,min,max,sort
                if (tagItemInitializer.getOrder() != null) {

                }

            }
        }
        return null;
    }

}
