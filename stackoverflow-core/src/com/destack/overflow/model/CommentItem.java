package com.destack.overflow.model;

/**
 * @author Deepak
 *
 */
public class CommentItem {

    private boolean edited;

    private Integer score;

    private Integer creation_date;

    private Integer post_id;

    private Integer comment_id;

    public boolean isEdited() {
        return edited;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getCreation_date() {
        return creation_date;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setCreation_date(Integer creation_date) {
        this.creation_date = creation_date;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public class CommentOwner {

        private Integer reputation;

        private Integer user_id;

        private String user_type;

        private String display_name;

        private String link;

        private String profile_image;

        private Integer accept_rate;

        public Integer getReputation() {
            return reputation;
        }

        public Integer getUser_id() {
            return user_id;
        }

        public String getUser_type() {
            return user_type;
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

        public Integer getAccept_rate() {
            return accept_rate;
        }

        public void setAccept_rate(Integer accept_range) {
            accept_rate = accept_range;
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

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }
    }

    /**
     * This class holds information about the User to whom the comment is commented to
     * 
     * @author Deepak
     *
     */
    public class ReplyToUser {

        private Integer reputation;

        private Integer user_id;

        private String user_type;

        private String display_name;

        private String link;

        private String profile_image;

        private Integer accept_rate;

        public Integer getReputation() {
            return reputation;
        }

        public Integer getUser_id() {
            return user_id;
        }

        public String getUser_type() {
            return user_type;
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

        public Integer getAccept_rate() {
            return accept_rate;
        }

        public void setAccept_rate(Integer accept_rate) {
            this.accept_rate = accept_rate;
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

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }
    }
}
