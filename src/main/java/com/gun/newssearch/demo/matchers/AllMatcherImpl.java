package com.gun.newssearch.demo.matchers;

import com.gun.newssearch.demo.model.rules.Condition;
import com.gun.newssearch.demo.util.TrieHelper;
import org.ahocorasick.trie.Emit;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class AllMatcherImpl implements Matcher {

    @Override
    public boolean check(Condition condition, String value) {
        String[] keywords = condition.getValue().split(",");
        Collection<Emit> emits = TrieHelper.parse(value, keywords);

        Set<String> found = new HashSet<>();
        System.out.println("*************  AllMatcherImpl  *************");
        emits.forEach(emit -> {
            System.out.println(emit);
            found.add(emit.getKeyword());
        });

        for (String keyword : keywords) {
            if (!found.contains(keyword)) {
                System.out.println(String.format("%s not found", keyword));
                return false;
            }
        }

        return true;
    }


}
