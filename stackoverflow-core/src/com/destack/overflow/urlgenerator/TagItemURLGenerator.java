package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import com.destack.overflow.enums.TagRetriever;
import com.destack.overflow.initializers.TagItemInitializer;

/**
 * @author Deepak
 *
 */
public class TagItemURLGenerator extends BaseURLComponentGenerator implements URLGenerator<TagItemInitializer> {

    @Override
    public URL urlGenerator(TagItemInitializer tagItemInitializer)
            throws MalformedURLException, IllegalAccessException {
        String url = "https://api.stackexchange.com/2.2/tags?";
        String postFix = "&filter=!-*f(6qOIRgw-";
        TagRetriever tagRetriever = tagItemInitializer.getTagRetriever();
        if (TagRetriever.DEFAULT.equals(tagRetriever)) {
            return tagRetrieversDefaultURL(tagItemInitializer, url, postFix);
        } else if (TagRetriever.TAGS.equals(tagRetriever)) {
            return tagRetrieversTagsURL(tagItemInitializer, url);
        }
        return null;
    }

    private URL tagRetrieversTagsURL(TagItemInitializer tagItemInitializer, String url) throws MalformedURLException {
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSort().toString());
        String tagurl = "tags?".concat(getSetURLComponent(tagItemInitializer.getTags()));
        url = urlFixer(url);
        url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/info?"));
        return new URL(url);
    }

    private URL tagRetrieversDefaultURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSort().toString());
        url += getInNameURLComponent(tagItemInitializer.getInName());
        url = urlFixer(url);
        url += postFix;
        return new URL(url);
    }

}