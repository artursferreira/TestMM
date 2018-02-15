package com.artursfer.testmaxmilhas.main;

import com.artursfer.testmaxmilhas.model.remote.ResultBody;

public interface MainView {

    void showProgress();
    void hideProgress();

    void error(String title, String message);
    void success(ResultBody resultBody);
}
