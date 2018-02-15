package com.artursfer.testmaxmilhas.model.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("/api/search/")
    Call<ResultBody> searchFlight(@Query("app_id") String appId,
                                  @Query("app_key") String appKey,
                                  @Query("source") String source,
                                  @Query("destination") String destination,
                                  @Query("dateofdeparture") String departureDate,
                                  @Query("dateofarrival") String arrivalDate,
                                  @Query("adults") int adults,
                                  @Query("children") int children,
                                  @Query("infants") int infants,
                                  @Query("counter") int counter,
                                  @Query("seatingclass") String seatingclass);

}
