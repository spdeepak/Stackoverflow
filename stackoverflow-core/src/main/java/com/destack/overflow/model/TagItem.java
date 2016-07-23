package com.destack.overflow.model;

/**
 * @author Deepak
 *
 */
public class TagItem {

    private String[] synonyms;

    private Long lastActivityDate;

    private boolean hasSynonyms;

    private boolean moderatorOnly;

    private boolean required;

    private Integer count;

    private String name;

    private Owner tagOwner;

    private String creationDate;

    private String lastAppliedDate;

    private Long appliedCount;

    private String toTag;

    private String fromTag;

    public String[] getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }

    public Long getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public boolean isHasSynonyms() {
        return hasSynonyms;
    }

    public void setHasSynonyms(boolean hasSynonyms) {
        this.hasSynonyms = hasSynonyms;
    }

    public boolean isModeratorOnly() {
        return moderatorOnly;
    }

    public void setModeratorOnly(boolean moderatorOnly) {
        this.moderatorOnly = moderatorOnly;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getTagOwner() {
        return tagOwner;
    }

    public void setTagOwner(Owner tagOwner) {
        this.tagOwner = tagOwner;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastAppliedDate() {
        return lastAppliedDate;
    }

    public void setLastAppliedDate(String lastAppliedDate) {
        this.lastAppliedDate = lastAppliedDate;
    }

    public Long getAppliedCount() {
        return appliedCount;
    }

    public void setAppliedCount(Long appliedCount) {
        this.appliedCount = appliedCount;
    }

    public String getToTag() {
        return toTag;
    }

    public void setToTag(String toTag) {
        this.toTag = toTag;
    }

    public String getFromTag() {
        return fromTag;
    }

    public void setFromTag(String fromTag) {
        this.fromTag = fromTag;
    }


}
