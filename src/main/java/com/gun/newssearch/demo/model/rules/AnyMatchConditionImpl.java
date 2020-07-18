package com.gun.newssearch.demo.model.rules;

import lombok.Builder;

@Builder
public class AnyMatchConditionImpl implements AnyMatchCondition {
    private String value;

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
