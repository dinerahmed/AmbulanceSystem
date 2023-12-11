package com.example.ambulancesystem.controllers;

public class StringMatchException extends Exception {
    public StringMatchException(String expected, String actual) {
        super("String match error: Expected '" + expected + "', but got '" + actual + "'");
    }
}
