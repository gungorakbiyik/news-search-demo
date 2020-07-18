package com.gun.newssearch.demo.model.rules;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RuleSet {

    private String name;
    private List<Rule> rules;

}
