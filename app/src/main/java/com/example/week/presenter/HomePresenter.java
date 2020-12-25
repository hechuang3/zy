package com.example.week.presenter;

import com.example.week.base.BasePresenter;
import com.example.week.bean.Bean;
import com.example.week.contract.HomeContract;
import com.example.week.model.HomeModel;
import com.example.week.net.CallBackinterface;
import com.example.week.net.URLConstant;


public class HomePresenter extends BasePresenter<HomeContract.IMainView,HomeContract.IMainModel> implements HomeContract.IMainPresenter {

    @Override
    public HomeContract.IMainModel getiModel() {
        return new HomeModel(this);
    }

    @Override
    public void getData() {
        iModel.getLoginData(URLConstant.NEWLIST, new CallBackinterface<Bean>() {
            @Override
            public void onSuccess(Bean bean) {
                iView.onSuccess(bean);
            }

            @Override
            public void onFail(String s) {

            }
        });
    }

}
