package com.artursfer.testmaxmilhas.application;

import android.content.Context;

import com.artursfer.testmaxmilhas.model.remote.ApiGoibibo;
import com.artursfer.testmaxmilhas.model.remote.ApiInterface;

public class Application extends android.app.Application {

    // region Members
    private static Context appContext;
    private static ApiInterface apiService;

    private static String appId = "170ERDDB3OP5WIDIBFGIDS345LVT64NHNA3WETO";
    private String server = "https://dell-agent-api.herokuapp.com/use/";


    // endregion Members

    // region Acessors

    public static ApiInterface getApiService() {
        return apiService;
    }

    public static String getAppId() {
        return appId;
    }

    public static Context getAppContext() {
        return appContext;
    }
    // endRegion Acessors

    // region Lifecycle Methods

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;

        apiService = ApiGoibibo.getConnection().create(ApiInterface.class);

     //   JodaTimeAndroid.init(this);


    }

    // endregion Lifecyle Methods


}
