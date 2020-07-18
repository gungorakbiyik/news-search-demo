package com.gun.newssearch.demo.util;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;
import org.springframework.stereotype.Component;

import java.util.Collection;

public class TrieHelper {

    public static Collection<Emit> parse(String text, String... keywords) {
        Trie trie = Trie.builder()
                .addKeywords(keywords)
                .build();

        Collection<Emit> emits = trie.parseText(text);
        return emits;
    }

}
