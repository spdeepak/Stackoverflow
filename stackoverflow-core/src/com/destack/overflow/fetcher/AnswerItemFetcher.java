package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.destack.overflow.enums.FetchFromAnswer;
import com.destack.overflow.initializers.AnswerInitializer;
import com.destack.overflow.json.JsonFetcher;
import com.destack.overflow.model.AnswerItem;
import com.destack.overflow.model.AnswerItem.AnswerOwner;
import com.destack.overflow.urlgenerator.AnswerItemURLGenerator;

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
        AnswerOwner answerOwner;
        List<AnswerItem> answerItemList = new ArrayList();
        JSONArray items = (JSONArray) JsonFetcher.getJson(jsonURL).get("items");
        JSONObject item;
        JSONObject owner;
        for (int i = 0; i < items.length(); i++) {
            answerItem = new AnswerItem();
            answerOwner = answerItem.new AnswerOwner();
            item = (JSONObject) items.get(i);
            owner = (JSONObject) item.get("owner");
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
                answerOwner.setAccept_range((Integer) owner.get("accept_rate"));
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

    /**
     * Pass the {@link AnswerInitializer} and get the {@link AnswerItem} object which contains the
     * required Answer's based on the {@link AnswerInitializer}'s parameter's
     * 
     * @param answerInitializer
     * @return
     * @throws FileNotFoundException
     * @throws MalformedURLException
     * @throws IOException
     */
    public List<AnswerItem> objectFetcher(AnswerInitializer answerInitializer)
            throws FileNotFoundException, MalformedURLException, IOException {
        return objectFetcher(new AnswerItemURLGenerator().urlGenerator(answerInitializer));
    }

    /**
     * Pass the {@link AnswerInitializer}, Answer Id & {@link FetchFromAnswer} to get the
     * {@link AnswerItem} object which contains the required Answer's based on the
     * {@link AnswerInitializer}'s parameter's
     * 
     * @param answerInitializer
     * @param answerId
     * @param fetchFromAnswer
     * @return
     * @throws FileNotFoundException
     * @throws MalformedURLException
     * @throws IOException
     */
    public List<AnswerItem> objectFetcher(AnswerInitializer answerInitializer, String answerId,
            FetchFromAnswer fetchFromAnswer) throws FileNotFoundException, MalformedURLException, IOException {
        return objectFetcher(new AnswerItemURLGenerator().urlGenerator(answerInitializer, answerId, fetchFromAnswer));
    }

}
