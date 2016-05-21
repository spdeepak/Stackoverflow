package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.destack.overflow.model.AnswerItem;
import com.destack.overflow.model.AnswerItem.AnswerOwner;

/**
 * Pass Json Url and get {@link List} of {@link AnswerItem}
 * 
 * @author Deepak
 *
 */
public class AnswerItemFetcher implements Fetcher<AnswerItem> {


    /*
     * (non-Javadoc)
     * 
     * @see com.destack.overflow.fetcher.Fetcher#objectFetcher(java.net.URL)
     * 
     */
    @Override
    public List<AnswerItem> objectFetcher(URL jsonURL) throws FileNotFoundException, IOException, ParseException {
        AnswerItem answerItem = new AnswerItem();
        AnswerOwner answerOwner = answerItem.new AnswerOwner();
        List<AnswerItem> answerItemList = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(jsonURL.toString()));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray items = (JSONArray) jsonObject.get("items");
        JSONObject item;
        JSONObject owner;
        for (int i = 0; i < items.size(); i++) {
            item = (JSONObject) items.get(i);
            owner = (JSONObject) item.get("owner");
            answerOwner.setReputation((String) owner.get("reputation"));
            answerOwner.setUser_id((String) owner.get("user_id"));
            answerOwner.setUser_type((String) owner.get("user_type"));
            answerOwner.setAccept_range((String) owner.get("accept_rate"));
            answerOwner.setProfile_image((URL) owner.get("profile_image"));
            answerOwner.setDisplay_name((String) owner.get("display_name"));
            answerOwner.setLink((URL) owner.get("link"));
            answerItem.setAnswerOwner(answerOwner);
            answerItem.setIs_accepted((boolean) item.get("is_accepted"));
            answerItem.setScore((long) item.get("score"));
            answerItem.setLast_activity_date((long) item.get("last_activity_date"));
            answerItem.setCreation_date((long) item.get("creation_date"));
            answerItem.setAnswer_id((long) item.get("answer_id"));
            answerItem.setQuestion_id((long) item.get("question_id"));
            answerItemList.add(answerItem);
        }
        answerItem = null;
        answerOwner = null;
        parser = null;
        obj = null;
        jsonObject.clear();
        items.clear();
        item = null;
        owner = null;
        return answerItemList;
    }

}
