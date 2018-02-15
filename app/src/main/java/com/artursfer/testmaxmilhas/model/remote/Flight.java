
package com.artursfer.testmaxmilhas.model.remote;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Flight implements Parcelable {

    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("DepartureTime")
    @Expose
    private String departureTime;
    @SerializedName("flightcode")
    @Expose
    private String flightcode;
    @SerializedName("Group")
    @Expose
    private String group;
    @SerializedName("farebasis")
    @Expose
    private String farebasis;
    @SerializedName("depterminal")
    @Expose
    private String depterminal;
    @SerializedName("holdflag")
    @Expose
    private String holdflag;
    @SerializedName("CINFO")
    @Expose
    private String cINFO;
    @SerializedName("deptime")
    @Expose
    private String deptime;
    @SerializedName("codeshare")
    @Expose
    private String codeshare;
    @SerializedName("ibibopartner")
    @Expose
    private String ibibopartner;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("platingcarrier")
    @Expose
    private String platingcarrier;
    @SerializedName("qtype")
    @Expose
    private String qtype;
    @SerializedName("arrterminal")
    @Expose
    private String arrterminal;
    @SerializedName("flightno")
    @Expose
    private String flightno;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("FlHash")
    @Expose
    private String flHash;
    @SerializedName("stops")
    @Expose
    private String stops;
    @SerializedName("seatsavailable")
    @Expose
    private String seatsavailable;
    @SerializedName("carrierid")
    @Expose
    private String carrierid;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("refundable")
    @Expose
    private String refundable;
    @SerializedName("PromotionId")
    @Expose
    private String promotionId;
    @SerializedName("fare")
    @Expose
    private Fare fare;
    @SerializedName("CabinClass")
    @Expose
    private String cabinClass;
    @SerializedName("warnings")
    @Expose
    private String warnings;
    @SerializedName("ArrivalTime")
    @Expose
    private String arrivalTime;
    @SerializedName("onwardflights")
    @Expose
    private List<Flight> onwardflights = null;
    @SerializedName("aircraftType")
    @Expose
    private String aircraftType;
    @SerializedName("seatingclass")
    @Expose
    private String seatingclass;
    @SerializedName("operatingcarrier")
    @Expose
    private String operatingcarrier;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("internationalsearch")
    @Expose
    private String internationalsearch;
    @SerializedName("splitduration")
    @Expose
    private String splitduration;
    @SerializedName("AvailabilityDisplayType")
    @Expose
    private String availabilityDisplayType;
    @SerializedName("searchKey")
    @Expose
    private String searchKey;
    @SerializedName("bookingclass")
    @Expose
    private String bookingclass;
    @SerializedName("airline")
    @Expose
    private String airline;
    @SerializedName("multicitysearch")
    @Expose
    private String multicitysearch;
    @SerializedName("depdate")
    @Expose
    private String depdate;
    @SerializedName("arrtime")
    @Expose
    private String arrtime;
    @SerializedName("arrdate")
    @Expose
    private String arrdate;
    @SerializedName("TravelTime")
    @Expose
    private String travelTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Flight() {
    }

    /**
     * 
     * @param travelTime
     * @param refundable
     * @param fare
     * @param platingcarrier
     * @param promotionId
     * @param stops
     * @param arrtime
     * @param seatingclass
     * @param src
     * @param operatingcarrier
     * @param warnings
     * @param arrterminal
     * @param airline
     * @param cabinClass
     * @param arrdate
     * @param depdate
     * @param cINFO
     * @param aircraftType
     * @param searchKey
     * @param flHash
     * @param departureTime
     * @param origin
     * @param seatsavailable
     * @param qtype
     * @param provider
     * @param internationalsearch
     * @param farebasis
     * @param multicitysearch
     * @param destination
     * @param depterminal
     * @param duration
     * @param arrivalTime
     * @param codeshare
     * @param splitduration
     * @param ibibopartner
     * @param deptime
     * @param holdflag
     * @param flightcode
     * @param bookingclass
     * @param rating
     * @param availabilityDisplayType
     * @param group
     * @param carrierid
     * @param flightno
     * @param onwardflights
     */
    public Flight(String origin, int rating, String departureTime, String flightcode, String group, String farebasis, String depterminal, String holdflag, String cINFO, String deptime, String codeshare, String ibibopartner, String duration, String platingcarrier, String qtype, String arrterminal, String flightno, String destination, String flHash, String stops, String seatsavailable, String carrierid, String provider, String refundable, String promotionId, Fare fare, String cabinClass, String warnings, String arrivalTime, List<Flight> onwardflights, String aircraftType, String seatingclass, String operatingcarrier, String src, String internationalsearch, String splitduration, String availabilityDisplayType, String searchKey, String bookingclass, String airline, String multicitysearch, String depdate, String arrtime, String arrdate, String travelTime) {
        super();
        this.origin = origin;
        this.rating = rating;
        this.departureTime = departureTime;
        this.flightcode = flightcode;
        this.group = group;
        this.farebasis = farebasis;
        this.depterminal = depterminal;
        this.holdflag = holdflag;
        this.cINFO = cINFO;
        this.deptime = deptime;
        this.codeshare = codeshare;
        this.ibibopartner = ibibopartner;
        this.duration = duration;
        this.platingcarrier = platingcarrier;
        this.qtype = qtype;
        this.arrterminal = arrterminal;
        this.flightno = flightno;
        this.destination = destination;
        this.flHash = flHash;
        this.stops = stops;
        this.seatsavailable = seatsavailable;
        this.carrierid = carrierid;
        this.provider = provider;
        this.refundable = refundable;
        this.promotionId = promotionId;
        this.fare = fare;
        this.cabinClass = cabinClass;
        this.warnings = warnings;
        this.arrivalTime = arrivalTime;
        this.onwardflights = onwardflights;
        this.aircraftType = aircraftType;
        this.seatingclass = seatingclass;
        this.operatingcarrier = operatingcarrier;
        this.src = src;
        this.internationalsearch = internationalsearch;
        this.splitduration = splitduration;
        this.availabilityDisplayType = availabilityDisplayType;
        this.searchKey = searchKey;
        this.bookingclass = bookingclass;
        this.airline = airline;
        this.multicitysearch = multicitysearch;
        this.depdate = depdate;
        this.arrtime = arrtime;
        this.arrdate = arrdate;
        this.travelTime = travelTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightcode() {
        return flightcode;
    }

    public void setFlightcode(String flightcode) {
        this.flightcode = flightcode;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFarebasis() {
        return farebasis;
    }

    public void setFarebasis(String farebasis) {
        this.farebasis = farebasis;
    }

    public String getDepterminal() {
        return depterminal;
    }

    public void setDepterminal(String depterminal) {
        this.depterminal = depterminal;
    }

    public String getHoldflag() {
        return holdflag;
    }

    public void setHoldflag(String holdflag) {
        this.holdflag = holdflag;
    }

    public String getCINFO() {
        return cINFO;
    }

    public void setCINFO(String cINFO) {
        this.cINFO = cINFO;
    }

    public String getDeptime() {
        return deptime;
    }

    public void setDeptime(String deptime) {
        this.deptime = deptime;
    }

    public String getCodeshare() {
        return codeshare;
    }

    public void setCodeshare(String codeshare) {
        this.codeshare = codeshare;
    }

    public String getIbibopartner() {
        return ibibopartner;
    }

    public void setIbibopartner(String ibibopartner) {
        this.ibibopartner = ibibopartner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPlatingcarrier() {
        return platingcarrier;
    }

    public void setPlatingcarrier(String platingcarrier) {
        this.platingcarrier = platingcarrier;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public String getArrterminal() {
        return arrterminal;
    }

    public void setArrterminal(String arrterminal) {
        this.arrterminal = arrterminal;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlHash() {
        return flHash;
    }

    public void setFlHash(String flHash) {
        this.flHash = flHash;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getSeatsavailable() {
        return seatsavailable;
    }

    public void setSeatsavailable(String seatsavailable) {
        this.seatsavailable = seatsavailable;
    }

    public String getCarrierid() {
        return carrierid;
    }

    public void setCarrierid(String carrierid) {
        this.carrierid = carrierid;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getRefundable() {
        return refundable;
    }

    public void setRefundable(String refundable) {
        this.refundable = refundable;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Flight> getOnwardflights() {
        return onwardflights;
    }

    public void setOnwardflights(List<Flight> onwardflights) {
        this.onwardflights = onwardflights;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getSeatingclass() {
        return seatingclass;
    }

    public void setSeatingclass(String seatingclass) {
        this.seatingclass = seatingclass;
    }

    public String getOperatingcarrier() {
        return operatingcarrier;
    }

    public void setOperatingcarrier(String operatingcarrier) {
        this.operatingcarrier = operatingcarrier;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getInternationalsearch() {
        return internationalsearch;
    }

    public void setInternationalsearch(String internationalsearch) {
        this.internationalsearch = internationalsearch;
    }

    public String getSplitduration() {
        return splitduration;
    }

    public void setSplitduration(String splitduration) {
        this.splitduration = splitduration;
    }

    public String getAvailabilityDisplayType() {
        return availabilityDisplayType;
    }

    public void setAvailabilityDisplayType(String availabilityDisplayType) {
        this.availabilityDisplayType = availabilityDisplayType;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getBookingclass() {
        return bookingclass;
    }

    public void setBookingclass(String bookingclass) {
        this.bookingclass = bookingclass;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getMulticitysearch() {
        return multicitysearch;
    }

    public void setMulticitysearch(String multicitysearch) {
        this.multicitysearch = multicitysearch;
    }

    public String getDepdate() {
        return depdate;
    }

    public void setDepdate(String depdate) {
        this.depdate = depdate;
    }

    public String getArrtime() {
        return arrtime;
    }

    public void setArrtime(String arrtime) {
        this.arrtime = arrtime;
    }

    public String getArrdate() {
        return arrdate;
    }

    public void setArrdate(String arrdate) {
        this.arrdate = arrdate;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.origin);
        dest.writeInt(this.rating);
        dest.writeString(this.departureTime);
        dest.writeString(this.flightcode);
        dest.writeString(this.group);
        dest.writeString(this.farebasis);
        dest.writeString(this.depterminal);
        dest.writeString(this.holdflag);
        dest.writeString(this.cINFO);
        dest.writeString(this.deptime);
        dest.writeString(this.codeshare);
        dest.writeString(this.ibibopartner);
        dest.writeString(this.duration);
        dest.writeString(this.platingcarrier);
        dest.writeString(this.qtype);
        dest.writeString(this.arrterminal);
        dest.writeString(this.flightno);
        dest.writeString(this.destination);
        dest.writeString(this.flHash);
        dest.writeString(this.stops);
        dest.writeString(this.seatsavailable);
        dest.writeString(this.carrierid);
        dest.writeString(this.provider);
        dest.writeString(this.refundable);
        dest.writeString(this.promotionId);
        dest.writeParcelable(this.fare, flags);
        dest.writeString(this.cabinClass);
        dest.writeString(this.warnings);
        dest.writeString(this.arrivalTime);
        dest.writeList(this.onwardflights);
        dest.writeString(this.aircraftType);
        dest.writeString(this.seatingclass);
        dest.writeString(this.operatingcarrier);
        dest.writeString(this.src);
        dest.writeString(this.internationalsearch);
        dest.writeString(this.splitduration);
        dest.writeString(this.availabilityDisplayType);
        dest.writeString(this.searchKey);
        dest.writeString(this.bookingclass);
        dest.writeString(this.airline);
        dest.writeString(this.multicitysearch);
        dest.writeString(this.depdate);
        dest.writeString(this.arrtime);
        dest.writeString(this.arrdate);
        dest.writeString(this.travelTime);
    }

    protected Flight(Parcel in) {
        this.origin = in.readString();
        this.rating = in.readInt();
        this.departureTime = in.readString();
        this.flightcode = in.readString();
        this.group = in.readString();
        this.farebasis = in.readString();
        this.depterminal = in.readString();
        this.holdflag = in.readString();
        this.cINFO = in.readString();
        this.deptime = in.readString();
        this.codeshare = in.readString();
        this.ibibopartner = in.readString();
        this.duration = in.readString();
        this.platingcarrier = in.readString();
        this.qtype = in.readString();
        this.arrterminal = in.readString();
        this.flightno = in.readString();
        this.destination = in.readString();
        this.flHash = in.readString();
        this.stops = in.readString();
        this.seatsavailable = in.readString();
        this.carrierid = in.readString();
        this.provider = in.readString();
        this.refundable = in.readString();
        this.promotionId = in.readString();
        this.fare = in.readParcelable(Fare.class.getClassLoader());
        this.cabinClass = in.readString();
        this.warnings = in.readString();
        this.arrivalTime = in.readString();
        this.onwardflights = new ArrayList<>();
        in.readList(this.onwardflights, Flight.class.getClassLoader());
        this.aircraftType = in.readString();
        this.seatingclass = in.readString();
        this.operatingcarrier = in.readString();
        this.src = in.readString();
        this.internationalsearch = in.readString();
        this.splitduration = in.readString();
        this.availabilityDisplayType = in.readString();
        this.searchKey = in.readString();
        this.bookingclass = in.readString();
        this.airline = in.readString();
        this.multicitysearch = in.readString();
        this.depdate = in.readString();
        this.arrtime = in.readString();
        this.arrdate = in.readString();
        this.travelTime = in.readString();
    }

    public static final Parcelable.Creator<Flight> CREATOR = new Parcelable.Creator<Flight>() {
        @Override
        public Flight createFromParcel(Parcel source) {
            return new Flight(source);
        }

        @Override
        public Flight[] newArray(int size) {
            return new Flight[size];
        }
    };
}
