package com.zybooks.diabeticrunner;

public class Shoe {
    private final String mShoeDescription;
    private final int mMaximumMileage;

    public Shoe(String shoeDescription, int maximumMileage){
        mShoeDescription = shoeDescription;
        mMaximumMileage = maximumMileage;
    }

    public String GetDescription(){
        return mShoeDescription;
    }

    public int GetMaxMileage(){
        return mMaximumMileage;
    }

}
