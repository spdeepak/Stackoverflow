package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import com.destack.overflow.enums.CommentSortBy;
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

    @Override
    public URL urlGenerator(CommentInitializer commentInitializer) throws MalformedURLException {
        String url = "https://api.stackexchange.com/2.2/comments?";
        if (commentInitializer.getComment_id() != 0) {
            return new URL(plainURLGenerator(commentInitializer, url)
                    .replace("https://api.stackexchange.com/2.2/comments", "https://api.stackexchange.com/2.2/comments/"
                            .concat(String.valueOf(commentInitializer.getComment_id()))));
        }
        return new URL(plainURLGenerator(commentInitializer, url));
    }

    private String plainURLGenerator(CommentInitializer commentInitializer, String url) throws MalformedURLException {
        url = url.concat(getBaseURLComponents(commentInitializer));
        if (commentInitializer.getSort() != null) {
            url += "&sort=".concat(commentInitializer.getSort().toString());
        } else {
            url += "&sort=".concat(CommentSortBy.CREATION.toString());
        }
        url = urlFixer(url);
        return url;
    }

}
