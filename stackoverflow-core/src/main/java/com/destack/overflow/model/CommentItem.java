package com.destack.overflow.model;

/**
 * Fields of all the available Unauthorized complete Answer details in Stackoverflow
 * 
 * @author Deepak
 *
 */
public class CommentItem {

    private Owner commentOwner;

    private Owner replyToUser;

    private boolean canFlag;

    private boolean edited;

    private Integer score;

    private String postType;

    private Integer creation_date;

    private Integer post_id;

    private Integer comment_id;

    private String bodyMarkdown;

    private String link;

    private String body;

    public Owner getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(Owner commentOwner) {
        this.commentOwner = commentOwner;
    }

    public Owner getReplyToUser() {
        return replyToUser;
    }

    public void setReplyToUser(Owner replyToUser) {
        this.replyToUser = replyToUser;
    }

    public boolean isCanFlag() {
        return canFlag;
    }

    public void setCanFlag(boolean canFlag) {
        this.canFlag = canFlag;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public Integer getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Integer creation_date) {
        this.creation_date = creation_date;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getBodyMarkdown() {
        return bodyMarkdown;
    }

    public void setBodyMarkdown(String bodyMarkdown) {
        this.bodyMarkdown = bodyMarkdown;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
