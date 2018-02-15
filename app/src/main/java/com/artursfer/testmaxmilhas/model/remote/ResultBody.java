
package com.artursfer.testmaxmilhas.model.remote;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultBody implements Parcelable {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("data_length")
    @Expose
    private int dataLength;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResultBody() {
    }

    /**
     * 
     * @param data
     * @param dataLength
     */
    public ResultBody(Data data, int dataLength) {
        super();
        this.data = data;
        this.dataLength = dataLength;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
        dest.writeInt(this.dataLength);
    }

    protected ResultBody(Parcel in) {
        this.data = in.readParcelable(Data.class.getClassLoader());
        this.dataLength = in.readInt();
    }

    public static final Parcelable.Creator<ResultBody> CREATOR = new Parcelable.Creator<ResultBody>() {
        @Override
        public ResultBody createFromParcel(Parcel source) {
            return new ResultBody(source);
        }

        @Override
        public ResultBody[] newArray(int size) {
            return new ResultBody[size];
        }
    };
}
