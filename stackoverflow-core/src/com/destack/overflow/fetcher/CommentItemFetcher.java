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
            commentItem = new CommentItem();
            commentOwner = commentItem.new CommentOwner();
            replyToUser = commentItem.new ReplyToUser();
            item = items.getJSONObject(i);
            owner = item.getJSONObject("owner");
            if (owner.has("reputation")) {
                commentOwner.setReputation((Integer) owner.get("reputation"));
            }
            if (owner.has("user_id")) {
                commentOwner.setUser_id((Integer) owner.get("user_id"));
            }
            if (owner.has("user_type")) {
                commentOwner.setUser_type((String) owner.get("user_type"));
            }
            if (owner.has("accept_rate")) {
                commentOwner.setAccept_rate((Integer) owner.get("accept_rate"));
            }
            if (owner.has("profile_image")) {
                commentOwner.setProfile_image((String) owner.get("profile_image"));
            }
            if (owner.has("display_name")) {
                commentOwner.setDisplay_name((String) owner.get("display_name"));
            }
            if (owner.has("link")) {
                commentOwner.setLink((String) owner.get("link"));
            }
            commentItem.setCommentOwner(commentOwner);
            if (item.has("reply_to_user")) {
                reply_to_user = item.getJSONObject("reply_to_user");
                if (reply_to_user.has("reputation")) {
                    replyToUser.setReputation(reply_to_user.getInt("reputation"));
                }
                if (reply_to_user.has("user_id")) {
                    replyToUser.setUser_id(reply_to_user.getInt("user_id"));
                }
                if (reply_to_user.has("user_type")) {
                    replyToUser.setUser_type(reply_to_user.getString("user_type"));
                }
                if (reply_to_user.has("accept_rate")) {
                    replyToUser.setAccept_rate(reply_to_user.getInt("accept_rate"));
                }
                if (reply_to_user.has("profile_image")) {
                    replyToUser.setProfile_image(reply_to_user.getString("profile_image"));
                }
                if (reply_to_user.has("display_name")) {
                    replyToUser.setDisplay_name(reply_to_user.getString("display_name"));
                }
                if (reply_to_user.has("link")) {
                    replyToUser.setLink(reply_to_user.getString("link"));
                }
            }
            commentItem.setReplyToUser(replyToUser);
            if (item.has("edited")) {
                commentItem.setEdited(item.getBoolean("edited"));
            }
            if (item.has("score")) {
                commentItem.setScore(item.getInt("score"));
            }
            if (item.has("creation_date")) {
                commentItem.setCreation_date(item.getInt("creation_date"));
            }
            if (item.has("post_id")) {
                commentItem.setPost_id(item.getInt("post_id"));
            }
            if (item.has("comment_id")) {
                commentItem.setComment_id(item.getInt("comment_id"));
            }
            commentItemList.add(commentItem);
            commentItem = null;
            commentOwner = null;
            replyToUser = null;
        }
        items = null;
        item = null;
        owner = null;
        return commentItemList;
    }

}
