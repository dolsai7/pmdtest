package com.example.login;

import java.util.*; // 사용하지 않는 import

public class PMDTestClass {

    // 사용하지 않는 private 필드
    private String unusedField = "never used";

    public void testMethod() {
        String unused = "not used"; // UnusedLocalVariable
        int x = 1; // ShortVariable

        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            // EmptyCatchBlock
        }

        System.out.println("Hello"); // SystemPrintln
    }

    // 불필요한 지역 변수
    public String unnecessaryVariable() {
        String result = "Hello";
        return result; // 바로 return하면 되는데 변수 사용
    }
}
