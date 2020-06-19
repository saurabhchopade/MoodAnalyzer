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
