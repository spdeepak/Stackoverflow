package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.destack.overflow.json.JsonFetcher;
import com.destack.overflow.model.CommentItem;
import com.destack.overflow.model.CommentItem.CommentOwner;
import com.destack.overflow.model.CommentItem.ReplyToUser;

public class CommentItemFetcher implements Fetcher<CommentItem> {

    @Override
    public List<CommentItem> objectFetcher(URL jsonURL) throws FileNotFoundException, IOException {
        CommentItem commentItem;
        CommentOwner commentOwner;
        ReplyToUser replyToUser;
        List<CommentItem> commentItemList = new ArrayList();
        JSONArray items = (JSONArray) JsonFetcher.getJson(jsonURL).get("items");
        JSONObject item;
        JSONObject owner;
        JSONObject reply_to_user;
        for (int i = 0; i < items.length(); i++) {
            item = items.getJSONObject(i);
            owner = item.getJSONObject("owner");
            if (item.has("reply_to_user")) {
                reply_to_user = item.getJSONObject("reply_to_user");
            }
            item = null;
            owner = null;
            reply_to_user = null;
        }
        items = null;
        return commentItemList;
    }

}
