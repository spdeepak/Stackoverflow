package com.destack.overflow.model;

import com.destack.overflow.enums.FetchFromAnswer;

/**
 * Fields of all the available Unauthorized complete Answer details in Stackoverflow
 * 
 * @author Deepak
 *
 */
public class AnswerItem {

    private Integer answer_id;

    private Owner answerOwner;

    private Integer creation_date;

    /**
     * For {@link FetchFromAnswer}.ID_ANSWER
     */
    private long community_owned_date;

    private boolean is_accepted;

    private Integer last_activity_date;

    private Integer last_edit_date;

    private Integer question_id;

    private Integer score;

    public Integer getAnswer_id() {
        return answer_id;
    }

    public Owner getAnswerOwner() {
        return answerOwner;
    }

    public Integer getCreation_date() {
        return creation_date;
    }

    public Integer getLast_activity_date() {
        return last_activity_date;
    }

    public Integer getLast_edit_date() {
        return last_edit_date;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public Integer getScore() {
        return score;
    }

    /**
     * For {@link FetchFromAnswer}.ID_ANSWER
     * 
     * @return
     */
    public long getCommunity_owned_date() {
        return community_owned_date;
    }

    public void setCommunity_owned_date(long community_owned_date) {
        this.community_owned_date = community_owned_date;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public void setAnswerOwner(Owner answerOwner) {
        this.answerOwner = answerOwner;
    }

    public void setCreation_date(Integer creation_date) {
        this.creation_date = creation_date;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public void setLast_activity_date(Integer last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public void setLast_edit_date(Integer last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
