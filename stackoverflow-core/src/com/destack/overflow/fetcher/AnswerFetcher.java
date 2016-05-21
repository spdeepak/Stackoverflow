package com.destack.overflow.fetcher;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.SortBy;
import com.destack.overflow.initializers.AnswerInitializer;
import com.destack.overflow.util.JsonUtil;

/**
 * @author Deepak
 *
 */
public class AnswerFetcher {

    public URL answerURLGenerator(AnswerInitializer ai) throws MalformedURLException {
        String url = "https://api.stackexchange.com/2.2/answers?";
        if (ai.getPage() != 0) {
            url += "&page=".concat(String.valueOf(ai.getPage()));
        }
        if (ai.getPageSize() != 0) {
            url += "&pagesize=".concat(String.valueOf(ai.getPageSize()));
        }
        if (ai.getFromDate() != 0) {
            url += "&fromdate=".concat(String.valueOf(ai.getFromDate()));
        }
        if (ai.getToDate() != 0) {
            url += "&todate=".concat(String.valueOf(ai.getToDate()));
        }
        if (!ai.getOrder().toString().isEmpty()) {
            url += "&order=".concat(ai.getOrder().toString());
        } else {
            url += "&order=".concat(Order.DESC.toString());
        }
        if (ai.getSort() != null && !ai.getSort().toString().isEmpty()) {
            url += "&sort=".concat(ai.getSort().toString());
        } else {
            url += "&sort=".concat(SortBy.ACTIVITY.toString());
        }
        if (ai.getMin() != 0) {
            url += "&min=".concat(String.valueOf(ai.getMin()));
        }
        if (ai.getMax() != 0) {
            url += "&max=".concat(String.valueOf(ai.getMax()));
        }
        url += "&site=stackoverflow";
        url = url.replace("https://api.stackexchange.com/2.2/answers?&", "https://api.stackexchange.com/2.2/answers?");
        return new URL(url);
    }

    public JSONObject jsonFetcher(AnswerInitializer answerInitializer) {
        try {
            return JsonUtil.urlToJson(answerURLGenerator(answerInitializer));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

}
