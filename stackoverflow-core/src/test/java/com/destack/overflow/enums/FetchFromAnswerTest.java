package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class FetchFromAnswerTest {

    @Test
    public void test() {
        assertFalse(FetchFromAnswer.isContains(null));
        assertTrue(FetchFromAnswer.isContains(FetchFromAnswer.ID_ANSWER));
        assertFalse(FetchFromAnswer.isValid(null));
        assertTrue(FetchFromAnswer.isValid(FetchFromAnswer.ID_ANSWER));
    }

}
