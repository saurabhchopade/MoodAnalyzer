package com.bridgelabz.moodanalyzer.main;

import com.bridgelabz.moodanalyzer.exception.MoodAnalyzerException;

public class MoodAnalyzer {
    String message;

    /**
     * Default Constructor
     */
    public MoodAnalyzer()
    {
    }
    /**
     * Parameterized Constructor
     *
     * @param massage
     */
    public MoodAnalyzer(String massage) {
        this.message = massage;
    }

    public String analyzeMood() throws MoodAnalyzerException {
        try {
            if (message.length() == 0)
                throw new MoodAnalyzerException(MoodAnalyzerException.exeptiontype.ENTEREDEMPTY, "Please Enter Proper Mood");
            if (message.contains("sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.exeptiontype.ENTEREDNULLL, "Please Enter Proper Mood");
        }
    }
    public boolean like(MoodAnalyzer another) {
        if (this.message.equals(another.message)) {
            return true;
        } else {
            return false;
        }
    }
}
