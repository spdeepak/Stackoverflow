package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.destack.overflow.json.JsonFetcher;
import com.destack.overflow.model.AnswerItem;
import com.destack.overflow.model.Owner;

/**
 * Pass Json Url and get {@link List} of {@link AnswerItem}
 * 
 * @author Deepak
 *
 */
public class AnswerItemFetcher implements Fetcher<AnswerItem> {

    @Override
    public List<AnswerItem> objectFetcher(URL jsonURL) throws FileNotFoundException, IOException {
        AnswerItem answerItem;
        Owner answerOwner;
        if (!JsonFetcher.urlToJson(jsonURL).has("items")) {
            errorMessages(jsonURL);
        }
        List<AnswerItem> answerItemList = new ArrayList();
        JSONArray items = JsonFetcher.urlToJson(jsonURL).getJSONArray("items");
        JSONObject item;
        JSONObject owner;
        for (int i = 0; i < items.length(); i++) {
            answerItem = new AnswerItem();
            answerOwner = new Owner();
            item = items.getJSONObject(i);
            owner = item.getJSONObject("owner");
            if (owner.has("reputation")) {
                answerOwner.setReputation((Integer) owner.get("reputation"));
            }
            if (owner.has("user_id")) {
                answerOwner.setUser_id((Integer) owner.get("user_id"));
            }
            if (owner.has("user_type")) {
                answerOwner.setUser_type((String) owner.get("user_type"));
            }
            if (owner.has("accept_rate")) {
                answerOwner.setAccept_rate((Integer) owner.get("accept_rate"));
            }
            if (owner.has("profile_image")) {
                answerOwner.setProfile_image((String) owner.get("profile_image"));
            }
            if (owner.has("display_name")) {
                answerOwner.setDisplay_name((String) owner.get("display_name"));
            }
            if (owner.has("link")) {
                answerOwner.setLink((String) owner.get("link"));
            }
            answerItem.setAnswerOwner(answerOwner);
            if (item.has("is_accepted")) {
                answerItem.setIs_accepted((boolean) item.get("is_accepted"));
            }
            if (item.has("community_owned_date")) {
                answerItem.setCommunity_owned_date((long) item.get("community_owned_date"));
            }
            if (item.has("score")) {
                answerItem.setScore((Integer) item.get("score"));
            }
            if (item.has("last_activity_date")) {
                answerItem.setLast_activity_date((Integer) item.get("last_activity_date"));
            }
            if (item.has("last_edit_date")) {
                answerItem.setLast_edit_date(item.getInt("last_edit_date"));
            }
            if (item.has("creation_date")) {
                answerItem.setCreation_date((Integer) item.get("creation_date"));
            }
            if (item.has("answer_id")) {
                answerItem.setAnswer_id((Integer) item.get("answer_id"));
            }
            if (item.has("question_id")) {
                answerItem.setQuestion_id((Integer) item.get("question_id"));
            }
            answerItemList.add(answerItem);
            answerItem = null;
            answerOwner = null;
        }
        items = null;
        item = null;
        owner = null;
        return answerItemList;
    }

}
