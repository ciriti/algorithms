package com.ciriti;

/**
 * Created by Carmelo Iriti
 */
public class PrimitivesJavaBenchmark {

    public int primitiveCount() {
        int a = 1;
        for (int i = 0; i < 1_000_000; i++) {
            a = a + i * 2;
        }
        return a;
    }

    public Integer objectCount() {
        Integer a = 1;
        for (Integer i = 0; i < 1_000_000; i++) {
            a = a + i * 2;
        }
        return a;
    }
}
