package com.destack.overflow.model;


/**
 * @author Deepak
 *
 */
public class TagItem {

    private long last_activity_date;

    private boolean has_synonyms;

    private boolean is_moderator_only;

    private boolean is_required;

    private Integer count;

    private String name;

    public long getLast_activity_date() {
        return last_activity_date;
    }

    public boolean isHas_synonyms() {
        return has_synonyms;
    }

    public boolean isIs_moderator_only() {
        return is_moderator_only;
    }

    public boolean isIs_required() {
        return is_required;
    }

    public Integer getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setLast_activity_date(long last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public void setHas_synonyms(boolean has_synonyms) {
        this.has_synonyms = has_synonyms;
    }

    public void setIs_moderator_only(boolean is_moderator_only) {
        this.is_moderator_only = is_moderator_only;
    }

    public void setIs_required(boolean is_required) {
        this.is_required = is_required;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }
}
