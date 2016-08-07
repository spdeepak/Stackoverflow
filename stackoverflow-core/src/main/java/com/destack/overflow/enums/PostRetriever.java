package com.destack.overflow.enums;

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
     * Render a comment given its body and the post it's on.
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
}
