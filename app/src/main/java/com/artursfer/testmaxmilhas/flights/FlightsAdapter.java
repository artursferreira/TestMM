package com.artursfer.testmaxmilhas.flights;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artursfer.testmaxmilhas.R;
import com.artursfer.testmaxmilhas.model.remote.Flight;
import com.artursfer.testmaxmilhas.util.Util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FlightsAdapter extends RecyclerView.Adapter<FlightsAdapter.MViewHolder> {
    private final List<Flight> flightList;
    private final Context context;

    public FlightsAdapter(Context context, List<Flight> flightList) {
        this.flightList = flightList;
        this.context = context;
    }

    public void addAll(List<Flight> newFlightList) {
        int startindex = flightList.size();

        flightList.addAll(startindex, newFlightList);
        notifyItemRangeInserted(startindex, newFlightList.size());
    }

    public void addAllThatChanged(List<Flight> newFlightList) {
        int added = 0;
        for (Flight object : newFlightList) {
            boolean isEqual = false;
            for (Flight object2 : flightList) {
                if (object2.equals(object)) {
                    isEqual = true;
                    break;
                }
            }
            if (!isEqual) {
                flightList.add(object);
                added++;
            }
        }
        if (added != 0) {
            notifyDataSetChanged();
        }
    }


    public void clear() {
        int size = flightList.size();
        flightList.clear();
        notifyItemRangeRemoved(0, size);
    }

    public List<Flight> getItems(){
        List<Flight> sortedFlights = new ArrayList<>(flightList);
        return sortedFlights;
    }

    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.flight_item, parent, false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, int position) {
        final Flight flight = flightList.get(position);

        holder.company.setText(flight.getAirline());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd't'hhmm");
        try {
            Date parsed = dateFormat.parse(flight.getDepdate());
            Calendar c = Calendar.getInstance();
            c.setTime(parsed);
            holder.dateTextView.setText(String.format("%s, %d de %s", Util.getWeekDayByNumber(c.get(Calendar.DAY_OF_WEEK)), c.get(Calendar.DAY_OF_MONTH), Util.getMonthByNumber(c.get(Calendar.MONTH))));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.departureTime.setText(flight.getDeptime());
        holder.duration.setText(flight.getDuration());
        holder.arrivalTime.setText(flight.getArrtime());

        holder.flightNumber.setText(flight.getFlightno());
        holder.airportDeparture.setText(flight.getOrigin());

        if (flight.getStops().isEmpty())
            holder.flightType.setText("VOÔ DIRETO");
        else if (Integer.valueOf(flight.getStops()) == 1)
            holder.flightType.setText("1 PARADA");
        else if (Integer.valueOf(flight.getStops()) == 2)
            holder.flightType.setText("2 PARADAS");

        if (flight.getOnwardflights() != null && !flight.getOnwardflights().isEmpty()) {
            holder.btnBuy.setVisibility(View.GONE);
            InnerFlightsAdapter flightsAdapter = new InnerFlightsAdapter(context, flight.getOnwardflights());
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
            holder.recyclerView.setItemAnimator(new DefaultItemAnimator());
            holder.recyclerView.setAdapter(flightsAdapter);
            holder.recyclerView.setVisibility(View.VISIBLE);
        } else {
            holder.btnBuy.setVisibility(View.VISIBLE);
            holder.recyclerView.setVisibility(View.GONE);
        }

        holder.airportArrival.setText(flight.getDestination());
        DecimalFormat df = new DecimalFormat("#.##");

        holder.btnText.setText(String.format("Comprar $%s", df.format(flight.getFare().getTotalfare()/100)));
    }

    @Override
    public int getItemCount() {
        if (this.flightList != null)
            return this.flightList.size();
        return 0;
    }

    class MViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView;
        TextView company;
        TextView departureTime;
        TextView duration;
        TextView arrivalTime;
        TextView flightNumber;
        TextView airportDeparture;
        TextView flightType;
        TextView airportArrival;
        ViewGroup btnBuy;
        TextView btnText;
        RecyclerView recyclerView;

        public MViewHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.date_text_view);
            company = itemView.findViewById(R.id.company);
            departureTime = itemView.findViewById(R.id.departure_time);
            duration = itemView.findViewById(R.id.duration);
            arrivalTime = itemView.findViewById(R.id.arrival_time);
            flightNumber = itemView.findViewById(R.id.flight_number);
            airportDeparture = itemView.findViewById(R.id.airport_departure);
            flightType = itemView.findViewById(R.id.flight_type);
            airportArrival = itemView.findViewById(R.id.airport_arrival);
            btnBuy = itemView.findViewById(R.id.btn_buy);
            btnText = itemView.findViewById(R.id.btn_text);
            recyclerView = itemView.findViewById(R.id.recycler_view);
        }

    }
}
