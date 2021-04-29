package com.home.common.tries;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode lastNode = root;
        for (Character character : word.toCharArray()) {
            TrieNode currentNode = lastNode.children.get(character);
            if (Objects.isNull(currentNode)) {
                TrieNode newNode = new TrieNode();

                lastNode.children.put(character, newNode);
                lastNode = newNode;
            } else {
                lastNode = currentNode;
            }
        }

        lastNode.isEndOfWord = true;
    }

    public int findByPrefix(String prefix) {
        TrieNode lastNode = root;

        for (Character character : prefix.toCharArray()) {
            TrieNode currentNode = lastNode.children.get(character);
            if (Objects.nonNull(currentNode)) {
                lastNode = currentNode;
            } else {
                return 0;
            }
        }

        return findFullWords(lastNode);
    }

    private int findFullWords(TrieNode startingNode) {
        Queue<TrieNode> queue = new LinkedList<>();
        int result = 0;

        queue.offer(startingNode);

        while (!queue.isEmpty()) {
            TrieNode currentNode = queue.poll();
            if (currentNode.isEndOfWord) {
                result += 1;
            }

            Map<Character, TrieNode> children = currentNode.children;
            if (!children.isEmpty()) {
                for (TrieNode node : children.values()) {
                    queue.offer(node);
                }
            }
        }

        return result;
    }

    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isEndOfWord;
    }
}

