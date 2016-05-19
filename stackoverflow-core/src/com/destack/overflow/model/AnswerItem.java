package com.destack.overflow.model;

import java.util.Date;

/**
 * Fields of all the available Unauthorized complete Answer details in Stackoverflow
 * 
 * @author Deepak
 *
 */
public class AnswerItem {

    private long answer_id;

    private AnswerOwner answerOwner;

    private Date creation_date;

    private boolean is_accepted;

    private Date last_activity_date;

    private Date last_edit_date;

    private long question_id;

    private long score;

    public long getAnswer_id() {
        return answer_id;
    }

    public AnswerOwner getAnswerOwner() {
        return answerOwner;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public Date getLast_activity_date() {
        return last_activity_date;
    }

    public Date getLast_edit_date() {
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

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public void setLast_activity_date(Date last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public void setLast_edit_date(Date last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public void setScore(long score) {
        this.score = score;
    }

}
