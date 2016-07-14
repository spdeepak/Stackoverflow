package com.destack.overflow.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Get {@link #ALL_ANSWERS}, {@link #ID_ANSWER} {@link #COMMENTS_IDANSWER} &
 * {@link #QUESTIONS_IDANSWER}
 * 
 * @author Deepak
 *
 */
public enum FetchFromAnswer {

    /**
     * -- Get answers identified by a set of id.<br/>
     * -- This is meant for batch fetcing of questions. A useful trick to poll for updates is to
     * sort by activity, with a minimum date of the last time you polled.<br/>
     * -- <b>ids</b> can contain up to 100 semicolon delimited <b>ids</b>.<br/>
     */
    ID_ANSWER,
    /**
     * -- Get comments on the answers identified by a set of <b>ids</b>.<br/>
     * -- If you know that you have an answer id and need the comments, use this.<br/>
     * -- <b>ids</b> can contain up to 100 semicolon delimited <b>ids</b>.<br/>
     * 
     */
    COMMENTS_IDANSWER,
    /**
     * -- Gets all questions the answers identified by ids are on.<br/>
     * -- Returns the questions that answers identied by <b>{ids}</b> are on.<br/>
     * -- <b>ids</b> can contain up to 100 semicolon delimited <b>ids</b>.<br/>
     */
    QUESTIONS_IDANSWER;

    private static final Logger LOGGER = LoggerFactory.getLogger(FetchFromAnswer.class);

    /**
     * Check whether value exists in {@link FetchFromAnswer}
     * 
     * @param fetchFromAnswer
     * @return
     */
    public static boolean contains(FetchFromAnswer fetchFromAnswer) {
        if (fetchFromAnswer != null) {
            for (FetchFromAnswer sort : FetchFromAnswer.class.getEnumConstants()) {
                if (sort.equals(fetchFromAnswer)) {
                    return true;
                }
            }
        }
        LOGGER.error("Fetch From Answer is Mandatory. Your value --> {}", fetchFromAnswer);
        return false;
    }

    /**
     * Validates {@link FetchFromAnswer} value
     * 
     * @param fetchFromAnswer
     * @return
     */
    public static boolean validate(FetchFromAnswer fetchFromAnswer) {
        if (fetchFromAnswer != null) {
            return contains(fetchFromAnswer);
        } else {
            LOGGER.error("Fetch From Answer is Mandatory. Your value --> {}", fetchFromAnswer);
            return false;
        }
    }
}
