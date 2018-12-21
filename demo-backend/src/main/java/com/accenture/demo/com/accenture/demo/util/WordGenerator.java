package com.accenture.demo.com.accenture.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordGenerator {
    private static List<String> Words = new ArrayList<>(Arrays.asList("World", "LiDOP", "Universe"));
    private static Random rand = new Random();

    public static String generateWord() {
        String word = "";
        if (Words.size() > 0) {
            word = Words.get(rand.nextInt(Words.size()));
        }
        return word;
    }

    public static void addWord(String word) {
        Words.add(word);
    }

    public static void clearList() {
        Words.clear();
    }
}
