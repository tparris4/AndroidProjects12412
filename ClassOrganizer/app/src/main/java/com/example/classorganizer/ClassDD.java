package com.example.classorganizer;

public class ClassDD {


    private long mDueDate;
    private String mclassName;
    private String mclassAssign;

    public ClassDD(){}

    public ClassDD(String className, String classAssign, long DueDate){
        mDueDate = DueDate;
        mclassAssign = classAssign;
        mclassName = className;
    }


    public long getmDueDate() {
        return mDueDate;
    }

    public void setmDueDate(long mDueDate) {
        this.mDueDate = mDueDate;
    }

    public String getMclassName() {
        return mclassName;
    }

    public void setMclassName(String mclassName) {
        this.mclassName = mclassName;
    }

    public String getMclassAssign() {
        return mclassAssign;
    }

    public void setMclassAssign(String mclassAssign) {
        this.mclassAssign = mclassAssign;
    }

}
