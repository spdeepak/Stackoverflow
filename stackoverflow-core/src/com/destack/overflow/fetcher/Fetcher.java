package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.destack.overflow.json.JsonFetcher;
import com.destack.overflow.model.ItemExtras;

/**
 * @author Deepak
 *
 */
public interface Fetcher<T> {

    /**
     * Pass Json URL and get required {@link List} of Items
     * 
     * @param jsonURL
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    List<T> objectFetcher(URL jsonURL) throws FileNotFoundException, IOException;

    public default ItemExtras itemExtras(URL jsonURL) {
        ItemExtras itemExtra = new ItemExtras();
        itemExtra.setHas_more(JsonFetcher.getJson(jsonURL).has("has_more")
                ? JsonFetcher.getJson(jsonURL).getBoolean("has_more") : null);
        itemExtra.setQuota_max(JsonFetcher.getJson(jsonURL).has("quota_max")
                ? JsonFetcher.getJson(jsonURL).getInt("quota_max") : null);
        itemExtra.setQuota_remaining(JsonFetcher.getJson(jsonURL).has("quota_remaining")
                ? JsonFetcher.getJson(jsonURL).getInt("quota_remaining") : null);
        itemExtra
        .setPage(JsonFetcher.getJson(jsonURL).has("page") ? JsonFetcher.getJson(jsonURL).getInt("page") : null);
        itemExtra.setPage_size(JsonFetcher.getJson(jsonURL).has("page_size")
                ? JsonFetcher.getJson(jsonURL).getInt("page_size") : null);
        itemExtra.setTotal(
                JsonFetcher.getJson(jsonURL).has("total") ? JsonFetcher.getJson(jsonURL).getInt("total") : null);
        itemExtra.setType(
                JsonFetcher.getJson(jsonURL).has("type") ? JsonFetcher.getJson(jsonURL).getString("type") : null);
        return itemExtra;
    }

    public default void errorMessages(URL jsonURL) {
        throw new IllegalArgumentException("Error_id:" + JsonFetcher.getJson(jsonURL).getDouble("error_id")
                + ".\nError Message " + JsonFetcher.getJson(jsonURL).getString("error_message") + ".\nError Name: "
                + JsonFetcher.getJson(jsonURL).getString("error_name"));
    }

}
