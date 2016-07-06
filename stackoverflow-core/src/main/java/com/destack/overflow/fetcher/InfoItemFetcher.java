package com.destack.overflow.fetcher;

import java.net.MalformedURLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.destack.overflow.json.JsonFetcher;
import com.destack.overflow.model.InfoItem;

/**
 * Get Latest information about the entire site.
 * 
 * @author Deepak
 *
 */
public class InfoItemFetcher {

    private static final String URL = "https://api.stackexchange.com/2.2/info?site=stackoverflow&filter=!-*f(6qwmgGVU";

    public InfoItem objectFetcher() throws MalformedURLException {
        InfoItem infoItem = new InfoItem();
        JSONArray items = JsonFetcher.urlToJson(URL).getJSONArray("items");
        JSONObject item;
        int i = 0;
        while (i == 0) {
            item = items.getJSONObject(i);
            infoItem.setNew_active_users(item.getInt("new_active_users"));
            infoItem.setTotal_users(item.getInt("total_users"));
            infoItem.setBadges_per_minute(item.getDouble("badges_per_minute"));
            infoItem.setTotal_badges(item.getInt("total_badges"));
            infoItem.setTotal_votes(item.getInt("total_votes"));
            infoItem.setTotal_comments(item.getInt("total_comments"));
            infoItem.setAnswers_per_minute(item.getDouble("answers_per_minute"));
            infoItem.setQuestions_per_minute(item.getDouble("questions_per_minute"));
            infoItem.setTotal_answers(item.getInt("total_answers"));
            infoItem.setTotal_accepted(item.getInt("total_accepted"));
            infoItem.setTotal_unanswered(item.getInt("total_unanswered"));
            infoItem.setTotal_questions(item.getInt("total_questions"));
            infoItem.setApi_revision(item.getString("api_revision"));
            i = 1;
        }
        return infoItem;
    }

}
