package com.destack.overflow.fetcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author Deepak
 *
 */
public interface Fetcher<T> {

    /**
     * Pass Json URL and get required {@link List} of Items
     * 
     * @param jsonURL
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    List<T> objectFetcher(URL jsonURL) throws FileNotFoundException, IOException;
}
