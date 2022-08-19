package com.home.task_040_implement_trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    Trie.TrieNode root = new TrieNode();

    public Trie() {

    }

    public void insert(String word) {
        Trie.TrieNode current = root;

        for (Character character : word.toCharArray()) {
            if (current.children.containsKey(character)) {
                current = current.children.get(character);
            } else {
                Trie.TrieNode newItem = new TrieNode();
                current.children.put(character, newItem);
                current = newItem;
            }
        }

        current.isTerminal = true;
    }

    public boolean search(String word) {
        Trie.TrieNode current = root;

        for (Character character : word.toCharArray()) {
            if (current.children.containsKey(character)) {
                current = current.children.get(character);
            } else {
                return false;
            }
        }

        return current.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Trie.TrieNode current = root;

        for (Character character : prefix.toCharArray()) {
            if (current.children.containsKey(character)) {
                current = current.children.get(character);
            } else {
                return false;
            }
        }

        return true;
    }

    static class TrieNode {
        boolean isTerminal;
        Map<Character, Trie.TrieNode> children = new HashMap<>();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
