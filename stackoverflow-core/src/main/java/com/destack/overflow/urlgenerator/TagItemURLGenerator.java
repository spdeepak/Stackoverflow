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
        } else if (TagRetriever.MODERATOR_ONLY.equals(tagRetriever)) {
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
        } else {
            // if (TagRetriever.WIKIS.equals(tagRetriever))
            return tagRetrieverURLWikis(tagItemInitializer, URL, POSTFIX);
        }
    }

    private URL tagRetrieverSynonymsURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        url = url.replace("2.2/tags?", "2.2/tags".concat("/synonyms?"));
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSortSynonyms().toString());
        url = urlFixer(url);
        url += postFix;
        return new URL(url);
    }

    private URL tagRetrieverURLWikis(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = getSetURLComponent(tagItemInitializer.getTags());
        url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/wikis?"));
        url = pagePagesizeURL(tagItemInitializer, url, postFix);
        return new URL(url);
    }

    private URL tagRetrieverTopAskersURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        url = url.replace("2.2/tags?", "2.2/tags/".concat(tagItemInitializer.getTag()).concat("/top-askers/")
                .concat(tagItemInitializer.getTagPeriod().toString()).concat("?"));
        url = pagePagesizeURL(tagItemInitializer, url, postFix);
        return new URL(url);
    }

    private URL tagRetrieverTopAnswersURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = tagItemInitializer.getTag();
        url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/top-answerers?"));
        url = url.replace("/top-answerers?",
                "/top-answerers/".concat(tagItemInitializer.getTagPeriod().toString()).concat("?"));
        url = pagePagesizeURL(tagItemInitializer, url, postFix);
        return new URL(url);
    }

    private URL tagRetrieverTagsSynonymsURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = getSetURLComponent(tagItemInitializer.getTags());
        url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/synonyms?"));
        url += getBaseURLComponents(tagItemInitializer);
        url += getSortURLComponent(tagItemInitializer.getSort().toString());
        url += getInNameURLComponent(tagItemInitializer.getInName());
        url = urlFixer(url);
        url += postFix;
        return new URL(url);
    }

    private URL tagRetrieverTagsRelatedURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        String tagurl = getSetURLComponent(tagItemInitializer.getTags());
        url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/related?"));
        url = pagePagesizeURL(tagItemInitializer, url, postFix);
        return new URL(url);
    }

    private String pagePagesizeURL(TagItemInitializer tagItemInitializer, String url, String postFix) {
        url += getPageURL(tagItemInitializer.getPage());
        url += getPageSizeURL(tagItemInitializer.getPageSize());
        url = urlFixer(url);
        url += postFix;
        return url;
    }

    private URL tagRetrieverFaqURL(TagItemInitializer tagItemInitializer, String url, String postFix)
            throws MalformedURLException {
        url = url.replace("2.2/tags?",
                "2.2/tags/".concat(getSetURLComponent(tagItemInitializer.getTags())).concat("/faq?"));
        url = pagePagesizeURL(tagItemInitializer, url, postFix);
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
        String tagurl = getSetURLComponent(tagItemInitializer.getTags());
        url = url.replace("2.2/tags?", "2.2/tags/".concat(tagurl).concat("/info?"));
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