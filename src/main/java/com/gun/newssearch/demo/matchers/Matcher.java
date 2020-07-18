package com.gun.newssearch.demo.matchers;

import com.gun.newssearch.demo.model.rules.Condition;

public interface Matcher {

    boolean check(Condition condition, String value);

}
