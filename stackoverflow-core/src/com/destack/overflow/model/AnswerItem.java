package com.destack.overflow.model;

import java.net.URL;

/**
 * Fields of all the available Unauthorized complete Answer details in Stackoverflow
 * 
 * @author Deepak
 *
 */
public class AnswerItem {

    /**
     * Fields of all the available Unauthorized complete Answer Owner details in Stackoverflow
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

    private long answer_id;

    private AnswerOwner answerOwner;

    private long creation_date;

    private boolean is_accepted;

    private long last_activity_date;

    private long last_edit_date;

    private long question_id;

    private long score;

    public long getAnswer_id() {
        return answer_id;
    }

    public AnswerOwner getAnswerOwner() {
        return answerOwner;
    }

    public long getCreation_date() {
        return creation_date;
    }

    public long getLast_activity_date() {
        return last_activity_date;
    }

    public long getLast_edit_date() {
        return last_edit_date;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public long getScore() {
        return score;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setAnswer_id(long answer_id) {
        this.answer_id = answer_id;
    }

    public void setAnswerOwner(AnswerOwner answerOwner) {
        this.answerOwner = answerOwner;
    }

    public void setCreation_date(long creation_date) {
        this.creation_date = creation_date;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public void setLast_activity_date(long last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public void setLast_edit_date(long last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public void setScore(long score) {
        this.score = score;
    }

}
