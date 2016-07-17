package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.destack.overflow.json.JsonFetcher;
import com.destack.overflow.model.BadgeCount;
import com.destack.overflow.model.CommentItem;
import com.destack.overflow.model.Owner;

/**
 * Pass Json Url and get {@link List} of {@link CommentItem}
 * 
 * @author Deepak
 *
 */
public class CommentItemFetcher implements Fetcher<CommentItem> {

    @Override
    public List<CommentItem> objectFetcher(URL jsonURL) throws FileNotFoundException, IOException {
        CommentItem commentItem;
        Owner commentOwner;
        Owner replyToUser;
        BadgeCount cobCount;
        BadgeCount rtubCount;
        if (!JsonFetcher.urlToJson(jsonURL).has("items")) {
            errorMessages(jsonURL);
        }
        List<CommentItem> commentItemList = new ArrayList<>();
        JSONArray items = JsonFetcher.urlToJson(jsonURL).getJSONArray("items");
        JSONObject item;
        JSONObject owner;
        JSONObject replytouserJ;
        for (int i = 0; i < items.length(); i++) {
            commentItem = new CommentItem();
            commentOwner = new Owner();
            replyToUser = new Owner();
            cobCount = new BadgeCount();
            rtubCount = new BadgeCount();
            item = items.getJSONObject(i);

            if (item.has("owner")) {
                owner = item.getJSONObject("owner");
                //Populate Comment Owner Details
                commentItem.setCommentOwner(ownerJSONPopulator(commentOwner, owner));
                //Populate Badge Count to Owner Object
                commentOwner.setBadgeCount(badgeCountPopulator(cobCount, owner));
            }
            if (item.has("reply_to_user")) {
                replytouserJ = item.getJSONObject("reply_to_user");
                //Populate Reply To User Owner Details
                commentItem.setReplyToUser(ownerJSONPopulator(replyToUser, replytouserJ));
                //Populate Badge Count to Reply To User Object
                replyToUser.setBadgeCount(badgeCountPopulator(rtubCount, replytouserJ));
            }
            if (item.has("can_flag")) {
                commentItem.setCanFlag(item.getBoolean("can_flag"));
            }
            if (item.has("edited")) {
                commentItem.setEdited(item.getBoolean("edited"));
            }
            if (item.has("score")) {
                commentItem.setScore(item.getInt("score"));
            }
            if (item.has("post_type")) {
                commentItem.setPostType(item.getString("post_type"));
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
            if (item.has("body_markdown")) {
                commentItem.setBodyMarkdown(item.getString("body_markdown"));
            }
            if (item.has("link")) {
                commentItem.setLink(item.getString("link"));
            }
            if (item.has("body")) {
                commentItem.setBody(item.getString("body"));
            }
            commentItemList.add(commentItem);
            commentItem = null;
            commentOwner = null;
            replyToUser = null;
            cobCount = null;
            rtubCount = null;
        }
        items = null;
        item = null;
        owner = null;
        return commentItemList;
    }

    private BadgeCount badgeCountPopulator(BadgeCount badgeCount, JSONObject ownerJSON) {
        JSONObject badgeCountJSON;
        if (ownerJSON.has("badge_counts")) {
            badgeCountJSON = ownerJSON.getJSONObject("badge_counts");
            if (badgeCountJSON.has("bronze")) {
                badgeCount.setBronze(badgeCountJSON.getInt("bronze"));
            }
            if (badgeCountJSON.has("silver")) {
                badgeCount.setSilver(badgeCountJSON.getInt("silver"));
            }
            if (badgeCountJSON.has("gold")) {
                badgeCount.setGold(badgeCountJSON.getInt("gold"));
            }
        }
        return badgeCount;
    }

    private Owner ownerJSONPopulator(Owner ownerItem, JSONObject ownerJSONObject) {
        if (ownerJSONObject.has("reputation")) {
            ownerItem.setReputation(ownerJSONObject.getInt("reputation"));
        }
        if (ownerJSONObject.has("user_id")) {
            ownerItem.setUser_id(ownerJSONObject.getInt("user_id"));
        }
        if (ownerJSONObject.has("user_type")) {
            ownerItem.setUser_type(ownerJSONObject.getString("user_type"));
        }
        if (ownerJSONObject.has("accept_rate")) {
            ownerItem.setAccept_rate(ownerJSONObject.getInt("accept_rate"));
        }
        if (ownerJSONObject.has("profile_image")) {
            ownerItem.setProfile_image(ownerJSONObject.getString("profile_image"));
        }
        if (ownerJSONObject.has("display_name")) {
            ownerItem.setDisplay_name(ownerJSONObject.getString("display_name"));
        }
        if (ownerJSONObject.has("link")) {
            ownerItem.setLink(ownerJSONObject.getString("link"));
        }
        return ownerItem;
    }

}
