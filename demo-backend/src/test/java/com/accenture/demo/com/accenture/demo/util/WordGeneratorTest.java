package com.accenture.demo.com.accenture.demo.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordGeneratorTest {
    @Before
    public void setUp() throws Exception {
        WordGenerator.clearList();
    }

    @Test
    public void addWordTestGenerateWord() {
        String word = "test";
        WordGenerator.addWord(word);
        Assert.assertEquals(WordGenerator.generateWord(), word);
    }
}