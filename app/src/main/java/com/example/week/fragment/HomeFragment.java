package com.example.week.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.week.R;
import com.example.week.adapter.SingleAdapter;
import com.example.week.adapter.SingleTwoAdapter;
import com.example.week.base.BaseActivity;
import com.example.week.base.BaseFragment;
import com.example.week.bean.Bean;
import com.example.week.contract.HomeContract;
import com.example.week.presenter.HomePresenter;

import java.util.ArrayList;


public class HomeFragment extends BaseFragment<HomePresenter>implements HomeContract.IMainView {


    private RecyclerView rel;
    private ArrayList<Bean.DataDTO.BannerDTO> dtos;
    private SingleTwoAdapter singleTwoAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    @Override
    protected void initView(View inflate) {
        rel = inflate.findViewById(R.id.home_rel);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        rel.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0,10);

        //第一行
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(12);// 设置设置布局内每行布局的宽与高的比
        //第一行适配器
        SingleAdapter singleAdapter = new SingleAdapter(singleLayoutHelper);
        //第二行
        //banner图片集合
        dtos = new ArrayList<>();
        SingleLayoutHelper helper = new SingleLayoutHelper();
        singleTwoAdapter = new SingleTwoAdapter(dtos, helper);
        //设置适配器
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(singleAdapter);
        delegateAdapter.addAdapter(singleTwoAdapter);
        rel.setLayoutManager(virtualLayoutManager);
        rel.setAdapter(delegateAdapter);
    }

    @Override
    protected void initData() {
        per.getData();
    }

    @Override
    public HomePresenter getPer() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSuccess(Bean bean) {
        dtos.addAll(bean.getData().getBanner());
       // Toast.makeText(getContext(), dtos.get(0).getImage_url().toString(), Toast.LENGTH_SHORT).show();
        singleTwoAdapter.notifyDataSetChanged();
    }
}