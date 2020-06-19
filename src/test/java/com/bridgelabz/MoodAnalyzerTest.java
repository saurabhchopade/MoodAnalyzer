package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMood_IFMoodIsSad_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This am in sad Method");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMood_IfMoodIsNothing_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("This is any mood");
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenNullMood_Ifmood_ISNull_ShouldHandle_Exception_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals("HAPPY", mood);
    }
}
