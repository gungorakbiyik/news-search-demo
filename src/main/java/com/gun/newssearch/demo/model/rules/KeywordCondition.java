package com.gun.newssearch.demo.model.rules;

import lombok.Builder;

@Builder
public class KeywordCondition implements AllMatchCondition {

    private String value;

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
