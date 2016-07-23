package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnswerSortByTest {

    @Test
    public void test() {
        assertFalse(AnswerSortBy.isContains(null));
        assertTrue(AnswerSortBy.isContains(AnswerSortBy.ACTIVITY));
        assertTrue(AnswerSortBy.isContains(AnswerSortBy.CREATION));
        assertTrue(AnswerSortBy.isContains(AnswerSortBy.VOTES));
        assertFalse(AnswerSortBy.isValid(null));
        assertTrue(AnswerSortBy.isValid(AnswerSortBy.ACTIVITY));
        assertTrue(AnswerSortBy.isValid(AnswerSortBy.CREATION));
        assertTrue(AnswerSortBy.isValid(AnswerSortBy.VOTES));
    }

}
