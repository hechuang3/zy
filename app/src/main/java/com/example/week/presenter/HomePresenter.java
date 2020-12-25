package com.example.week.presenter;

import com.example.week.base.BasePresenter;
import com.example.week.contract.HomeContract;
import com.example.week.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeContract.IMainView,HomeContract.IMainModel> implements HomeContract.IMainPresenter {

    @Override
    public HomeContract.IMainModel getiModel() {
        return new HomeModel(this);
    }
}
