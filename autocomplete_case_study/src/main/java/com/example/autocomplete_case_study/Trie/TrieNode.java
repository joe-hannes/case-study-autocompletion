package com.example.autocomplete_case_study.Trie;

import java.util.HashMap;

/**
 * This class implements a node in a Trie. Each TrieNode consists of a map containing its children, the content stored
 * for the node and an indicator showing if the node is the end of a word.
 * @param <T> The Type of the stored content.
 */
public class TrieNode <T>  {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private T content;
    private boolean endofWord;

    /**
     * Returns all children of a node
     * @return The children of the node
     */
    public HashMap<Character, TrieNode> getChildren() {
        return this.children;
    }

    /**
     * Returns true if the node is the end of a word and false if not.
     * @return A boolean value indicating if the node is the end of a word
     */
    public boolean isEndOfWord() {
        return this.endofWord;
    }

    /**
     * Sets the node as an end of word node.
     * @param isEnd sets the endOfWorld field to the value specified
     */
    public void setEndOfWord(boolean isEnd) {
        this.endofWord = isEnd;
    }

    /**
     * Adds a new node as the child of the current node with the key specified
     * @param key The key that is used to identify the child.
     */
    public void addChild(Character key) {
        TrieNode node = new TrieNode();
        this.children.put(key, node);
    }

    /**
     * Sets the content for the node.
     * @param content A generic type representing the content for the node
     */
    public void setContent(T content) {
        this.content = content;
    }

    /**
     * Gets the content for the node.
     * @return  The Object stored in this node
     */
    public T getContent() {
        return this.content;
    }
}
