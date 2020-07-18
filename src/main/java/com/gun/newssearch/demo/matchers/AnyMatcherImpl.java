package com.gun.newssearch.demo.matchers;

import com.gun.newssearch.demo.model.rules.Condition;
import com.gun.newssearch.demo.util.TrieHelper;
import org.ahocorasick.trie.Emit;

import java.util.Collection;

public class AnyMatcherImpl implements Matcher {

    @Override
    public boolean check(Condition condition, String value) {
        String[] keywords = condition.getValue().split(",");
        Collection<Emit> emits = TrieHelper.parse(value, keywords);
        System.out.println("*************  AnyMatcherImpl  *************");
        emits.forEach(emit -> {
            System.out.println(emit);
        });
        return emits.size() > 0;
    }
}
