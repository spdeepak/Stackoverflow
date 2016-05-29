package com.destack.overflow.fetcher;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.model.PrivilegeItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class PrivilegeItemFetcherTest {

    @Resource
    private PrivilegeItemFetcher privilegeItemFetcher;

    @Test
    public void test() throws FileNotFoundException, IOException {
        List<PrivilegeItem> pItems = privilegeItemFetcher.objectFetcher();

        assertTrue(pItems.size() == 29);

        assertTrue(pItems.get(0).getReputation().equals(1));
        assertTrue(pItems.get(0).getDescription().equals("Ask a question or contribute an answer"));
        assertTrue(pItems.get(0).getShort_description().equals("create posts"));

        assertTrue(pItems.get(1).getReputation().equals(5));
        assertTrue(pItems.get(1).getDescription().equals("Discuss the site itself,  bugs, feedback, and governance"));
        assertTrue(pItems.get(1).getShort_description().equals("participate in meta"));

        assertTrue(pItems.get(2).getReputation().equals(10));
        assertTrue(pItems.get(2).getDescription().equals("Post more links, answer protected questions"));
        assertTrue(pItems.get(2).getShort_description().equals("answer protected questions"));

        assertTrue(pItems.get(9).getReputation().equals(50));
        assertTrue(pItems.get(9).getDescription().equals("Comment on proposed changes and topic requests"));
        assertTrue(pItems.get(9).getShort_description().equals("documentation comments"));

        assertTrue(pItems.get(19).getReputation().equals(1000));
        assertTrue(pItems.get(19).getDescription().equals("Create chat rooms where only specific users may talk"));
        assertTrue(pItems.get(19).getShort_description().equals("create gallery chat rooms"));

        assertTrue(pItems.get(28).getReputation().equals(25000));
        assertTrue(pItems.get(28).getDescription().equals("Access to internal and Google site analytics"));
        assertTrue(pItems.get(28).getShort_description().equals("access to site analytics"));
    }

}
