package com.destack.overflow.enums;

/**
 * Get {@link #ALL_ANSWERS}, {@link #ID_ANSWER} {@link #COMMENTS_IDANSWER} &
 * {@link #QUESTIONS_IDANSWER}
 * 
 * @author Deepak
 *
 */
public enum FetchFromAnswer {
    /**
     * All answers
     */
    ALL_ANSWERS,
    /**
     * Get answers identified by a set of id
     */
    ID_ANSWER,
    /**
     * Get comments on the answers identified by a set of ids.
     */
    COMMENTS_IDANSWER,
    /**
     * Gets all questions the answers identified by ids are on.
     */
    QUESTIONS_IDANSWER;
}
