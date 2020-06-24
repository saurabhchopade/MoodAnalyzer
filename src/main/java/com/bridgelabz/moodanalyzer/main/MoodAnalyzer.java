package com.bridgelabz.moodanalyzer.main;

import com.bridgelabz.moodanalyzer.service.MoodAnalyzerException;

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

    public String analyzeMood(String messege) throws MoodAnalyzerException {
        this.messege = messege;
        return analyzeMood();
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
//Here We Are Checking Two Objects Are Same Or Not
    public boolean like(MoodAnalyzer another) {
        if (this.messege.equals(another.messege)) {
            return true;
        } else {
            return false;
        }
    }

}
