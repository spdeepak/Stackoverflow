package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.destack.overflow.json.JsonFetcher;
import com.destack.overflow.model.Owner;
import com.destack.overflow.model.TagItem;
import com.destack.overflow.util.DateUtils;

public class TagItemFetcher implements Fetcher<TagItem> {

    @Override
    public List<TagItem> objectFetcher(URL jsonURL) throws FileNotFoundException, IOException {
        TagItem tagItem;
        Owner owner;
        if (!JsonFetcher.urlToJson(jsonURL).has("items")) {
            errorMessages(jsonURL);
        }
        List<TagItem> tagItemList = new ArrayList<>();
        JSONArray items = JsonFetcher.urlToJson(jsonURL).getJSONArray("items");
        JSONObject item;
        JSONArray synonyms;
        for (int i = 0; i < items.length(); i++) {
            tagItem = new TagItem();
            item = items.getJSONObject(i);
            String[] synons;
            if (item.has("synonyms")) {
                synonyms = item.getJSONArray("synonyms");
                synons = new String[synonyms.length()];
                for (int j = 0; j < synonyms.length(); j++) {
                    synons[j] = synonyms.getString(j);
                }
                tagItem.setSynonyms(synons);
                synons = null;
            }
            if (item.has("last_activity_date")) {
                tagItem.setLastActivityDate(item.getLong("last_activity_date"));
            }
            if (item.has("has_synonyms")) {
                tagItem.setHasSynonyms(item.getBoolean("has_synonyms"));
            }
            if (item.has("is_moderator_only")) {
                tagItem.setModeratorOnly(item.getBoolean("is_moderator_only"));
            }
            if (item.has("is_required")) {
                tagItem.setRequired(item.getBoolean("is_required"));
            }
            if (item.has("count")) {
                tagItem.setCount(item.getInt("count"));
            }
            if (item.has("name")) {
                tagItem.setName(item.getString("name"));
            }
            synonymsTagFetcher(tagItem, item);
            tagItemList.add(tagItem);
            tagItem = null;
            item = null;
            synonyms = null;
        }
        return tagItemList;
    }

    private void synonymsTagFetcher(TagItem tagItem, JSONObject item) {
        if (item.has("creation_date")) {
            tagItem.setCreationDate(DateUtils.milliSecondsDateToProperDate(item.getLong("creation_date")));
        }
        if (item.has("last_applied_date")) {
            tagItem.setLastAppliedDate(DateUtils.milliSecondsDateToProperDate(item.getLong("last_applied_date")));
        }
        if (item.has("applied_count")) {
            tagItem.setAppliedCount(item.getLong("applied_count"));
        }
        if (item.has("to_tag")) {
            tagItem.setToTag(item.getString("to_tag"));
        }
        if (item.has("from_tag")) {
            tagItem.setFromTag(item.getString("from_tag"));
        }
    }

}
