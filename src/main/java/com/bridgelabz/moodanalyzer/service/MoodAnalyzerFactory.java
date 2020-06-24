package com.bridgelabz.moodanalyzer.service;

import com.bridgelabz.moodanalyzer.main.MoodAnalyzer;

import java.lang.reflect.Constructor;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMood(String message) throws Exception {

        Class c = Class.forName("com.bridgelabz.moodanalyzer.main.MoodAnalyzer");
        Constructor constructor = MoodAnalyzer.class.getConstructor(String.class);
        Object objofmoodanalyzer = constructor.newInstance(message);
        return (MoodAnalyzer) objofmoodanalyzer;
    }

    public  static  MoodAnalyzer createMood1() throws Exception {
        Class c1 = Class.forName("com.bridgelabz.moodanalyzer.main.MoodAnalyzer");
        Constructor constructor1 = MoodAnalyzer.class.getConstructor();
        Object objofmoodanalyzer1 = constructor1.newInstance();
        return (MoodAnalyzer) objofmoodanalyzer1;
    }
}
