package com.artursfer.testmaxmilhas.util;

import android.support.v4.app.FragmentManager;

import java.text.DateFormatSymbols;

/**
 * Created by artur on 14/02/2018.
 */

public class Util {

    static ProgressFragment progressFragment;

    public static void createProgress(FragmentManager fm) {

        progressFragment = ProgressFragment.newInstance();
        progressFragment.show(fm, "progress_fragment");
    }

    public static void hideProgress() {
        if (progressFragment != null) {
            progressFragment.dismiss();
            progressFragment = null;
        }
    }

    public static String getWeekDayByNumber(int num) {
        return new DateFormatSymbols().getWeekdays()[num];
    }

    public static String getMonthByNumber(int num) {
        return new DateFormatSymbols().getMonths()[num];
    }

}
