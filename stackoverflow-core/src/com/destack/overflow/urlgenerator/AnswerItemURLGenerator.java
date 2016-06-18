package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.FetchFromAnswer;
import com.destack.overflow.initializers.AnswerInitializer;
import com.destack.overflow.model.AnswerItem;

/**
 * Generate URL to get {@link AnswerItem} by using {@link AnswerInitializer} and all functionalities
 * which can be obtained for an answer using it's ID
 * 
 * @author Deepak
 *
 */
public class AnswerItemURLGenerator extends BaseURLComponentGenerator implements URLGenerator<AnswerInitializer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerItemURLGenerator.class);

    @Override
    public URL urlGenerator(AnswerInitializer ai) throws MalformedURLException {
        String url = "https://api.stackexchange.com/2.2/answers?";
        url += getBaseURL(ai);
        if (ai.getSort() != null && !ai.getSort().toString().isEmpty()) {
            url += getSort(ai.getSort().toString());
        } else {
            url += getSort(AnswerSortBy.ACTIVITY.toString());
        }
        url = urlFixer(url);
        return new URL(url);
    }

    public URL urlGenerator(AnswerInitializer answerInitializer, String answerId, FetchFromAnswer fetchFromAnswer)
            throws MalformedURLException {
        if (fetchFromAnswer == null || fetchFromAnswer.equals(FetchFromAnswer.ALL_ANSWERS)) {
            return urlGenerator(answerInitializer);
        }
        if (fetchFromAnswer == null || fetchFromAnswer.equals(FetchFromAnswer.ID_ANSWER)) {
            if (Long.valueOf(answerId.trim()) == 0) {
                LOGGER.debug("answerId is zero so returning a ALL_ANSWERS URL");
                return urlGenerator(answerInitializer);
            }
            return new URL(
                    urlGenerator(answerInitializer).toString().replace("https://api.stackexchange.com/2.2/answers?&",
                            "https://api.stackexchange.com/2.2/answers/".concat(answerId).concat("?")));
        }
        if (fetchFromAnswer == null || fetchFromAnswer.equals(FetchFromAnswer.COMMENTS_IDANSWER)) {
            if (answerInitializer.getSort() == null || answerInitializer.getSort().equals(AnswerSortBy.ACTIVITY)) {
                answerInitializer.setSort(AnswerSortBy.CREATION);
            }
            if (Long.valueOf(answerId.trim()) == 0) {
                LOGGER.debug("answerId is zero so returning a ALL_ANSWERS URL");
                return urlGenerator(answerInitializer);
            }
            return new URL(
                    urlGenerator(answerInitializer).toString().replace("https://api.stackexchange.com/2.2/answers?&",
                            "https://api.stackexchange.com/2.2/answers/".concat(answerId).concat("/comments?")));
        }
        if (fetchFromAnswer == null || fetchFromAnswer.equals(FetchFromAnswer.QUESTIONS_IDANSWER)) {
            if (Long.valueOf(answerId.trim()) == 0) {
                LOGGER.debug("answerId is zero so returning a ALL_ANSWERS URL");
                return urlGenerator(answerInitializer);
            }
            return new URL(
                    urlGenerator(answerInitializer).toString().replace("https://api.stackexchange.com/2.2/answers?&",
                            "https://api.stackexchange.com/2.2/answers/".concat(answerId).concat("/questions?")));
        }
        LOGGER.debug("All parameters passed are not valid except AnswerInitializer. So, returning All answer's URL");
        return urlGenerator(answerInitializer);
    }
}
