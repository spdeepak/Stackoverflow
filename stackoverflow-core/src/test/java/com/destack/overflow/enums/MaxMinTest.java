package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class MaxMinTest {

    @Test
    public void test() {
        assertFalse(MaxMin.contains(null));
        assertTrue(MaxMin.contains(MaxMin.BRONZE));
        assertFalse(MaxMin.validate(null));
        assertTrue(MaxMin.validate(MaxMin.BRONZE));
    }

}
