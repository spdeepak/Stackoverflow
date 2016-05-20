package com.destack.overflow.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONObject;

/**
 * @author Deepak
 *
 */
public class JsonUtil {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject urlToJson(URL url) {
        InputStream is = null;
        JSONObject json = null;
        String jsonText;
        try {
            is = url.openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            jsonText = readAll(rd);
            json = new JSONObject(jsonText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            jsonText = null;
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }
}
