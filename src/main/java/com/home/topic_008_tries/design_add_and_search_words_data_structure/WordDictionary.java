package com.home.topic_008_tries.design_add_and_search_words_data_structure;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    WordDictionary.TrieNode root = new TrieNode();

    public void addWord(String word) {
        WordDictionary.TrieNode current = root;

        for (Character character : word.toCharArray()) {
            if (current.children.containsKey(character)) {
                current = current.children.get(character);
            } else {
                WordDictionary.TrieNode newItem = new WordDictionary.TrieNode();
                current.children.put(character, newItem);
                current = newItem;
            }
        }

        current.isTerminal = true;
    }

    public boolean search(String word) {
        return searchInNode(root, word);
    }

    private boolean searchInNode(WordDictionary.TrieNode current, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (WordDictionary.TrieNode node : current.children.values()) {
                    boolean result = searchInNode(node, word.substring(i + 1));

                    if (result) {
                        return true;
                    }
                }

                return false;
            } else {
                if (current.children.containsKey(word.charAt(i))) {
                    current = current.children.get(word.charAt(i));
                } else {
                    return false;
                }
            }
        }

        return current.isTerminal;
    }

    static class TrieNode {
        boolean isTerminal;
        Map<Character, WordDictionary.TrieNode> children = new HashMap<>();
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");

//        System.out.println(wordDictionary.search("pad"));
//        System.out.println(wordDictionary.search("bad"));
//        System.out.println(wordDictionary.search(".ad"));
//        System.out.println(wordDictionary.search("b.."));
//        System.out.println(wordDictionary.search("b.a"));
//        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }
}
