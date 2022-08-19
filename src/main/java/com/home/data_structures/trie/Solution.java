package com.home.data_structures.trie;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Tries tries = new Tries();

        tries.addWord("cat");
        tries.addWord("cattle");
        tries.addWord("catastrophe");
        tries.addWord("dog");
        tries.addWord("fish");

        tries.printTries();
        System.out.println("===================");
        List<String> result = tries.searchByPrefix("rat");
        result.forEach(System.out::println);
        System.out.println("===================");
        result = tries.searchByPrefix("cat");
        result.forEach(System.out::println);
    }
}
