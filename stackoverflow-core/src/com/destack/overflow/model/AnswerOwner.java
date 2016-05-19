package com.destack.overflow.model;

import java.net.URL;

/**
 * Fields of all the available Unauthorized Answer Owner details in Stackoverflow
 * 
 * @author Deepak
 *
 */
public class AnswerOwner {

    private String accept_range;

    private String display_name;

    private URL link;

    private URL profile_image;

    private String reputation;

    private String user_id;

    private String user_type;

    public String getAccept_range() {
        return accept_range;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public URL getLink() {
        return link;
    }

    public URL getProfile_image() {
        return profile_image;
    }

    public String getReputation() {
        return reputation;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setAccept_range(String accept_range) {
        this.accept_range = accept_range;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    public void setProfile_image(URL profile_image) {
        this.profile_image = profile_image;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

}