package com.bridgelabz.moodanalyzer.main;

import com.bridgelabz.moodanalyzer.exception.MoodAnalyzerException;
import com.bridgelabz.moodanalyzer.service.MoodAnalyzerReflector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    //=========================================Default Constructor ============================================================
    @Deprecated
    @Test
    public void checkTwoObjectEqual_IfTwoObjectEqualOfDefaultConstructor_TestWillPass() throws Exception {
        MoodAnalyzer moodbyreflection = (MoodAnalyzer) MoodAnalyzerReflector.createMoodInvoke("com.bridgelabz.moodanalyzer.main.MoodAnalyzer", "analyzeMood", "i am sad", "object", "nonpara");
        MoodAnalyzer moodbyanalyzer = new MoodAnalyzer("i am sad");
        Assert.assertTrue(moodbyreflection.like(moodbyanalyzer));
    }

    @Deprecated
    @Test
    public void givenClass_NotCorrecct_ShouldHandleExceptionShouldfail() throws Exception {
        String moodbyreflection = (String) MoodAnalyzerReflector.createMoodInvoke("com.bridgelabz.moodanalyzer.main.ThisisIncorrectClassName", "analyzeMood", "i am sad", "string", "nonpara");
        Assert.assertEquals("SAD", moodbyreflection);
    }

    @Deprecated
    @Test
    public void givenMethodName_NotCorrecct_ShouldHandleExceptionShouldFail() throws Exception {
        String moodbyreflection = (String) MoodAnalyzerReflector.createMoodInvoke("com.bridgelabz.moodanalyzer.main.MoodAnalyzer", "methodnameincorrect", "i am sad", "string", "nonpara");
        Assert.assertEquals("SAD", moodbyreflection);
    }

    //===========================================Default Parameterized ========================================================
    @Deprecated
    @Test
    public void checkTwoObjectEqual_IfTwoObjectEqualofParameterized_TestWillPass() throws Exception {
        MoodAnalyzer moodbyreflection = (MoodAnalyzer) MoodAnalyzerReflector.createMoodInvoke("com.bridgelabz.moodanalyzer.main.MoodAnalyzer", "analyzeMood", "i am sad", "object", "para");
        MoodAnalyzer moodbyanalyzer = new MoodAnalyzer("i am sad");
        Assert.assertTrue(moodbyreflection.like(moodbyanalyzer));
    }

    @Deprecated
    @Test
    public void givenclassNameImproper_ofParameterized_ShouldTestFail() throws Exception {
        String moodbyreflection = (String) MoodAnalyzerReflector.createMoodInvoke("com.bridgelabz.moodanalyzer.main.WrongclassName", "analyzeMood", "i am sad", "string", "para");
        Assert.assertEquals("SAD", moodbyreflection);
    }

    @Deprecated
    @Test
    public void givenMethodNameImproper_ofParameterized_ShouldTestFail() throws Exception {
        String moodbyreflection = (String) MoodAnalyzerReflector.createMoodInvoke("com.bridgelabz.moodanalyzer.main.MoodAnalyzer", "WrongMethodNAme", "i am sad", "string", "para");
        Assert.assertEquals("SAD", moodbyreflection);

    }
    @Deprecated
    @Test
    public void givenAllProper_ofParameterized_ShouldTestCoreect() throws Exception {
        String moodbyreflection = (String) MoodAnalyzerReflector.createMoodInvoke("com.bridgelabz.moodanalyzer.main.MoodAnalyzer", "analyzeMood", "i am sad", "string", "para");
        Assert.assertEquals("SAD", moodbyreflection);

    }
}
