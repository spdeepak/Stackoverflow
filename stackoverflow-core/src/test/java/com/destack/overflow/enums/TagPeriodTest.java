package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class TagPeriodTest {

    @Test
    public void test() {
        assertFalse(TagPeriod.contains(null));
        assertTrue(TagPeriod.contains(TagPeriod.ALL_TIME));
        assertFalse(TagPeriod.validate(null));
        assertTrue(TagPeriod.validate(TagPeriod.ALL_TIME));
    }

}
