package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.Order;
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
        if (commentInitializer.getPage() != 0) {
            url += getPageURL(commentInitializer.getPage());
        }
        if (commentInitializer.getPageSize() != 0) {
            url += getPageSizeURL(commentInitializer.getPageSize());
        }
        if (commentInitializer.getFromDate() != 0) {
            url += getFromDate(commentInitializer.getFromDate());
        }
        if (commentInitializer.getToDate() != 0) {
            url += getToDate(commentInitializer.getToDate());
        }
        if (!commentInitializer.getOrder().toString().isEmpty()) {
            url += getOrder(commentInitializer.getOrder().toString());
        } else {
            url += getOrder(Order.DESC.toString());
        }
        if (commentInitializer.getSort() != null && !commentInitializer.getSort().toString().isEmpty()) {
            url += getSort(commentInitializer.getSort().toString());
        } else {
            url += getSort(AnswerSortBy.ACTIVITY.toString());
        }
        if (commentInitializer.getMin() != 0) {
            url += getMin(String.valueOf(commentInitializer.getMin()));
        }
        if (commentInitializer.getMax() != 0) {
            url += getMax(String.valueOf(commentInitializer.getMax()));
        }
        url += "&site=stackoverflow";
        url = urlFixer(url);
        return url;
    }

}
