package com.artursfer.testmaxmilhas.main;

import com.artursfer.testmaxmilhas.model.remote.ResultBody;

public class MainPresenterImp implements MainPresenter, MainInteractor.onFinishedListener {
    // region Members
    private MainView view;
    private MainInteractor interactor;

    // endregion Members

    // region constructors
    public MainPresenterImp(MainView view) {
        this.view = view;
        interactor = new MainInteractorImp(this);
    }

    // endregion constructors

    // region Methods

    @Override
    public void searchFlight(String appId, String appKey, String source, String destination, String departureDate, String arrivalDate, String adults) {
        if (source == null || source.isEmpty()) {
            view.error("Origem", "O campo é obrigatório");
            return;
        } else if (destination == null || destination.isEmpty()) {
            view.error("Destino", "O campo é obrigatório");
            return;
        } else if (departureDate == null || departureDate.isEmpty()) {
            view.error("Data da ida", "O campo é obrigatório");
            return;
        } else if (adults == null || adults.isEmpty()) {
            view.error("Quantidade de passageiros", "O campo é obrigatório");
            return;
        } else {
            view.showProgress();
            interactor.searchFlight(appId, appKey, source, destination, departureDate, arrivalDate, adults, this);
        }
    }

    @Override
    public void error(String title, String message) {
        view.hideProgress();
        view.error(title, message);
    }

    @Override
    public void success(ResultBody resultBody) {
        view.hideProgress();
        view.success(resultBody);
    }

    // endregion Methods
}
