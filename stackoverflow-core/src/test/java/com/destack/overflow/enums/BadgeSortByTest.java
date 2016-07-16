package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class BadgeSortByTest {

    @Test
    public void test() {
        assertFalse(BadgeSortBy.contains(null));
        assertTrue(BadgeSortBy.contains(BadgeSortBy.NAME));
        assertFalse(BadgeSortBy.validate(null));
        assertTrue(BadgeSortBy.validate(BadgeSortBy.NAME));
    }

}
