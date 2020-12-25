package com.example.week.contract;


import com.example.week.base.BaseModel;
import com.example.week.base.BaseView;
import com.example.week.bean.Bean;
import com.example.week.net.CallBackinterface;

public class HomeContract {
    public interface IMainView extends BaseView {

        void onSuccess(Bean bean);

    }
    public interface IMainPresenter{


        void getData();
    }
    public interface IMainModel extends BaseModel {
        <T>void getLoginData(String newlist, CallBackinterface<T> beanCallBackinterface);
    }
}
