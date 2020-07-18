package com.gun.newssearch.demo.matchers;

import com.gun.newssearch.demo.model.rules.AllMatchCondition;
import com.gun.newssearch.demo.model.rules.AnyMatchCondition;
import com.gun.newssearch.demo.model.rules.Condition;

public class MatcherFactory {

    public static Matcher getMatcher(Condition condition) {
        if (condition instanceof AllMatchCondition) {
            return new AllMatcherImpl();
        } else if (condition instanceof AnyMatchCondition) {
            return new AnyMatcherImpl();
        }
        return null;
    }

}
