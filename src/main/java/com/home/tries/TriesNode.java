package com.home.tries;

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
