package com.example.classorganizer;

public class ClassHW {

    private String mText;
    private String mclassName;
    private String mclassAssign;

    public ClassHW(){}

    public ClassHW(String text, String className, String classAssign){
        mText = text;
        mclassName = className;
        mclassAssign = classAssign;

    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String getClassName() {
        return mclassName;
    }

    public void setClassName(String className) {
        this.mclassName = className;
    }

    public String getClassAssign() {
        return mclassAssign;
    }

    public void setClassAssign(String classAssign) {
        this.mclassAssign = classAssign;
    }

}
