package com.gun.newssearch.demo.services;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StringNormalizerImpl implements StringNormalizer {

    private final String SPECIAL_CHARS = "[-+^,.()!'’\"\\\\]*";
    private final List<String> STOPWORDS = Arrays.asList("acaba", "ama", "bazen", "fakat", "gibi");

    @Override
    public String normalize(String... strings) {
        StringBuilder sbd = new StringBuilder();
        Arrays.stream(strings).forEach(str -> {
            String tmpStr = str;
            tmpStr = remove(tmpStr);
            tmpStr = removeStopWords(tmpStr);
            tmpStr = tmpStr.trim();
            if (!tmpStr.isEmpty()) {
                sbd.append(tmpStr).append(" ");
            }
        });
        return sbd.toString().trim().toLowerCase();
    }

    private String removeStopWords(String tmpStr) {
        for (String stopWord : STOPWORDS) {
            tmpStr = tmpStr.replaceAll(" " + stopWord + " ", " ");
        }
        return tmpStr;
    }

    private String remove(String tmpStr) {
        return tmpStr.replaceAll(SPECIAL_CHARS, "");
    }
}
