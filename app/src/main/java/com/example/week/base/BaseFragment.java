package com.example.week.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView{
    public P per;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutID(), container, false);
        if(per==null){
            per=getPer();
            per.attachView(this);

        }
        initData();
        initView(inflate);
        return inflate;
    }

    protected abstract void initView(View inflate);

    protected abstract void initData();

    public abstract P getPer();

    protected abstract int getLayoutID();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(per!=null){
            per.detachView();
        }
    }
}
