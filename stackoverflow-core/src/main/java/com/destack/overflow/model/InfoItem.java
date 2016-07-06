package com.destack.overflow.model;

/**
 * Get information about the entire site.
 * 
 * @author Deepak
 *
 */
public class InfoItem {

    private Integer new_active_users;

    private Integer total_users;

    private double badges_per_minute;

    private Integer total_badges;

    private Integer total_votes;

    private Integer total_comments;

    private double answers_per_minute;

    private double questions_per_minute;

    private Integer total_answers;

    private Integer total_accepted;

    private Integer total_unanswered;

    private Integer total_questions;

    private String api_revision;

    public Integer getNew_active_users() {
        return new_active_users;
    }

    public void setNew_active_users(Integer new_active_users) {
        this.new_active_users = new_active_users;
    }

    public Integer getTotal_users() {
        return total_users;
    }

    public void setTotal_users(Integer total_users) {
        this.total_users = total_users;
    }

    public double getBadges_per_minute() {
        return badges_per_minute;
    }

    public void setBadges_per_minute(double badges_per_minute) {
        this.badges_per_minute = badges_per_minute;
    }

    public Integer getTotal_badges() {
        return total_badges;
    }

    public void setTotal_badges(Integer total_badges) {
        this.total_badges = total_badges;
    }

    public Integer getTotal_votes() {
        return total_votes;
    }

    public void setTotal_votes(Integer total_votes) {
        this.total_votes = total_votes;
    }

    public Integer getTotal_comments() {
        return total_comments;
    }

    public void setTotal_comments(Integer total_comments) {
        this.total_comments = total_comments;
    }

    public double getAnswers_per_minute() {
        return answers_per_minute;
    }

    public void setAnswers_per_minute(double answers_per_minute) {
        this.answers_per_minute = answers_per_minute;
    }

    public double getQuestions_per_minute() {
        return questions_per_minute;
    }

    public void setQuestions_per_minute(double questions_per_minute) {
        this.questions_per_minute = questions_per_minute;
    }

    public Integer getTotal_answers() {
        return total_answers;
    }

    public void setTotal_answers(Integer total_answers) {
        this.total_answers = total_answers;
    }

    public Integer getTotal_accepted() {
        return total_accepted;
    }

    public void setTotal_accepted(Integer total_accepted) {
        this.total_accepted = total_accepted;
    }

    public Integer getTotal_unanswered() {
        return total_unanswered;
    }

    public void setTotal_unanswered(Integer total_unanswered) {
        this.total_unanswered = total_unanswered;
    }

    public Integer getTotal_questions() {
        return total_questions;
    }

    public void setTotal_questions(Integer total_questions) {
        this.total_questions = total_questions;
    }

    public String getApi_revision() {
        return api_revision;
    }

    public void setApi_revision(String api_revision) {
        this.api_revision = api_revision;
    }

}
