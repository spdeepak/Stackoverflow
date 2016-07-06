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
import com.destack.overflow.model.BadgeItem;
import com.destack.overflow.model.BadgeItem.BadgeUser;

public class BadgeItemFetcher implements Fetcher<BadgeItem> {

    @Override
    public List<BadgeItem> objectFetcher(URL jsonURL) throws FileNotFoundException, IOException {
        BadgeItem badgeItem;
        BadgeUser badgeUser;
        BadgeCount badgeCount;
        List<BadgeItem> badgeItems = new ArrayList();
        if (!JsonFetcher.urlToJson(jsonURL).has("items")) {
            errorMessages(jsonURL);
        }
        JSONArray items = JsonFetcher.urlToJson(jsonURL).getJSONArray("items");
        JSONObject item;
        JSONObject user;
        JSONObject count;
        for (int i = 0; i < items.length(); i++) {
            badgeItem = new BadgeItem();
            badgeUser = badgeItem.new BadgeUser();
            badgeCount = new BadgeCount();
            item = items.getJSONObject(i);
            if (item.has("badge_type")) {
                badgeItem.setBadge_type(item.getString("badge_type"));
            }
            if (item.has("award_count")) {
                badgeItem.setAward_count(item.getInt("award_count"));
            }
            if (item.has("rank")) {
                badgeItem.setRank(item.getString("rank"));
            }
            if (item.has("badge_id")) {
                badgeItem.setBadge_id(item.getInt("badge_id"));
            }
            if (item.has("link")) {
                badgeItem.setLink(item.getString("link"));
            }
            if (item.has("description")) {
                badgeItem.setDescription(item.getString("description"));
            }
            if (item.has("name")) {
                badgeItem.setName(item.getString("name"));
            }
            if (item.has("user")) {
                user = item.getJSONObject("user");
                if (user.has("reputation")) {
                    badgeUser.setReputation(user.getInt("reputation"));
                }
                if (user.has("user_id")) {
                    badgeUser.setUser_id(user.getInt("user_id"));
                }
                if (user.has("user_type")) {
                    badgeUser.setUser_type(user.getString("user_type"));
                }
                if (user.has("profile_image")) {
                    badgeUser.setProfile_image(user.getString("profile_image"));
                }
                if (user.has("display_name")) {
                    badgeUser.setDisplay_name(user.getString("display_name"));
                }
                if (user.has("link")) {
                    badgeUser.setLink(user.getString("link"));
                }
                badgeItem.setBadgeUser(badgeUser);
                if (user.has("badge_counts")) {
                    count = user.getJSONObject("badge_counts");
                    if (count.has("bronze")) {
                        badgeCount.setBronze(count.getInt("bronze"));
                    }
                    if (count.has("silver")) {
                        badgeCount.setSilver(count.getInt("silver"));
                    }
                    if (count.has("gold")) {
                        badgeCount.setGold(count.getInt("gold"));
                    }
                    badgeUser.setBadgeCount(badgeCount);
                }
            }
            badgeItems.add(badgeItem);
            badgeItem = null;
            badgeUser = null;
            badgeCount = null;
        }
        items = null;
        item = null;
        user = null;
        count = null;
        return badgeItems;
    }

}
