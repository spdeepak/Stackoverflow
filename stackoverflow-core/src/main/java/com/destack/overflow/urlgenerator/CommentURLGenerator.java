package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.destack.overflow.initializers.CommentInitializer;
import com.destack.overflow.model.CommentItem;

/**
 * Generate URL to get {@link CommentItem} by using {@link CommentInitializer} and all
 * functionalities which can be obtained for an answer using it's ID
 * 
 * @author Deepak
 *
 */
public class CommentURLGenerator extends BaseURLComponentGenerator implements URLGenerator<CommentInitializer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentURLGenerator.class);

    @Override
    public URL urlGenerator(CommentInitializer commentInitializer) throws MalformedURLException {
        String url = "https://api.stackexchange.com/2.2/comments?";
        url = url.concat(getBaseURLComponents(commentInitializer));
        url += "&sort=".concat(commentInitializer.getSort().toString());
        url = urlFixer(url);

        if (commentInitializer.getComment_id() != null && !commentInitializer.getComment_id().isEmpty()) {
            LOGGER.info("Comment Fetcher URL with comment ID is generated");
            return new URL(url.replace("2.2/comments",
                    "2.2/comments/".concat(String.valueOf(getIdSetURLComponent(commentInitializer.getComment_id())))));
        } else {
            LOGGER.info("Comment Fetcher URL is generated");
            return new URL(url);
        }
    }

}
