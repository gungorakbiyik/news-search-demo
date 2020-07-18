package com.gun.newssearch.demo;

import com.gun.newssearch.demo.matchers.AllMatcherImpl;
import com.gun.newssearch.demo.matchers.Matcher;

import static org.junit.jupiter.api.Assertions.*;

import com.gun.newssearch.demo.model.rules.KeywordCondition;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AllMatcherTests {

    @Test
    public void testSingleKeyword() {
        Matcher matcher = new AllMatcherImpl();
        assertEquals(true, matcher.check(
                KeywordCondition.builder()
                        .value("korona")
                        .build(),
                "korona"));


        System.out.println("Hello");
    }

    @Test
    public void testMultipleKeyword() {
        Matcher matcher = new AllMatcherImpl();
        assertEquals(true, matcher.check(
                KeywordCondition.builder()
                        .value("korona, corona, virüs")
                        .build(),
                "korona virüs corona covid19 vesaire"));


        System.out.println("Hello");
    }

}
