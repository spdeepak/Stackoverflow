package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnswerSortByTest {

    @Test
    public void test() {
        assertFalse(AnswerSortBy.isContains(null));
        assertTrue(AnswerSortBy.isContains(AnswerSortBy.ACTIVITY));
        assertFalse(AnswerSortBy.isValid(null));
        assertTrue(AnswerSortBy.isValid(AnswerSortBy.ACTIVITY));
    }

}
