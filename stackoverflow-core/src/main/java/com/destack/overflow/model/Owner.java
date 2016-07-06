package com.destack.overflow.model;

/**
 * @author Deepak
 *
 */
public class Owner {

    private Integer accept_rate;

    private String display_name;

    private String link;

    private String profile_image;

    private Integer reputation;

    private Integer user_id;

    private String user_type;

    private BadgeCount badgeCount;

    public Integer getAccept_rate() {
        return accept_rate;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getLink() {
        return link;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public Integer getReputation() {
        return reputation;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public BadgeCount getBadgeCount() {
        return badgeCount;
    }

    public void setBadgeCount(BadgeCount badgeCount) {
        this.badgeCount = badgeCount;
    }

    public void setAccept_rate(Integer accept_rate) {
        this.accept_rate = accept_rate;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
