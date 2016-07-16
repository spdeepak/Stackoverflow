package com.destack.overflow.enums;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CommentSortByTest {

    @Test
    public void test() {
        assertFalse(CommentSortBy.contains(null));
        assertTrue(CommentSortBy.contains(CommentSortBy.CREATION));
        assertFalse(CommentSortBy.validate(null));
        assertTrue(CommentSortBy.validate(CommentSortBy.CREATION));
    }

}
