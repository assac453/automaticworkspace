package com.assac453.automatedworkstation.repository;

import java.util.Random;

public class RandomGeneratorUtil {

    private static final Random RANDOM = new Random();

    static String createRandomNumbers(int limit) {
        return RANDOM.ints(0, 10)
                .limit(limit)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    static String createRandomString(int targetStringLength) {
        return RANDOM.ints(97, 122)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
