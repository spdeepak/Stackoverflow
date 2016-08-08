package com.destack.overflow.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Retrieve posts based on<br/>
 * <br/>
 * <b>ALL</b> - <i>Fetches all posts.</i><br/>
 * <b>ID</b> - <i>Fetches a set of posts by ids.</i><br/>
 * <b>ID_COMMENT</b> - <i>Gets the comments on the posts identified in ids, regardless of the type
 * of the posts.</i><br/>
 * <b>ID_COMMENT_RENDER</b> - <i>Render a comment given its body and the post it's on.</i><br/>
 * <b>ID_RETRIEVER</b> - <i>Returns edit revisions for the posts identified in ids.</i><br/>
 * <b>SUGGESTED_EDITS</b> - <i>Returns suggsted edits on the posts identified in ids.</i>
 * 
 * @author Deepak
 *
 */
public enum PostRetriever {
    /**
     * Fetches all posts.
     */
    ALL,
    /**
     * Fetches a set of posts by ids.
     */
    ID,
    /**
     * Gets the comments on the posts identified in ids, regardless of the type of the posts.
     */
    ID_COMMENT,
    /**
     * Render a comment given its body and the post it's on.<br/>
     * Requires only Id and Body
     */
    ID_COMMENT_RENDER,
    /**
     * Returns edit revisions for the posts identified in ids.
     */
    ID_RETRIEVER,
    /**
     * Returns suggsted edits on the posts identified in ids.
     */
    SUGGESTED_EDITS;

    private static final Logger LOGGER = LoggerFactory.getLogger(PostRetriever.class);

    public static boolean isContains(PostRetriever postRetriever) {
        if (postRetriever != null) {
            for (PostRetriever sort : PostRetriever.class.getEnumConstants()) {
                if (sort.equals(postRetriever)) {
                    LOGGER.info("AnswerSortBy value is {}", sort);
                    return true;
                }
            }
        }
        LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
        return false;
    }

    public static boolean isValid(PostRetriever postRetriever) {
        if (postRetriever != null) {
            return isContains(postRetriever);
        } else {
            LOGGER.warn("AnswerSortBy is null. So, using default i.e, Activity");
            return false;
        }
    }
}
