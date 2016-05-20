package com.destack.overflow.fetcher;

import org.json.JSONObject;

import com.destack.overflow.initializers.AnswerInitializer;

public interface Fetcher {

    JSONObject jsonFetcher(AnswerInitializer answerInitializer);
}
