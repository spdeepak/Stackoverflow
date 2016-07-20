package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.destack.overflow.enums.FetchFromAnswer;
import com.destack.overflow.initializers.AnswerItemInitializer;
import com.destack.overflow.model.AnswerItem;

/**
 * Generate URL to get {@link AnswerItem} by using {@link AnswerInitializer} and all functionalities
 * which can be obtained for an answer using it's ID
 * 
 * @author Deepak
 *
 */
public class AnswerItemURLGenerator extends BaseURLComponentGenerator implements URLGenerator<AnswerItemInitializer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnswerItemURLGenerator.class);

    @Override
    public URL urlGenerator(AnswerItemInitializer ai) throws MalformedURLException {
        String url = "https://api.stackexchange.com/2.2/answers?";
        url += getBaseURLComponents(ai);
        url += getSortURLComponent(ai.getSort().toString());
        url = urlFixer(url);
        String replace = "";
        if (FetchFromAnswer.isValid(ai.getFetchFromAnswer())) {
            switch (ai.getFetchFromAnswer()) {
                case ID_ANSWER:
                    replace = "answers/".concat(getIdSetURLComponent(ai.getIds()).concat("?"));
                    url = url.replace("answers?", replace);
                    break;
                case COMMENTS_IDANSWER:
                    replace = "answers/".concat(getIdSetURLComponent(ai.getIds())).concat("/comments?");
                    url = url.replace("answers?", replace);
                    break;
                case QUESTIONS_IDANSWER:
                    replace = "answers/".concat(getIdSetURLComponent(ai.getIds())).concat("/questions?");
                    url = url.replace("answers?", replace);
                    break;
                default:
                    break;
            }
        }
        LOGGER.info("Default URL generated");
        return new URL(url);
    }

}
