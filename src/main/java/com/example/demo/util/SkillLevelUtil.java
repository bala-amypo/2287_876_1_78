package com.example.demo.util;

public class SkillLevelUtil {
    public enum Level {
        BEGINNER,
        INTERMEDIATE,
        EXPERT;

        public static Level from(String s) {
            if (s == null) return null;
            return Level.valueOf(s.trim().toUpperCase());
        }
    }

    public static boolean meetsOrExceeds(String actual, String required) {
        Level a = Level.from(actual);
        Level r = Level.from(required);
        if (a == null || r == null) return false;
        return a.ordinal() >= r.ordinal();
    }
}
