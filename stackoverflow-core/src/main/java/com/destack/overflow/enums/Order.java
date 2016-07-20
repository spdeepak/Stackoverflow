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

    public static boolean contains(Order order) {
        if (order != null) {
            for (Order sort : Order.class.getEnumConstants()) {
                if (sort.equals(order)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(Order order) {
        if (order != null) {
            return contains(order);
        } else {
            return false;
        }
    }
}
