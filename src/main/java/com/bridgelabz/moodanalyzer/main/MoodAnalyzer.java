package com.bridgelabz.moodanalyzer.main;

public class MoodAnalyzer {
    String messege;

    /**
     * Parameterized Constructor
     *
     * @param massage
     */
    public MoodAnalyzer(String massage) {
        this.messege = massage;
    }

    /**
     * analyzing mood By this method
     *
     * @return
     */
    public String analyzeMood() throws MoodAnalyzerException {
        try {
            if (messege.length() == 0)
                throw new MoodAnalyzerException(MoodAnalyzerException.exeptiontype.ENTEREDEMPTY, "Please Enter Proper Mood");
            if (messege.contains("sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.exeptiontype.ENTEREDNULLL, "Please Enter Proper Mood");
        }
    }

}
