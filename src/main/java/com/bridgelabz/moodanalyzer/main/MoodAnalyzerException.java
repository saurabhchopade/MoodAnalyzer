package com.bridgelabz.moodanalyzer.main;

public class MoodAnalyzerException extends Exception {
    /**
     * Calling Constructor Of Parent class means Exception
     *
     * @param message
     */
    enum exeptiontype {
        ENTEREDNULLL, ENTEREDEMPTY

    }

    exeptiontype type;

    public MoodAnalyzerException(exeptiontype type, String message) {
        super(message);
        this.type = type;
    }
}