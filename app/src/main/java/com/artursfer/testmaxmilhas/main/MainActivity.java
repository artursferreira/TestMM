package com.artursfer.testmaxmilhas.main;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Pair;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.artursfer.testmaxmilhas.R;
import com.artursfer.testmaxmilhas.flights.FlightsActivity;
import com.artursfer.testmaxmilhas.model.remote.ResultBody;
import com.artursfer.testmaxmilhas.util.Util;
import com.irozon.sneaker.Sneaker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {


    @BindView(R.id.origin_edit_text)
    EditText originEditText;
    @BindView(R.id.destination_edit_text)
    EditText destinationEditText;
    @BindView(R.id.departure_date_text_view)
    TextView departureDateTextView;
    @BindView(R.id.departure_card_view)
    CardView departureCardView;
    @BindView(R.id.return_date_text_view)
    TextView returnDateTextView;
    @BindView(R.id.return_card_view)
    CardView returnCardView;
    @BindView(R.id.passengers_edit_text)
    EditText passengersEditText;
    @BindView(R.id.btn_search)
    RelativeLayout btnSearch;

    MainPresenter presenter;
    String departureDate, returnDate;
    @BindView(R.id.appbar)
    AppBarLayout appBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new MainPresenterImp(this);

    }

    @OnClick({R.id.departure_card_view, R.id.return_card_view, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.departure_card_view:
                selectDate(departureDateTextView);
                break;
            case R.id.return_card_view:
                selectDate(returnDateTextView);
                break;
            case R.id.btn_search:
                presenter.searchFlight(getResources().getString(R.string.app_id),
                        getResources().getString(R.string.app_key),
                        originEditText.getText().toString(),
                        destinationEditText.getText().toString(),
                        departureDate,
                        returnDate,
                        passengersEditText.getText().toString());
                break;
        }
    }

    public void selectDate(final TextView textView) {
        final Calendar c = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                textView.setTextColor(Color.BLACK);
                textView.setText(DateFormat.format("dd/MM/yy", calendar));

                if (textView == departureDateTextView)
                    departureDate = DateFormat.format("yyyyMMdd", calendar).toString();
                if (textView == returnDateTextView)
                    returnDate = DateFormat.format("yyyyMMdd", calendar).toString();

            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    @Override
    public void showProgress() {
        Util.createProgress(getSupportFragmentManager());
    }

    @Override
    public void hideProgress() {
        Util.hideProgress();
    }

    @Override
    public void error(String title, String message) {
        Sneaker.with(this)
                .setTitle(title)
                .setMessage(message)
                .sneakError();
    }

    @Override
    public void success(ResultBody resultBody) {
        Intent intent = new Intent(MainActivity.this, FlightsActivity.class);
        intent.putExtra("flightList", resultBody);
        if (Build.VERSION.SDK_INT >= 21) {
            List<Pair<View, String>> pairs = new ArrayList<>();
            pairs.add(Pair.create((View) appBar, appBar.getTransitionName()));
            pairs.add(Pair.create((View) btnSearch, btnSearch.getTransitionName()));

            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this, pairs.toArray(new Pair[pairs.size()]));
            startActivity(intent, activityOptions.toBundle());
        } else
            startActivity(intent);
    }
}
