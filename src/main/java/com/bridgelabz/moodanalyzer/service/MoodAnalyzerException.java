package com.bridgelabz.moodanalyzer.service;

public class MoodAnalyzerException extends Exception {
    /**
     * Calling Constructor Of Parent class means Exception
     *
     * @param message
     */
   public enum exeptiontype {
         ENTEREDNULLL, ENTEREDEMPTY

    }

    public  exeptiontype type;

    public MoodAnalyzerException(exeptiontype type, String message) {
        super(message);
        this.type = type;
    }
}