package com.accenture.demo.com.accenture.demo.util;

import java.util.Random;

public class WordGenerator {
    private static String[] Words = {"World", "LiDOP", "Universe"};
    private static Random rand = new Random();

    public static String generateWord() {
        return Words[rand.nextInt(Words.length)];
    }
}
