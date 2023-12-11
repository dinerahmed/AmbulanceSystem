package com.example.ambulancesystem.controllers;

public class StringMatcher {
    public static boolean StringMatch(String expected, String actual) throws StringMatchException {
        if (!expected.equals(actual)) {
            throw new StringMatchException(expected, actual);
        } else {
            System.out.println("String match successful!");
            return true;
        }
    }
}
