package com.artursfer.testmaxmilhas.util;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artursfer.testmaxmilhas.R;


public class ProgressFragment extends DialogFragment {

    public ProgressFragment() {

    }

    public static ProgressFragment newInstance() {
        ProgressFragment frag = new ProgressFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new Dialog(getActivity(), getTheme()) {

            @Override
            public void onBackPressed() {

            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getDialog() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        return inflater.inflate(R.layout.fragment_progress, container);
    }


    @Override
    public void onResume() {
        super.onResume();
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        if (getDialog() != null)
            getDialog().getWindow().setLayout(width, height);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}