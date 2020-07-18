package com.gun.newssearch.demo.services;

import com.gun.newssearch.demo.model.News;
import com.gun.newssearch.demo.model.rules.RuleSet;

public interface NewsMatcher {

    boolean match(News news, RuleSet ruleSet);

}
