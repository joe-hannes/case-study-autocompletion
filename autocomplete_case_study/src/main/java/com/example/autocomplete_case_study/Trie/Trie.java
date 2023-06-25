package com.example.autocomplete_case_study.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class implements the insert and getNodesWithPrefix methods of the Trie data structure.
 */
public class  Trie <T> {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a term into the Trie.
     * @param term The term to insert into the Trie.
     */
    public void insert(String term, T content){

        TrieNode current = root;
        for (Character c : term.toCharArray()){
            if (!current.getChildren().containsKey(c)) {
                current.addChild(c);
            }
            current = (TrieNode) current.getChildren().get(c);
        }
        current.setEndOfWord(true);
        current.setContent(content);

    }

    /**
     * Helper function that is called recursively to find all nodes that start with a given prefix.
     * @param node The current node.
     * @param prefix The current prefix.
     * @param results Stores the words that have been found so far.
     */
    private  void collectNodes(TrieNode node, String prefix, List<T> results) {
            if (node.isEndOfWord()) {

                T content = (T) node.getContent();
                results.add((T) node.getContent());
            }

            HashMap<Character, TrieNode> children = node.getChildren();
            for (HashMap.Entry<Character, TrieNode> child : children.entrySet()) {
                TrieNode childNode = (TrieNode) node.getChildren().get(child.getKey());
                if (childNode != null) {
                    collectNodes(childNode, prefix + child.getKey(), results);
                }
            }

        }

    /**
     * Finds all entries starting with a given prefix.
     * @param prefix The original prefix to find the entries for.
     * @return A List of strings containing all entries starting with the given prefix.
     */
    public List<T> getNodesWithPrefix(String prefix) {

        List<T> matches = new ArrayList<>();
        TrieNode current = root;

        for (Character c : prefix.toCharArray()) {
            if (current != null) {
                current = (TrieNode) current.getChildren().get(c);
            }
        }

        if(current == null) {
            return matches;
        }

        collectNodes(current, prefix, matches);

        return matches;
    }
}
