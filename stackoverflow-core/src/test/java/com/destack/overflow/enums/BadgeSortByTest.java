package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class BadgeSortByTest {

    @Test
    public void test() {
        assertFalse(BadgeSortBy.isContains(null));
        assertTrue(BadgeSortBy.isContains(BadgeSortBy.NAME));
        assertFalse(BadgeSortBy.isValid(null));
        assertTrue(BadgeSortBy.isValid(BadgeSortBy.NAME));
    }

}
