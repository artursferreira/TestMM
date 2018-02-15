
package com.artursfer.testmaxmilhas.model.remote;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data implements Parcelable {

    @SerializedName("IsOAGMultiAirline")
    @Expose
    private boolean isOAGMultiAirline;
    @SerializedName("returnflights")
    @Expose
    private List<Flight> returnflights = null;
    @SerializedName("onwardflights")
    @Expose
    private List<Flight> onwardflights = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param isOAGMultiAirline
     * @param returnflights
     * @param onwardflights
     */
    public Data(boolean isOAGMultiAirline, List<Flight> returnflights, List<Flight> onwardflights) {
        super();
        this.isOAGMultiAirline = isOAGMultiAirline;
        this.returnflights = returnflights;
        this.onwardflights = onwardflights;
    }

    public boolean isIsOAGMultiAirline() {
        return isOAGMultiAirline;
    }

    public void setIsOAGMultiAirline(boolean isOAGMultiAirline) {
        this.isOAGMultiAirline = isOAGMultiAirline;
    }

    public List<Flight> getReturnflights() {
        return returnflights;
    }

    public void setReturnflights(List<Flight> returnflights) {
        this.returnflights = returnflights;
    }

    public List<Flight> getOnwardflights() {
        return onwardflights;
    }

    public void setOnwardflights(List<Flight> onwardflights) {
        this.onwardflights = onwardflights;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.isOAGMultiAirline ? (byte) 1 : (byte) 0);
        dest.writeList(this.returnflights);
        dest.writeList(this.onwardflights);
    }

    protected Data(Parcel in) {
        this.isOAGMultiAirline = in.readByte() != 0;
        this.returnflights = new ArrayList<Flight>();
        in.readList(this.returnflights, Flight.class.getClassLoader());
        this.onwardflights = new ArrayList<Flight>();
        in.readList(this.onwardflights, Flight.class.getClassLoader());
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
