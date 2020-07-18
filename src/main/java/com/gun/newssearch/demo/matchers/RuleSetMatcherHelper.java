package com.gun.newssearch.demo.matchers;

import com.gun.newssearch.demo.model.rules.Condition;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RuleSetMatcherHelper {

    private Map<Condition, String> conditionMap;
    private Map<Condition, String[]> conditionStringArMap;

    public RuleSetMatcherHelper() {
        conditionMap = new HashMap<>();
    }

    public RuleSetMatcherHelper add(Condition condition, String value) {
        if (Objects.nonNull(condition) && Objects.nonNull(condition.getValue()) && Objects.nonNull(value)) {
            conditionMap.put(condition, value);
        }
        return this;
    }

    public boolean check() {
        Matcher matcher;
        boolean isMatched = false;
        for (Condition condition : conditionMap.keySet()) {
            matcher = getMatcher(condition);
            isMatched = matcher.check(condition, conditionMap.get(condition));
            if (!isMatched) {
                return isMatched;
            }
        }
        return isMatched;
    }

    private Matcher getMatcher(Condition condition) {
        return MatcherFactory.getMatcher(condition);
    }

}
