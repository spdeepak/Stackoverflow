package com.destack.overflow.enums;

/**
 * Display Order of Items
 * 
 * @author Deepak
 *
 */
public enum Order {
    /**
     * Ascending Order
     */
    ASC("asc"),
    /**
     * Descending Order
     */
    DESC("desc");

    private String orderName;

    private Order(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public String toString() {
        return orderName;
    }
}
