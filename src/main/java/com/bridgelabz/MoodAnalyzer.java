package com.bridgelabz;

public class MoodAnalyzer {
    /**
     * Simple Happy Sad Check
     *
     * @param messege
     * @return
     */
    public String analyzeMood(String messege) {
        if (messege.contains("sad")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
