package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.destack.overflow.json.JsonFetcher;
import com.destack.overflow.model.PrivilegeItem;

public class PrivilegeItemFetcher {

    private static final String URL = "https://api.stackexchange.com/2.2/privileges?site=stackoverflow";

    public List<PrivilegeItem> objectFetcher() throws FileNotFoundException, IOException {
        PrivilegeItem pItem;
        List<PrivilegeItem> pItems = new ArrayList();
        JSONArray items = JsonFetcher.urlToJson(URL).getJSONArray("items");
        JSONObject item;
        for (int i = 0; i < items.length(); i++) {
            item = items.getJSONObject(i);
            pItem = new PrivilegeItem(item.getInt("reputation"), item.getString("description"),
                    item.getString("short_description"));
            pItems.add(pItem);
            pItem = null;
            item = null;
        }
        return pItems;
    }

}
