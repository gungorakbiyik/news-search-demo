package com.gun.newssearch.demo;

import com.gun.newssearch.demo.services.StringNormalizer;
import com.gun.newssearch.demo.services.StringNormalizerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StringNormalizerTests {

    StringNormalizer normalizer;

    @BeforeEach
    public void setUp() {
        normalizer = new StringNormalizerImpl();
    }

    @Test
    public void testNormalizerRemoveTest() {
        String normalizedStr = normalizer.normalize("  ,.()!'\\\"");
        System.out.println("normalizedStr: \"" + normalizedStr + "\"");
        assertEquals("", normalizedStr);

    }

    @Test
    public void testNormalizerRemoveStopWordsTest() {
        String normalizedStr = normalizer.normalize("  ,.()!\\\"' kanada acaba bazen çok mu soğuk");
        System.out.println("normalizedStr: \"" + normalizedStr + "\"");
        assertEquals("kanada çok mu soğuk", normalizedStr);

    }

}
