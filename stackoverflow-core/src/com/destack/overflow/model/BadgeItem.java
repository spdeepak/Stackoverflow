package com.destack.overflow.model;

/**
 * Get all badges on the site, in alphabetical order.
 * 
 * @author Deepak
 *
 */
public class BadgeItem extends ItemExtras {

    private String badge_type;

    private Integer award_count;

    private String rank;

    private Integer badge_id;

    private String link;

    private String description;

    private String name;

    private BadgeUser badgeUser;

    public String getBadge_type() {
        return badge_type;
    }

    public Integer getAward_count() {
        return award_count;
    }

    public String getRank() {
        return rank;
    }

    public Integer getBadge_id() {
        return badge_id;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BadgeUser getBadgeUser() {
        return badgeUser;
    }

    public void setBadgeUser(BadgeUser badgeUser) {
        this.badgeUser = badgeUser;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBadge_type(String badge_type) {
        this.badge_type = badge_type;
    }

    public void setAward_count(Integer award_count) {
        this.award_count = award_count;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setBadge_id(Integer badge_id) {
        this.badge_id = badge_id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class BadgeUser {

        private Integer reputation;

        private Integer user_id;

        private String user_type;

        private String profile_image;

        private String display_name;

        private String link;

        private BadgeCount badgeCount;

        public Integer getReputation() {
            return reputation;
        }

        public Integer getUser_id() {
            return user_id;
        }

        public String getUser_type() {
            return user_type;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public String getLink() {
            return link;
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

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public BadgeCount getBadgeCount() {
            return badgeCount;
        }

        public void setBadgeCount(BadgeCount badgeCount) {
            this.badgeCount = badgeCount;
        }

    }
}
