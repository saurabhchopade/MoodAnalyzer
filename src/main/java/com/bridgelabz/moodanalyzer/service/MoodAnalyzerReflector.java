package com.bridgelabz.moodanalyzer.service;

import com.bridgelabz.moodanalyzer.main.MoodAnalyzer;

import java.lang.reflect.Constructor;

public class MoodAnalyzerReflector {
    /**
     * used for pass mood through the constructor
     *
     * @param message
     * @return
     * @throws Exception
     */
    public static MoodAnalyzer createMood(String message) throws Exception {

        Class.forName("com.bridgelabz.moodanalyzer.main.MoodAnalyzer");
        Constructor constructor = MoodAnalyzer.class.getConstructor(String.class);
        Object objofmoodanalyzer = constructor.newInstance(message);
        return (MoodAnalyzer) objofmoodanalyzer;
    }

    /**
     * Used for invoke the method
     *
     * @return
     * @throws Exception
     */
    public static MoodAnalyzer createMoodInvoke() throws Exception {
        Class.forName("com.bridgelabz.moodanalyzer.main.MoodAnalyzer");
        Constructor constructor1 = MoodAnalyzer.class.getConstructor();
        Object objofmoodanalyzer1 = constructor1.newInstance();
        return (MoodAnalyzer) objofmoodanalyzer1;
    }
}
