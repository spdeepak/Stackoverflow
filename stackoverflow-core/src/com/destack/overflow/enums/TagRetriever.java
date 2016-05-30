package com.destack.overflow.enums;


/**
 * @author Deepak
 *
 */
public enum TagRetriever {
    /**
     * Get the tags on the site.
     */
    NORMAl,
    /**
     * Get tags on the site by their names.
     */
    TAGS,
    /**
     * Get the tags on the site that only moderators can use.
     */
    MODERATORY_ONLY,
    /**
     * Get the tags on the site that fulfill required tag constraints.
     */
    REQUIRED,
    /**
     * Get all the tag synonyms on the site.
     */
    SYNONYMS,
    /**
     * Get frequently asked questions in a set of tags.
     */
    TAGS_FAQ,
    /**
     * Get related tags, based on common tag pairings.
     */
    TAGS_RELATED,
    /**
     * Get the synonyms for a specific set of tags.
     */
    TAGS_SYNONYMS,
    /**
     * Get the top answer posters in a specific tag, either in the last month or for all time.
     */
    TOP_ANSWERS,
    /**
     * Get the top question askers in a specific tag, either in the last month or for all time.
     */
    TOP_ASKERS,
    /**
     * Get the wiki entries for a set of tags.
     */
    WIKIS;
}
