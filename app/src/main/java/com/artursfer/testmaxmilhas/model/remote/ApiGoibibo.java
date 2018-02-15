package com.artursfer.testmaxmilhas.model.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiGoibibo {

    private static String server = "https://developer.goibibo.com/";

    private static Retrofit retrofit = null;

    public static Retrofit getConnection() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(server)
                    .addConverterFactory(GsonConverterFactory.create())
                 /*   .addConverterFactory(GsonConverterFactory.create(SerializeToJson.getGson()))*/
                    .build();
        }
        return retrofit;
    }
}
