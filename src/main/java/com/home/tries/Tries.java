package com.home.tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Tries {
    private final TriesNode root = new TriesNode();

    public void addWord(String newWord) {
        char[] characters = newWord.toCharArray();
        TriesNode tempRoot = root;

        for (Character character : characters) {
            Map<Character, TriesNode> children = tempRoot.getChildren();
            if (!children.containsKey(character)) {
                TriesNode newNode = new TriesNode();
                children.put(character, newNode);
            }

            tempRoot = children.get(character);
        }

        tempRoot.setTerminal(true);
    }

    public void printTries() {
        List<String> words = new ArrayList<>();
        for (Map.Entry<Character, TriesNode> childEntry : root.getChildren().entrySet()) {
            getWordsRecursion("" + childEntry.getKey(), childEntry.getValue(), words);
        }

        words.forEach(System.out::println);
    }

    public List<String> searchByPrefix(String prefix) {
        TriesNode tempRoot = root;

        for (Character character : prefix.toCharArray()) {
            tempRoot = tempRoot.getChildren().get(character);

            if (Objects.isNull(tempRoot)) {
                System.out.printf("No results found for prefix: %s%n", prefix);
                return Collections.emptyList();
            }
        }

        List<String> words = new ArrayList<>();
        getWordsRecursion(prefix, tempRoot, words);

        return words;
    }

    private void getWordsRecursion(String prefix, TriesNode root, List<String> words) {
        if (root.isTerminal()) {
            words.add(prefix);
        }

        if (root.getChildren().isEmpty()) {
            return;
        }

        for (Map.Entry<Character, TriesNode> childEntry : root.getChildren().entrySet()) {
            getWordsRecursion(prefix + childEntry.getKey(), childEntry.getValue(), words);
        }
    }
}
