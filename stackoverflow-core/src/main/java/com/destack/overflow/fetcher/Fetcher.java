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
        itemExtra.setHas_more(JsonFetcher.urlToJson(jsonURL).has("has_more")
                ? JsonFetcher.urlToJson(jsonURL).getBoolean("has_more") : null);
        itemExtra.setQuota_max(JsonFetcher.urlToJson(jsonURL).has("quota_max")
                ? JsonFetcher.urlToJson(jsonURL).getInt("quota_max") : null);
        itemExtra.setQuota_remaining(JsonFetcher.urlToJson(jsonURL).has("quota_remaining")
                ? JsonFetcher.urlToJson(jsonURL).getInt("quota_remaining") : null);
        itemExtra
        .setPage(JsonFetcher.urlToJson(jsonURL).has("page") ? JsonFetcher.urlToJson(jsonURL).getInt("page") : null);
        itemExtra.setPage_size(JsonFetcher.urlToJson(jsonURL).has("page_size")
                ? JsonFetcher.urlToJson(jsonURL).getInt("page_size") : null);
        itemExtra.setTotal(
                JsonFetcher.urlToJson(jsonURL).has("total") ? JsonFetcher.urlToJson(jsonURL).getInt("total") : null);
        itemExtra.setType(
                JsonFetcher.urlToJson(jsonURL).has("type") ? JsonFetcher.urlToJson(jsonURL).getString("type") : null);
        return itemExtra;
    }

    public default void errorMessages(URL jsonURL) {
        throw new IllegalArgumentException("Error_id:" + JsonFetcher.urlToJson(jsonURL).getDouble("error_id")
                + ".\nError Message " + JsonFetcher.urlToJson(jsonURL).getString("error_message") + ".\nError Name: "
                + JsonFetcher.urlToJson(jsonURL).getString("error_name"));
    }

}
