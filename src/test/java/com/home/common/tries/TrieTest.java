package com.home.common.tries;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TrieTest {
    @Test
    public void findByPrefix_happyPath() {
        Trie trie = new Trie();

        trie.addWord("has");
        trie.addWord("have");
        trie.addWord("hat");

        int result = trie.findByPrefix("ha");

        Assertions.assertThat(result).isEqualTo(3);
    }
}
