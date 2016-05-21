package com.destack.overflow.urlgenerator;

import java.net.MalformedURLException;
import java.net.URL;

public interface URLGenerator<T> {

    URL urlGenerator(T t) throws MalformedURLException;
}
