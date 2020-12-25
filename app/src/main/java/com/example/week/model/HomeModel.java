package com.example.week.model;

import com.example.week.contract.HomeContract;
import com.example.week.presenter.HomePresenter;

public class HomeModel implements HomeContract.IMainModel {

    private HomeContract.IMainPresenter homePresenter;

    public HomeModel(HomeContract.IMainPresenter homePresenter) {

        this.homePresenter = homePresenter;
    }
}
