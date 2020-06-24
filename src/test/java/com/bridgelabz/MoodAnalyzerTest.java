package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;

public class MoodAnalyzerTest extends Exception {

    MoodAnalyzer moodAnalyzer;
    @Before
    public void init() {

        moodAnalyzer = new MoodAnalyzer(null);
    }

    @Test
    public void givenMood_IFMoodIsSad_ShouldReturnSad() {
        new MoodAnalyzer("This am in sad Method");
        String mood = null;
        try {
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalyzerException.class);
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyzerException e) {
        }
    }

    @Test
    public void givenMood_IfMoodIsNothing_ShouldReturnHappy() {
        new MoodAnalyzer("This is any mood");
        String mood = null;
        try {
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalyzerException.class);
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
        }
    }

    @Test
    public void givenNullMood_Ifmood_ISNull_ShouldHandle_Exception_ShouldReturnHappy() {
        new MoodAnalyzer(null);
        try {
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.exeptiontype.ENTEREDNULLL, e.type);
        }
    }
    // =================================Reflection======================================
    @Test
    public void usingReflection_GivenMessage_ShouldReturnClassObject() throws Exception {
        Constructor constructor = Class.forName("com.bridgelabz.MoodAnalyzer").getConstructor(String.class);
        Object obj = (MoodAnalyzer) constructor.newInstance("i am sad");
        MoodAnalyzer moodanalyzer = (MoodAnalyzer) obj;
        String returnobjvalue = moodanalyzer.analyzeMood();
        Assert.assertEquals("SAD", returnobjvalue);
    }
}
