package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class MaxMinTest {

    @Test
    public void test() {
        assertFalse(MaxMin.isContains(null));
        assertTrue(MaxMin.isContains(MaxMin.BRONZE));
        assertFalse(MaxMin.isValid(null));
        assertTrue(MaxMin.isValid(MaxMin.BRONZE));
    }

}
