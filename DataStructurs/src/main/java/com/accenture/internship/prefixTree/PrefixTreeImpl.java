package com.accenture.internship.prefixTree;

public class PrefixTreeImpl implements PrefixTree{

    private TrieNode root;

    @Override
    public void insert(String word) {
        TrieNode current = root;

        for (char l: word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setWord(true);
    }


    public boolean contains(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.getChildren().containsKey(c)) {
                return false;
            }
            current = current.getChildren().get(c);
        }
        return current.isWord();
    }

}
