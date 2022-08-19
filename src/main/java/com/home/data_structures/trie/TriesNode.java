package com.home.data_structures.trie;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.TreeMap;

@Setter
@Getter
public class TriesNode {
    private boolean isTerminal;
    private Map<Character, TriesNode> children = new TreeMap<>();
}
