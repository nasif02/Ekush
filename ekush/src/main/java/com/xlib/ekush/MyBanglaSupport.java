package com.xlib.ekush;

/**
 * Ekush Bangla Support Library
 * version 1.0
 *
 * @author Xplo
 * two class from bls library
 * This library provide you clear bangla support for android
 * This library is speacially for ICS device
 */

import java.util.Locale;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;

public class MyBanglaSupport {


    /**
     * get SpannableString
     * @param text
     * @return SpannableString
     */
    public static SpannableString getBanglaSpnString(String text) {

        SpannableString spnText = null;

        if (isDeviceSupportBangla()) {
            spnText = new SpannableString(text);  //your device support Bangla
        } else {

            spnText = new SpannableString(getBanglaUTFByBlsLibrary(text));

        }

        return spnText;

    }


    /**
     * get SpannableString
     * @param text
     * @param tf
     * @return SpannableString
     */

    public static SpannableString getBanglaSpnString(String text, Typeface tf) {

        SpannableString spnText = null;

        if (isDeviceSupportBangla()) {
            spnText = new SpannableString(text);
        } else {

            spnText = new SpannableString(getBanglaUTFByBlsLibrary(text));

        }

        TypefaceSpan span = new TypefaceSpan(tf);

        spnText.setSpan(span, 0, spnText.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spnText;

    }

    /**
     * get SpannableString
     * @param text
     * @param tf
     * @param size
     * @return SpannableString
     */

    public static SpannableString getBanglaSpnString(String text, Typeface tf,
                                                     float size) {

        SpannableString spnText = null;

        if (isDeviceSupportBangla()) {
            spnText = new SpannableString(text);
        } else {

            spnText = new SpannableString(getBanglaUTFByBlsLibrary(text));

        }

        TypefaceSpan span = new TypefaceSpan(tf);

        spnText.setSpan(span, 0, spnText.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        if (size >= 0) {
            spnText.setSpan(new RelativeSizeSpan(size), 0, spnText.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return spnText;

    }

    public static String getBanglaString(String text) {

        String conText = null;

        if (isDeviceSupportBangla()) {
            conText = text;
        } else {
            conText = getBanglaUTFByBlsLibrary(text);
        }

        return conText;
    }

    /**
     * get utf representation from bls library
     * @param text
     * @return String
     */

    private static String getBanglaUTFByBlsLibrary(String text) {

        String conText = null;

        if (text.equals(null)) {
            text = "";
        }
        GSUB.text = text.toCharArray();
        GSUB.newlength = text.length();

        int ll = 0, ret = 2;

        while ((ret = GSUB.mygsub(GSUB.newlength)) == 2 && ll < 10) {
        }
        text = new String(GSUB.text, 0, GSUB.newlength);
        text = new String(Shape.reorder(text.toCharArray()));

        conText = text;
        return conText;
    }

    /**
     * Checks if the device has native bangla support. true if supported.
     * @return Boolean
     */
    public static boolean isDeviceSupportBangla() {

        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return true;
        }

        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {

            // any possible bangla support
            if (locale.getDisplayName().toLowerCase().contains("bengali")
                    || locale.getDisplayCountry().toLowerCase().contains("bn")
                    || locale.getDisplayName().toLowerCase().contains("bangla")) {
                return true;
            }
        }
        return false;
    }

}
