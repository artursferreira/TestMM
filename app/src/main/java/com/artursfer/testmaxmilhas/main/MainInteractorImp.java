package com.artursfer.testmaxmilhas.main;

import com.artursfer.testmaxmilhas.application.Application;
import com.artursfer.testmaxmilhas.model.remote.ResultBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by luiz on 21/11/17.
 */

public class MainInteractorImp implements MainInteractor {
    // region Members
    private MainPresenter presenter;
    // endregion Members

    // region constructors
    public MainInteractorImp(MainPresenter presenter) {
        this.presenter = presenter;
    }
    // endregion constructors

    // region Methods

    @Override
    public void searchFlight(String appId, String appKey, String source, String destination, String departureDate, String arrivalDate, String adults, final onFinishedListener listener) {
        Call<ResultBody> call = Application.getApiService().searchFlight(appId,
                appKey,
                source,
                destination,
                departureDate,
                arrivalDate,
                Integer.valueOf(adults), //only adults are being considered
                0,
                0,
                100, //only domestic flights
                "E"); //economy class

        call.enqueue(new Callback<ResultBody>() {
            @Override
            public void onResponse(Call<ResultBody> call, Response<ResultBody> response) {
                if (response != null)
                    if (response.isSuccessful()
                            && response.body().getData().getOnwardflights() != null
                            && response.body().getData().getReturnflights() != null) {
                        listener.success(response.body());
                    } else
                        listener.error("Erro", "Não foi possível encontrar voôs");
            }

            @Override
            public void onFailure(Call<ResultBody> call, Throwable t) {
                listener.error("Erro", "Não foi possível encontrar voôs");
            }
        });

    }


    // endRegion Methods
}
