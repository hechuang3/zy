package com.example.week.model;

import com.example.week.bean.Bean;
import com.example.week.contract.HomeContract;
import com.example.week.net.CallBackinterface;
import com.example.week.net.RetrofitUtils;
import com.example.week.presenter.HomePresenter;

public class HomeModel implements HomeContract.IMainModel {

    private HomeContract.IMainPresenter homePresenter;

    public HomeModel(HomeContract.IMainPresenter homePresenter) {

        this.homePresenter = homePresenter;
    }


    @Override
    public <T> void getLoginData(String newlist, CallBackinterface<T> beanCallBackinterface) {
        RetrofitUtils.getInstance().getLogin(newlist,beanCallBackinterface);
    }
}
