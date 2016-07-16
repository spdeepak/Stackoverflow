package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class OrderTest {

    @Test
    public void test() {
        assertFalse(Order.contains(null));
        assertTrue(Order.contains(Order.ASC));
        assertFalse(Order.validate(null));
        assertTrue(Order.validate(Order.ASC));
    }

}
