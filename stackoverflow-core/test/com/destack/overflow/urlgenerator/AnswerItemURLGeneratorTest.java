package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.AnswerInitializer;

public class AnswerItemURLGeneratorTest {

    AnswerItemURLGenerator af = new AnswerItemURLGenerator();

    AnswerInitializer ai;

    @Test
    public void answerURLGeneratorTest() throws Exception {
        ai = new AnswerInitializer(1, 10, 20140101, 20143101, Order.DESC, AnswerSortBy.ACTIVITY, 20140101, 20143101);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=desc&sort=activity&min=1388534400&max=1391126400&site=stackoverflow",
                af.urlGenerator(ai).toString());

        ai = new AnswerInitializer(1, 10, 0, 0, null, null, 10, 100);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&order=desc&sort=activity&site=stackoverflow",
                af.urlGenerator(ai).toString());

        ai = new AnswerInitializer(1, 10, 20140101, 20143101, Order.ASC, AnswerSortBy.VOTES, 0, 0);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=asc&sort=votes&site=stackoverflow",
                af.urlGenerator(ai).toString());
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        String jsonLocation = System.getProperty("user.dir") + "/resources/answerexample.json";
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(jsonLocation));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray items = (JSONArray) jsonObject.get("items");
        for (int i = 0; i < items.size(); i++) {
            JSONObject item = (JSONObject) items.get(i);
            JSONObject owner = (JSONObject) item.get("owner");
            System.out.println(owner.get("reputation"));
            System.out.println(owner.get("user_id"));
            System.out.println(owner.get("user_type"));
            System.out.println(owner.get("accept_rate"));
            System.out.println(owner.get("profile_image"));
            System.out.println(owner.get("display_name"));
            System.out.println(owner.get("link"));
            System.out.println(item.get("is_accepted"));
            System.out.println(item.get("score"));
            System.out.println(item.get("last_activity_date"));
            System.out.println(item.get("creation_date"));
            System.out.println(item.get("answer_id"));
            System.out.println(item.get("question_id"));
        }

    }

}
