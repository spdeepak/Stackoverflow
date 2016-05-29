package com.destack.overflow.model;

/**
 * @author Deepak
 *
 */
public class ItemExtras {

    protected boolean has_more;

    protected Integer quota_max;

    protected Integer quota_remaining;

    protected Integer page;

    protected Integer page_size;

    protected Integer total;

    protected String type;

    private Integer error_id;

    private String error_message;

    private String error_name;

    public boolean isHas_more() {
        return has_more;
    }

    public Integer getQuota_max() {
        return quota_max;
    }

    public Integer getQuota_remaining() {
        return quota_remaining;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public Integer getTotal() {
        return total;
    }

    public String getType() {
        return type;
    }

    public Integer getError_id() {
        return error_id;
    }

    public String getError_message() {
        return error_message;
    }

    public String getError_name() {
        return error_name;
    }

    public void setError_id(Integer error_id) {
        this.error_id = error_id;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public void setError_name(String error_name) {
        this.error_name = error_name;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public void setQuota_max(Integer quota_max) {
        this.quota_max = quota_max;
    }

    public void setQuota_remaining(Integer quota_remaining) {
        this.quota_remaining = quota_remaining;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setType(String type) {
        this.type = type;
    }

}
