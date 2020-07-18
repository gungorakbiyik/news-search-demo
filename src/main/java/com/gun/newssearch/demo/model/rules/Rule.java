package com.gun.newssearch.demo.model.rules;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rule {

    private String name;
    private KeywordCondition keywords;

    private AnyMatchConditionImpl newsName;
    private AnyMatchConditionImpl newsLang;
    private AnyMatchConditionImpl newsType;
    private AnyMatchConditionImpl newsTags;
    private AnyMatchConditionImpl newsCategories;

}
