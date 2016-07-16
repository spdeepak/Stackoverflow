package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AnswerSortByTest {

    @Test
    public void test() {
        assertFalse(AnswerSortBy.contains(null));
        assertTrue(AnswerSortBy.contains(AnswerSortBy.ACTIVITY));
        assertFalse(AnswerSortBy.validate(null));
        assertTrue(AnswerSortBy.validate(AnswerSortBy.ACTIVITY));
    }

}
