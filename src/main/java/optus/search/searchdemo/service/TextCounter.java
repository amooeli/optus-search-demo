package optus.search.searchdemo.service;

import optus.search.searchdemo.entity.CountResponseEntity;

import java.util.List;

public interface TextCounter {

    /**
     * Find occurrences of given texts in the given source
     *
     * @param searchText A list of words to search for
     * @param source The source to search in
     * @return An entity containing the number of occurrences of the given texts
     */
    CountResponseEntity findWordsCount(List<String> searchText, List<String> source);

    /**
     * Find the top counts of words in the source
     *
     * @param topCount Number of top counts
     * @param source The source to search in
     * @return A string of comma separated top counts based on the topCount param
     */
    String findWordsTopCount(int topCount, List<String> source);
}
