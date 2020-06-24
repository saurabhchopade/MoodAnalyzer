package com.bridgelabz.moodanalyzer.main;

import com.bridgelabz.moodanalyzer.service.MoodAnalyzerException;

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

    public String analyzeMood(String message) throws MoodAnalyzerException {
        this.message = message;
        return analyzeMood();
    }

    /**
     * analyzing mood By this method
     *
     * @return
     */
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
//Here We Are Checking Two Objects Are Same Or Not
    public boolean like(MoodAnalyzer another) {
        if (this.message.equals(another.message)) {
            return true;
        } else {
            return false;
        }
    }

}
