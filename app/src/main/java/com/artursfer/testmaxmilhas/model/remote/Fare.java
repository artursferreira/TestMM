
package com.artursfer.testmaxmilhas.model.remote;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fare implements Parcelable {

    @SerializedName("grossamount")
    @Expose
    private int grossamount;
    @SerializedName("totalbasefare")
    @Expose
    private int totalbasefare;
    @SerializedName("adultbasefare")
    @Expose
    private int adultbasefare;
    @SerializedName("totalfare")
    @Expose
    private int totalfare;
    @SerializedName("totalsurcharge")
    @Expose
    private int totalsurcharge;
    @SerializedName("adulttotalfare")
    @Expose
    private int adulttotalfare;
    @SerializedName("totalcommission")
    @Expose
    private int totalcommission;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fare() {
    }

    /**
     * 
     * @param totalfare
     * @param adulttotalfare
     * @param totalbasefare
     * @param grossamount
     * @param totalcommission
     * @param totalsurcharge
     * @param adultbasefare
     */
    public Fare(int grossamount, int totalbasefare, int adultbasefare, int totalfare, int totalsurcharge, int adulttotalfare, int totalcommission) {
        super();
        this.grossamount = grossamount;
        this.totalbasefare = totalbasefare;
        this.adultbasefare = adultbasefare;
        this.totalfare = totalfare;
        this.totalsurcharge = totalsurcharge;
        this.adulttotalfare = adulttotalfare;
        this.totalcommission = totalcommission;
    }

    public int getGrossamount() {
        return grossamount;
    }

    public void setGrossamount(int grossamount) {
        this.grossamount = grossamount;
    }

    public int getTotalbasefare() {
        return totalbasefare;
    }

    public void setTotalbasefare(int totalbasefare) {
        this.totalbasefare = totalbasefare;
    }

    public int getAdultbasefare() {
        return adultbasefare;
    }

    public void setAdultbasefare(int adultbasefare) {
        this.adultbasefare = adultbasefare;
    }

    public int getTotalfare() {
        return totalfare;
    }

    public void setTotalfare(int totalfare) {
        this.totalfare = totalfare;
    }

    public int getTotalsurcharge() {
        return totalsurcharge;
    }

    public void setTotalsurcharge(int totalsurcharge) {
        this.totalsurcharge = totalsurcharge;
    }

    public int getAdulttotalfare() {
        return adulttotalfare;
    }

    public void setAdulttotalfare(int adulttotalfare) {
        this.adulttotalfare = adulttotalfare;
    }

    public int getTotalcommission() {
        return totalcommission;
    }

    public void setTotalcommission(int totalcommission) {
        this.totalcommission = totalcommission;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.grossamount);
        dest.writeInt(this.totalbasefare);
        dest.writeInt(this.adultbasefare);
        dest.writeInt(this.totalfare);
        dest.writeInt(this.totalsurcharge);
        dest.writeInt(this.adulttotalfare);
        dest.writeInt(this.totalcommission);
    }

    protected Fare(Parcel in) {
        this.grossamount = in.readInt();
        this.totalbasefare = in.readInt();
        this.adultbasefare = in.readInt();
        this.totalfare = in.readInt();
        this.totalsurcharge = in.readInt();
        this.adulttotalfare = in.readInt();
        this.totalcommission = in.readInt();
    }

    public static final Parcelable.Creator<Fare> CREATOR = new Parcelable.Creator<Fare>() {
        @Override
        public Fare createFromParcel(Parcel source) {
            return new Fare(source);
        }

        @Override
        public Fare[] newArray(int size) {
            return new Fare[size];
        }
    };
}
