package com.destack.overflow.initializers;

import com.destack.overflow.enums.Order;

public interface BaseBuilder<T> {

    /**
     * @param page
     * @return
     */
    public BaseBuilder<?> page(Integer page);

    /**
     * @param pageSize
     * @return
     */
    public BaseBuilder<?> pageSize(Integer pageSize);

    /**
     * Default is {@link Order#DESC}
     * 
     * @param order
     * @return
     */
    public BaseBuilder<?> order(Order order);

    public T build();

}
