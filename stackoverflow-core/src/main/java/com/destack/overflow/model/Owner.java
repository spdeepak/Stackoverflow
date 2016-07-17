package com.destack.overflow.model;

/**
 * 
 * Entity class which holds information about a User<br/>
 * <b>1.</b> Used to hold information about Answer Owner in {@link AnswerItem}<br/>
 * <b>2.</b> Used to hold information about Comment Owner and ReplyToUser in {@link CommentItem}
 * 
 * @author Deepak
 *
 */
public class Owner {

    private BadgeCount badgeCount;

    private Integer accept_rate;

    private String display_name;

    private String link;

    private String profile_image;

    private Integer reputation;

    private Integer user_id;

    private String user_type;

    public BadgeCount getBadgeCount() {
        return badgeCount;
    }

    public void setBadgeCount(BadgeCount badgeCount) {
        this.badgeCount = badgeCount;
    }

    public Integer getAccept_rate() {
        return accept_rate;
    }

    public void setAccept_rate(Integer accept_rate) {
        this.accept_rate = accept_rate;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

}
