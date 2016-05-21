package com.destack.overflow.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import org.json.JSONObject;

/**
 * 
 * Fetch Json From URL
 * 
 * @author Deepak
 *
 */
public class JsonFetcher {

    public JSONObject getJson(String urlString) throws MalformedURLException {
        return urlToJson(new URL(urlString));
    }

    public JSONObject getJson(URL url) {
        return urlToJson(url);
    }

    private JSONObject urlToJson(URL urlString) {
        StringBuilder sb = null;
        try {
            URL url = urlString;
            URLConnection urlCon = url.openConnection();
            BufferedReader in = null;
            if (urlCon.getHeaderField("Content-Encoding") != null
                    && urlCon.getHeaderField("Content-Encoding").equals("gzip")) {
                in = new BufferedReader(new InputStreamReader(new GZIPInputStream(urlCon.getInputStream())));
            } else {
                in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            }
            String inputLine;
            sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JSONObject(sb.toString());
    }
}
