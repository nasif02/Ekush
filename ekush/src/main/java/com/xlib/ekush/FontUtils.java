package com.xlib.ekush;

import android.content.Context;
import android.graphics.Typeface;

public class FontUtils {

    public static Typeface getTypeface(Context context){

        return Typeface.createFromAsset(context.getAssets(),"solaimanlipinormal.ttf");

    }

    public static Typeface getTypeface(Context context, String fontName){

        return Typeface.createFromAsset(context.getAssets(),fontName);

    }


}
