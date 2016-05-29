package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.destack.overflow.json.JsonFetcher;
import com.destack.overflow.model.BadgeItem;
import com.destack.overflow.model.BadgeItem.BadgeUser;
import com.destack.overflow.model.BadgeItem.BadgeUser.BadgeCount;

public class BadgeItemFetcher implements Fetcher<BadgeItem> {

    @Override
    public List<BadgeItem> objectFetcher(URL jsonURL) throws FileNotFoundException, IOException {
        BadgeItem badgeItem;
        BadgeUser badgeUser;
        BadgeCount badgeCount;
        List<BadgeItem> badgeItems = new ArrayList();
        if (!JsonFetcher.getJson(jsonURL).has("items")) {
            errorMessages(jsonURL);
        }
        JSONArray items = JsonFetcher.getJson(jsonURL).getJSONArray("items");
        JSONObject item;
        JSONObject user;
        JSONObject count;
        for (int i = 0; i < items.length(); i++) {
            badgeItem = new BadgeItem();
            badgeUser = badgeItem.new BadgeUser();
            badgeCount = badgeUser.new BadgeCount();
            item = items.getJSONObject(i);
            badgeItem.setBadge_type(item.has("badge_type") ? item.getString("badge_type") : null);
            badgeItem.setAward_count(item.has("award_count") ? item.getInt("award_count") : null);
            badgeItem.setRank(item.has("rank") ? item.getString("rank") : null);
            badgeItem.setBadge_id(item.has("badge_id") ? item.getInt("badge_id") : null);
            badgeItem.setLink(item.has("link") ? item.getString("link") : null);
            badgeItem.setDescription(item.has("description") ? item.getString("description") : null);
            badgeItem.setName(item.has("name") ? item.getString("name") : null);
            if (item.has("user")) {
                user = item.getJSONObject("user");
                badgeUser.setReputation(user.has("reputation") ? user.getInt("reputation") : null);
                badgeUser.setUser_id(user.has("user_id") ? user.getInt("user_id") : null);
                badgeUser.setUser_type(user.has("user_type") ? user.getString("user_type") : null);
                badgeUser.setProfile_image(user.has("profile_image") ? user.getString("profile_image") : null);
                badgeUser.setDisplay_name(user.has("display_name") ? user.getString("display_name") : null);
                badgeUser.setLink(user.has("link") ? user.getString("link") : null);
                badgeItem.setBadgeUser(badgeUser);
                if (user.has("badge_counts")) {
                    count = user.getJSONObject("badge_counts");
                    badgeCount.setBronze(count.has("bronze") ? count.getInt("bronze") : null);
                    badgeCount.setSilver(count.has("silver") ? count.getInt("silver") : null);
                    badgeCount.setGold(count.has("gold") ? count.getInt("gold") : null);
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
