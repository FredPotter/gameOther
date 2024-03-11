package ru.gorshkov.gameother.util;

public class CodeGen {
    public static int generateCode() {
        return (int) ((Math.random() * 100000) % 10000);
    }
}
