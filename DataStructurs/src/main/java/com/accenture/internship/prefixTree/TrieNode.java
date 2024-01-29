package com.accenture.internship.prefixTree;

import lombok.*;

import java.util.*;

@Data
public class TrieNode {

    private HashMap<Character, TrieNode> children;
    private char c;
    private boolean isWord;

    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }



}
