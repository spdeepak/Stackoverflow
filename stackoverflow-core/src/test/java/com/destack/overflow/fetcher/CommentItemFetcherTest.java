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
        assertEquals(30, commentItems.size());
        //Owner's BadgeCount
        assertEquals(2, commentItems.get(0).getCommentOwner().getBadgeCount().getBronze().intValue());
        assertEquals(0, commentItems.get(0).getCommentOwner().getBadgeCount().getSilver().intValue());
        assertEquals(0, commentItems.get(0).getCommentOwner().getBadgeCount().getGold().intValue());
        //Owner's Reputation
        assertEquals(1, commentItems.get(0).getCommentOwner().getReputation().intValue());
        assertEquals(6513420, commentItems.get(0).getCommentOwner().getUser_id().intValue());
        assertEquals("registered", commentItems.get(0).getCommentOwner().getUser_type());
        assertEquals("https://www.gravatar.com/avatar/9e0d60b0e6b1f68f71de29000c2decaa?s=128&d=identicon&r=PG&f=1",
                commentItems.get(0).getCommentOwner().getProfile_image());
        assertEquals("Jorma Jarppinen", commentItems.get(0).getCommentOwner().getDisplay_name());
        assertEquals("http://stackoverflow.com/users/6513420/jorma-jarppinen",
                commentItems.get(0).getCommentOwner().getLink());
        //Reply To User's BadgeCount
        assertEquals(13, commentItems.get(0).getReplyToUser().getBadgeCount().getBronze().intValue());
        assertEquals(3, commentItems.get(0).getReplyToUser().getBadgeCount().getSilver().intValue());
        assertEquals(0, commentItems.get(0).getReplyToUser().getBadgeCount().getGold().intValue());
        //Reply To User's Reputation
        assertEquals(586, commentItems.get(0).getReplyToUser().getReputation().intValue());
        assertEquals(3379440, commentItems.get(0).getReplyToUser().getUser_id().intValue());
        assertEquals("registered", commentItems.get(0).getReplyToUser().getUser_type());
        assertEquals("https://i.stack.imgur.com/Vz9uG.jpg?s=128&g=1",
                commentItems.get(0).getReplyToUser().getProfile_image());
        assertEquals("Jonathon Ogden", commentItems.get(0).getReplyToUser().getDisplay_name());
        assertEquals("http://stackoverflow.com/users/3379440/jonathon-ogden",
                commentItems.get(0).getReplyToUser().getLink());
        //Comment Details
        assertEquals(false, commentItems.get(0).isCanFlag());
        assertEquals(false, commentItems.get(0).isEdited());
        assertEquals(0, commentItems.get(0).getScore().intValue());
        assertEquals("question", commentItems.get(0).getPostType());
        assertEquals(1468736602, commentItems.get(0).getCreation_date().intValue());
        assertEquals(38416472, commentItems.get(0).getPost_id().intValue());
        assertEquals(64243742, commentItems.get(0).getComment_id().intValue());
        assertEquals(
                "@JonathonOgden I just want the solution to the problem, if someone has the solution. You have no use for my attempts.",
                commentItems.get(0).getBodyMarkdown());
        assertEquals(
                "http://stackoverflow.com/questions/38416472/pygame-check-collision-with-hitboxes-named-object-rect#comment64243742_38416472",
                commentItems.get(0).getLink());
        assertEquals(
                "@JonathonOgden I just want the solution to the problem, if someone has the solution. You have no use for my attempts.",
                commentItems.get(0).getBody());
    }

}
