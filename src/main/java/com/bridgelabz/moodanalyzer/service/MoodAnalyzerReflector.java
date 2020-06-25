package com.bridgelabz.moodanalyzer.service;

import com.bridgelabz.moodanalyzer.exception.MoodAnalyzerException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParametersException;
import java.lang.reflect.Method;

public class MoodAnalyzerReflector {
    /**
     * Code in if Condition for the parameterized or code in else condition for non parameterized constructor
     *
     * @param className
     * @param methodName
     * @param message
     * @param whichReturnType
     * @param whichConstructor
     * @return
     * @throws Exception
     */
    @Deprecated
    public static Object createMoodInvoke(String className, String methodName, String message, String whichReturnType, String whichConstructor) throws MalformedParametersException{
        if (whichConstructor == "para") {
            try {
                Object moodinreflect = Class.forName(className).getConstructor(String.class).newInstance(message);
                Method method = moodinreflect.getClass().getMethod(methodName);
                Object mood = method.invoke(moodinreflect);
                if (whichReturnType == "string") {
                    return mood;
                } else {
                    return moodinreflect;
                }

            }
            catch (MalformedParametersException | ClassNotFoundException | NoSuchMethodException e) {

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } else {

            Object moodinreflect = null;
            try {
                moodinreflect = Class.forName(className).newInstance();
                Method method = moodinreflect.getClass().getMethod(methodName);
                Object mood = method.invoke(moodinreflect, message);

                if (whichReturnType == "string") {
                    return mood;
                } else {
                    return moodinreflect;
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


        }
        return null;
    }

}
