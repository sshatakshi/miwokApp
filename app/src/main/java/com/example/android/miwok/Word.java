package com.example.android.miwok;

public class Word {

    /** Image ID associated with the word */
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    //Constant
    private static final int NO_IMAGE_PROVIDED = -1;

    //Constructor 1 to initialize the two translations
    public Word(String def, String miwok)
    {
        mDefaultTranslation = def;
        mMiwokTranslation = miwok;
    }

    //Constructor 2 to initialize two translations and the associated Image ID
    public Word(String def, String miwok, int imageID)
    {
        mDefaultTranslation = def;
        mMiwokTranslation = miwok;
        mImageResourceID = imageID;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceID() { return mImageResourceID; }

    public boolean hasImage() { return mImageResourceID != NO_IMAGE_PROVIDED; }
}
