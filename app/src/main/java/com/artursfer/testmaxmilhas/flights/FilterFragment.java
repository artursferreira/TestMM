package com.artursfer.testmaxmilhas.flights;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.artursfer.testmaxmilhas.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FilterFragment extends DialogFragment {
    OnItemSelectedListener mCallback;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    String selectedPosition;

    // Container Activity must implement this interface
    public interface OnItemSelectedListener {
        public void onItemSelected(String position);
    }

    @BindView(R.id.btn_filter)
    RelativeLayout btnFilter;
    Unbinder unbinder;

    public FilterFragment() {

    }

    public static FilterFragment newInstance() {
        FilterFragment frag = new FilterFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_filter, container);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton checkedRadioButton = (RadioButton) view.findViewById(i);
                selectedPosition = checkedRadioButton.getText().toString();
            }
        });

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onItemSelected(selectedPosition);
                dismiss();
            }
        });

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}