package com.artursfer.testmaxmilhas.flights;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.artursfer.testmaxmilhas.R;
import com.artursfer.testmaxmilhas.model.remote.Flight;
import com.artursfer.testmaxmilhas.model.remote.ResultBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.Body;

public class FlightsActivity extends AppCompatActivity implements FilterFragment.OnItemSelectedListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    FlightsAdapter flightsAdapter;
    @BindView(R.id.btn_filter)
    RelativeLayout btnFilter;
    @BindView(R.id.btn_sort)
    RelativeLayout btnSort;

    private ResultBody resultBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Drawable drawable = toolbar.getNavigationIcon();
        if (drawable != null)
            drawable.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryLight), PorterDuff.Mode.SRC_ATOP);

        resultBody = getIntent().getParcelableExtra("flightList");

        if (resultBody != null) {
            flightsAdapter = new FlightsAdapter(this, new ArrayList<Flight>());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(flightsAdapter);
            flightsAdapter.addAll(resultBody.getData().getOnwardflights());
        }

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFrag = new FilterFragment();
                dialogFrag.show(getSupportFragmentManager(), "dialog");
            }
        });

        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resultBody != null)
                    sortListByPrice(flightsAdapter.getItems());
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sortListByPrice(List<Flight> flights) {
        if (flights != null) {
            List<Flight> sortedFlights = new ArrayList<>();
            sortedFlights.addAll(flights);

            Collections.sort(sortedFlights, new Comparator<Flight>() {
                @Override
                public int compare(Flight o1, Flight o2) {
                    if (o1.getFare().getTotalfare() < o2.getFare().getTotalfare())
                        return -1;
                    if (o1.getFare().getTotalfare() > o2.getFare().getTotalfare())
                        return 1;

                    return 0;
                }
            });

            flightsAdapter.clear();
            flightsAdapter.addAll(sortedFlights);
            flightsAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemSelected(String text) {

        if (resultBody != null) {
            List<Flight> filteredFlights = new ArrayList<>();

            if (text.length() == 0) {
                filteredFlights.addAll(resultBody.getData().getOnwardflights());
            } else {
                final String filterPattern = text.toLowerCase().trim();
                for (Flight item : resultBody.getData().getOnwardflights()) {
                    if (item.getAirline().toLowerCase().contains(filterPattern)) {
                        filteredFlights.add(item);
                    }
                }
            }

            flightsAdapter.clear();
            flightsAdapter.addAll(filteredFlights);
            flightsAdapter.notifyDataSetChanged();

        }
    }
}
