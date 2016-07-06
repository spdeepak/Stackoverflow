package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import com.destack.overflow.enums.TagRetriever;
import com.destack.overflow.initializers.TagItemInitializer;
import com.destack.overflow.model.TagItem;

/**
 * {@link TagItem}'s {@link URL} generator
 * 
 * @author Deepak
 *
 */
public class TagItemURLGenerator extends BaseURLComponentGenerator implements URLGenerator<TagItemInitializer> {

    private static final String URL = "https://api.stackexchange.com/2.2/tags?";

    private static final String POSTFIX = "&filter=!-*f(6qOIRgw-";

    @Override
    public URL urlGenerator(TagItemInitializer tagItemInitializer)
            throws MalformedURLException, IllegalAccessException {
        TagRetriever tagRetriever = tagItemInitializer.getTagRetriever();
        if (TagRetriever.DEFAULT.equals(tagRetriever)) {
            return tagRetrieversDefaultModOnlyURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.TAGS.equals(tagRetriever)) {
            return tagRetrieversTagsURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.MODERATORY_ONLY.equals(tagRetriever)) {
            return tagRetrieverModOnlyURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.REQUIRED.equals(tagRetriever)) {
            return tagRetrieverRequiredURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.SYNONYMS.equals(tagRetriever)) {
            return tagRetrieverSynonymsURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.TAGS_FAQ.equals(tagRetriever)) {
            return tagRetrieverFaqURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.TAGS_RELATED.equals(tagRetriever)) {
            return tagRetrieverTagsRelatedURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.TAGS_SYNONYMS.equals(tagRetriever)) {
            return tagRetrieverTagsSynonymsURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.TOP_ANSWERS.equals(tagRetriever)) {
            return tagRetrieverTopAnswersURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.TOP_ASKERS.equals(tagRetriever)) {
            return tagRetrieverTopAskersURL(tagItemInitializer, URL, POSTFIX);
        } else if (TagRetriever.WIKIS.equals(tagRetriever)) {
            return tagRetrieverURLWikis(tagItemInitializer, URL, POSTFIX);
        }
        throw new IllegalArgumentException("TagRetriever not provided in TagItemInitializer.TagRetriever is Mandatory");
    }

    private URL tagRetrieverSynonymsURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = getSetURLComponent(tagItemInitializer.getTags());
        if (!tagurl.trim().isEmpty()) {
            url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/synonyms?"));
            tagurl = null;
        } else {
            url = url.replace("2.2/tags?", "2.2/tags".concat("/synonyms?"));
        }
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSortSynonyms().toString());
        url = urlFixer(url);
        url += postFix;
        return new URL(url);
    }

    private URL tagRetrieverURLWikis(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = getSetURLComponent(tagItemInitializer.getTags());
        if (!tagurl.trim().isEmpty()) {
            url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/wikis?"));
            tagurl = null;
        } else {
            url = url.replace("2.2/tags?", "2.2/tags".concat("/wikis?"));
        }
        url = commonURLForFaqRelatedWikis(tagItemInitializer, url, postFix);
        return new URL(url);
    }

    private URL tagRetrieverTopAskersURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = getSetURLComponent(tagItemInitializer.getTags());
        if (!tagurl.trim().isEmpty()) {
            url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/top-askers?"));
            tagurl = null;
        } else {
            url = url.replace("2.2/tags?", "2.2/tags".concat("/top-askers?"));
        }
        url = commonURLForTopAnswersAndTopAskers(tagItemInitializer, url, postFix);
        return new URL(url);
    }

    private URL tagRetrieverTopAnswersURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = getSetURLComponent(tagItemInitializer.getTags());
        if (!tagurl.trim().isEmpty()) {
            url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/top-answerers?"));
            tagurl = null;
        } else {
            url = url.replace("2.2/tags?", "2.2/tags".concat("/top-answerers?"));
        }
        url = commonURLForTopAnswersAndTopAskers(tagItemInitializer, url, postFix);
        return new URL(url);
    }

    private String commonURLForTopAnswersAndTopAskers(TagItemInitializer tagItemInitializer, String url,
            String postFix) {
        url = url.replace("/top-answerers?",
                "/top-answerers/".concat(tagItemInitializer.getTagPeriod().toString()).concat("?"));
        url = commonURLForFaqRelatedWikis(tagItemInitializer, url, postFix);
        return url;
    }

    private URL tagRetrieverTagsSynonymsURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = getSetURLComponent(tagItemInitializer.getTags());
        if (!tagurl.trim().isEmpty()) {
            url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/synonyms?"));
            tagurl = null;
        } else {
            url = url.replace("2.2/tags?", "2.2/tags".concat("/synonyms?"));
        }
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSort().toString());
        url += getInNameURLComponent(tagItemInitializer.getInName());
        url = urlFixer(url);
        url += postFix;
        return new URL(url);
    }

    private URL tagRetrieverTagsRelatedURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = "tags?".concat(getSetURLComponent(tagItemInitializer.getTags()));
        if (!tagurl.trim().isEmpty()) {
            url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/related?"));
            tagurl = null;
        } else {
            url = url.replace("2.2/tags?", "2.2/tags".concat("/related?"));
        }
        url = commonURLForFaqRelatedWikis(tagItemInitializer, url, postFix);
        return new URL(url);
    }

    private String commonURLForFaqRelatedWikis(TagItemInitializer tagItemInitializer, String url, String postFix) {
        url += getPageURL(tagItemInitializer.getPage());
        url += getPageSizeURL(tagItemInitializer.getPageSize());
        url = urlFixer(url);
        url += postFix;
        return url;
    }

    private URL tagRetrieverFaqURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = "tags?".concat(getSetURLComponent(tagItemInitializer.getTags()));
        if (!tagurl.trim().isEmpty()) {
            url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/faq?"));
            tagurl = null;
        } else {
            url = url.replace("2.2/tags?", "2.2/tags".concat("/faq?"));
        }
        url = commonURLForFaqRelatedWikis(tagItemInitializer, url, postFix);
        return new URL(url);
    }

    private URL tagRetrieverRequiredURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        url = url.replace("2.2/tags?", "2.2/tags/".concat("required?"));
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSort().toString());
        url += getInNameURLComponent(tagItemInitializer.getInName());
        url = urlFixer(url);
        url += postFix;
        return new URL(url);
    }

    private URL tagRetrieverModOnlyURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        url = url.replace("2.2/tags?", "2.2/tags/".concat("moderator-only?"));
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSort().toString());
        url += getInNameURLComponent(tagItemInitializer.getInName());
        url = urlFixer(url);
        url += postFix;
        return new URL(url);
    }

    private URL tagRetrieversTagsURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = "tags?".concat(getSetURLComponent(tagItemInitializer.getTags()));
        if (!tagurl.trim().isEmpty()) {
            url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/info?"));
            tagurl = null;
        } else {
            url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/info?"));
        }
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSort().toString());
        url = urlFixer(url);
        url += postFix;
        return new URL(url);
    }

    private URL tagRetrieversDefaultModOnlyURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSort().toString());
        url += getInNameURLComponent(tagItemInitializer.getInName());
        url = urlFixer(url);
        url += postFix;
        return new URL(url);
    }

}