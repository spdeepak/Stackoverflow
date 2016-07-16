package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class FetchFromAnswerTest {

    @Test
    public void test() {
        assertFalse(FetchFromAnswer.contains(null));
        assertTrue(FetchFromAnswer.contains(FetchFromAnswer.ID_ANSWER));
        assertFalse(FetchFromAnswer.validate(null));
        assertTrue(FetchFromAnswer.validate(FetchFromAnswer.ID_ANSWER));
    }

}
