package com.accenture.internship.prefixTree;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PrefixTreeImplTest {

    @Test
    public void givenATrie_WhenAddingElements_ThenTrieNotEmpty() {
        PrefixTreeImpl trie = new PrefixTreeImpl();
        trie.insert("hello");
        assertTrue(trie.contains("hello"));
        trie.insert("world");
        assertTrue(trie.contains("world"));
        assertFalse(trie.contains("helloworld"));
    }
}