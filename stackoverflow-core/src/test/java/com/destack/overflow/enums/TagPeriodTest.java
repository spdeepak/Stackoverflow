package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TagPeriodTest {

    @Test
    public void test() {
        assertFalse(TagPeriod.isContains(null));
        assertTrue(TagPeriod.isContains(TagPeriod.ALL_TIME));
        assertFalse(TagPeriod.isValid(null));
        assertTrue(TagPeriod.isValid(TagPeriod.ALL_TIME));
    }

}
