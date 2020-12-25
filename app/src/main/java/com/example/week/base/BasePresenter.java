package com.example.week.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    public V iView;
    public M iModel;
    public void attachView(V v){
        iView=v;
        iModel=getiModel();
    }
    public void detachView(){
        if(iView!=null){
            iView=null;
        }
        if(iModel!=null){
            iModel=null;
        }
    }
    public abstract M getiModel();
}
