package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {


    @Test
    public void testAnalyzeMood() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("This is sad Method");
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void newMoodAnalyzer() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood("This is happy Messege");
        Assert.assertEquals("HAPPY", mood);

    }
}
