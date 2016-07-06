package com.destack.overflow.fetcher;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.model.CommentItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class CommentItemFetcherTest {

    @Resource
    CommentItemFetcher commentItemFetcher;

    @Test
    public void test() throws FileNotFoundException, IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/JSONs/commentexample.json");
        List<CommentItem> commentItems = commentItemFetcher.objectFetcher(file.toURI().toURL());
        assertEquals(10, commentItems.size());
        assertEquals(1096, commentItems.get(1).getCommentOwner().getReputation().intValue());
        assertEquals(3199310, commentItems.get(1).getCommentOwner().getUser_id().intValue());
        assertEquals("registered", commentItems.get(1).getCommentOwner().getUser_type());
        assertEquals(67, commentItems.get(1).getCommentOwner().getAccept_rate().intValue());
        assertEquals("https://www.gravatar.com/avatar/61329390532bf1c207f86e30082102bb?s=128&d=identicon&r=PG",
                commentItems.get(1).getCommentOwner().getProfile_image());
        assertEquals("Patrick Motard", commentItems.get(1).getCommentOwner().getDisplay_name());
        assertEquals("http://stackoverflow.com/users/3199310/patrick-motard",
                commentItems.get(1).getCommentOwner().getLink());
        assertEquals(452, commentItems.get(1).getReplyToUser().getReputation().intValue());
        assertEquals(1811818, commentItems.get(1).getReplyToUser().getUser_id().intValue());
        assertEquals("registered", commentItems.get(1).getReplyToUser().getUser_type());
        assertEquals(35, commentItems.get(1).getReplyToUser().getAccept_rate().intValue());
        assertEquals("https://www.gravatar.com/avatar/8e6b71c97c2862bc380e49629926dc4a?s=128&d=identicon&r=PG",
                commentItems.get(1).getReplyToUser().getProfile_image());
        assertEquals("Willem", commentItems.get(1).getReplyToUser().getDisplay_name());
        assertEquals("http://stackoverflow.com/users/1811818/willem", commentItems.get(1).getReplyToUser().getLink());
        assertEquals(false, commentItems.get(1).isEdited());
        assertEquals(0, commentItems.get(1).getScore().intValue());
        assertEquals(1463788766, commentItems.get(1).getCreation_date().intValue());
        assertEquals(37357387, commentItems.get(1).getPost_id().intValue());
        assertEquals(62229925, commentItems.get(1).getComment_id().intValue());

    }

}
