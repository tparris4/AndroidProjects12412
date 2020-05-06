package com.example.classorganizer;

public class ClassSche {


    private String mText;
    private long mclassTime;
    private String mclassName;

    public ClassSche() {}

    public ClassSche(String text, long classTime, String className){
        mText = text;
        mclassTime = classTime;
        mclassName = className;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public void setMclassTime(long mclassTime) {
        this.mclassTime = mclassTime;
    }

    public void setMclassName(String mclassName) {
        this.mclassName = mclassName;
    }
}
