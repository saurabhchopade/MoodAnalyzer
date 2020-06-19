package com.bridgelabz;

public class MoodAnalyzer {
    String messege;

    /**
     * Parameterized Constructor
     *
     * @param messege
     */
    public MoodAnalyzer(String messege) {
        this.messege = messege;
    }

    /**
     * analyzing mood By this method
     *
     * @return
     */
    public String analyzeMood() {
        try {
            if (messege.contains("sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            return "HAPPY";
        }
    }

}
