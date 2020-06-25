package com.bridgelabz.moodanalyzer.exception;

@SuppressWarnings("ALL")
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
    /**
     * It give Type Based On Exception
     * @param type
     * @param message
     */
    public MoodAnalyzerException(exeptiontype type, String message) {
        super(message);
        this.type = type;
    }
}