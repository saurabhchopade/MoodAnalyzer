package com.bridgelabz.moodanalyzer.main;

import com.bridgelabz.moodanalyzer.service.MoodAnalyzerException;
import com.bridgelabz.moodanalyzer.service.MoodAnalyzerReflector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest extends Exception {

    MoodAnalyzer moodAnalyzer;
    @Before
    public void init() {

        moodAnalyzer = new MoodAnalyzer();
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
    // =================================Reflection With Parameterized Constructor======================================
    @Test
    public void usingReflection_GivenMessage_ShouldReturnClassObject() throws Exception {
        Constructor constructor = Class.forName("com.bridgelabz.moodanalyzer.main.MoodAnalyzer").getConstructor(String.class);
        Object obj = (MoodAnalyzer) constructor.newInstance("i am sad");
        MoodAnalyzer moodanalyzer = (MoodAnalyzer) obj;
        String returnobjvalue = moodanalyzer.analyzeMood();
        Assert.assertEquals("SAD", returnobjvalue);
    }

    @Test
    public void givenClassName_NotCorrect_ShouldHandleException() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyzer.main.Moer").getConstructor(String.class);
            Object obj = (MoodAnalyzer) constructor.newInstance("i am sad");
            MoodAnalyzer moodanalyzer = (MoodAnalyzer) obj;
            String returnobjvalue = moodanalyzer.analyzeMood();
            Assert.assertEquals("SAD", returnobjvalue);
        } catch (MoodAnalyzerException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenConstructor_ParametersNotCorrect_ShouldHandleException() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyzer.main.MoodAnalyzer").getConstructor(String.class);
            Object obj = (MoodAnalyzer) constructor.newInstance();
            MoodAnalyzer moodanalyzer = (MoodAnalyzer) obj;
            String returnobjvalue = moodanalyzer.analyzeMood();
            Assert.assertEquals("SAD", returnobjvalue);
        } catch (MoodAnalyzerException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //===================Parameterized object============================================================
    @Test
    public void createMoodAnalyzerParameterizedObjectThroughFactoryClass_IfObjectEqual_TestWillPass() throws Exception {
        MoodAnalyzer mooder = MoodAnalyzerReflector.createMood("i am sad");
        String mood = mooder.analyzeMood();
        Assert.assertEquals("SAD", mood);
    }

    //=======================Checking With Two Objects=======================================================
    @Test
    public void createMoodAnalyzerObjectThroughFactoryClass_IfTwoObjectEqual_TestWillPass() throws Exception {
        MoodAnalyzer mood1 = MoodAnalyzerReflector.createMood("i am sad");
        MoodAnalyzer mood2 = new MoodAnalyzer("i am sad");
        Assert.assertTrue(mood2.like(mood1));
    }
//=========================================Reflection With Default Constructor============================================================

    @Test
    public void createMoodAnalyzeObjectThroughFactoryParaClass_IfMatchesValues_TestWillPass() throws Exception {
        MoodAnalyzer mooder = (MoodAnalyzer) MoodAnalyzerReflector.createMoodInvoke();
        String mood = mooder.analyzeMood("sad");
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void createMoodAnalyzeForNonParaCheck_IfTwoObjectEqual_TestWillPass() throws Exception {
        MoodAnalyzer mooder = (MoodAnalyzer) MoodAnalyzerReflector.createMoodInvoke();
        String obj1 = mooder.analyzeMood("sad");
        MoodAnalyzer mood2 = new MoodAnalyzer("i am sad");
        String obj2 = mood2.analyzeMood();
        Assert.assertEquals(obj1, obj2);
    }

    @Test
    public void giveWrongConstructor_HandleException_TestWillNotPass() throws Exception {
        try {
            MoodAnalyzer mooder = (MoodAnalyzer) MoodAnalyzerReflector.createMoodInvoke();
            String mood = mooder.analyzeMood(" ");
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyzerException e) {

        }
    }
    //=========================Method Invoke======================================================
    @Test
    public void usingReflector_InvokeMethodCall_ShouldReturnHappy() throws Exception {
        MoodAnalyzer mooder = (MoodAnalyzer) MoodAnalyzerReflector.createMoodInvoke();
        Assert.assertEquals("SAD",  mooder.analyzeMood("sad"));
    }

    @Test
    public void usingReflector_InvokeMethodIfParameterNotRight_ShouldHandleException() {
        try {
            MoodAnalyzer mooder = (MoodAnalyzer) MoodAnalyzerReflector.createMoodInvoke();
            Assert.assertEquals("SAD", mooder.analyzeMood(""));
        } catch (MoodAnalyzerException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
