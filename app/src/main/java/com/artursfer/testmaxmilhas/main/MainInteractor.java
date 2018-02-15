package com.artursfer.testmaxmilhas.main;

import com.artursfer.testmaxmilhas.model.remote.ResultBody;

/**
 * Created by luiz on 21/11/17.
 */

public interface MainInteractor {
    void searchFlight(String appId, String appKey, String source, String destination, String departureDate, String arrivalDate, String adults, final onFinishedListener listener);

    interface onFinishedListener {
        void error(String title, String message);

        void success(ResultBody resultBody);
    }
}
