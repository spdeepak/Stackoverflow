package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Deepak
 *
 * @param <T>
 */
public interface URLGenerator<T> {

    /**
     * Generate URL for the given Initializer
     * 
     * @param t
     *            Type of Initializer
     * @return
     * @throws MalformedURLException
     * @throws IllegalAccessException
     */
    URL urlGenerator(T t) throws MalformedURLException, IllegalAccessException;
}
