package com.example.autocomplete_case_study.service;


import com.example.autocomplete_case_study.Trie.Trie;
import com.example.autocomplete_case_study.model.StationData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class provides methods to arrange the StationData in a Trie data structure.
 */
@Service
public class DataProcessingService {

    private static Trie trie = new Trie();

    /**
     * Given a List of StationData object, this methods builds the trie by repeatedly calling the insert() operation.
     * @param stationData The StationData object that should be inserted into the Trie.
     */

    public static void buildTrie(List<StationData> stationData) {
        for ( StationData station: stationData) {
            trie.insert(station.getName(), station);
        }
    }

    /**
     * Returns all auto-complete suggestions based on a given prefix. Must be called after the Trie has been build.
     * @param prefix The prefix that the auto-complete suggestion is based on.
     * @return A list containing all StationData object that have the given common prefix.
     */
    public static List<StationData> getSuggestions(String prefix) {
        return trie.getNodesWithPrefix(prefix);
    }

}
