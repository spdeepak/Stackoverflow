package com.destack.overflow.enums;

/**
 * For Ranks, bronze is greater than silver which is greater than gold
 * 
 * @author Deepak
 *
 */
public enum MaxMin {
    /**
     * {@link #GOLD} has less value than {@link #SILVER} & {@link #BRONZE}
     */
    GOLD("gold"),
    /**
     * {@link #SILVER} is greater than {@link #GOLD}. But {@link #BRONZE} is greater than
     * {@link #SILVER}
     */
    SILVER("silver"),
    /**
     * {@link #BRONZE} is greater than {@link #SILVER} which is greater than {@link #GOLD}
     */
    BRONZE("bronze");

    private String name;

    private MaxMin(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
