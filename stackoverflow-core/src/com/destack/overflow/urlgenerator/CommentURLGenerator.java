package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.CommentInitializer;

/**
 * @author Deepak
 *
 */
public class CommentURLGenerator implements URLGenerator<CommentInitializer> {

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
        if (commentInitializer.getPage() != 0) {
            url += "&page=".concat(String.valueOf(commentInitializer.getPage()));
        }
        if (commentInitializer.getPageSize() != 0) {
            url += "&pagesize=".concat(String.valueOf(commentInitializer.getPageSize()));
        }
        if (commentInitializer.getFromDate() != 0) {
            url += "&fromdate=".concat(String.valueOf(commentInitializer.getFromDate()));
        }
        if (commentInitializer.getToDate() != 0) {
            url += "&todate=".concat(String.valueOf(commentInitializer.getToDate()));
        }
        if (!commentInitializer.getOrder().toString().isEmpty()) {
            url += "&order=".concat(commentInitializer.getOrder().toString());
        } else {
            url += "&order=".concat(Order.DESC.toString());
        }
        if (commentInitializer.getSort() != null && !commentInitializer.getSort().toString().isEmpty()) {
            url += "&sort=".concat(commentInitializer.getSort().toString());
        } else {
            url += "&sort=".concat(AnswerSortBy.ACTIVITY.toString());
        }
        if (commentInitializer.getMin() != 0) {
            url += "&min=".concat(String.valueOf(commentInitializer.getMin()));
        }
        if (commentInitializer.getMax() != 0) {
            url += "&max=".concat(String.valueOf(commentInitializer.getMax()));
        }
        url += "&site=stackoverflow";
        url = url.replace("https://api.stackexchange.com/2.2/comments?&",
                "https://api.stackexchange.com/2.2/comments?");
        return url;
    }

}
