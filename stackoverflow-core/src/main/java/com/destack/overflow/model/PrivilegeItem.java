package com.destack.overflow.model;


/**
 * @author Deepak
 *
 */
public class PrivilegeItem {

    private Integer reputation;

    private String description;

    private String short_description;

    public PrivilegeItem(int reputation, String description, String short_description) {
        this.reputation = reputation;
        this.description = description;
        this.short_description = short_description;
    }
    public Integer getReputation() {
        return reputation;
    }

    public String getDescription() {
        return description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }
}
