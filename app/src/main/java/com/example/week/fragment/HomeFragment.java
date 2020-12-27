package com.example.week.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.week.R;
import com.example.week.adapter.FuAdapter;
import com.example.week.adapter.GridLayoutAdapter;
import com.example.week.adapter.GridLayoutSixAdapter;
import com.example.week.adapter.HorizontalAdapter;
import com.example.week.adapter.SingleAdapter;
import com.example.week.adapter.SingleFourAdapter;
import com.example.week.adapter.SingleSixAdapter;
import com.example.week.adapter.SingleThreeAdapter;
import com.example.week.adapter.SingleTwoAdapter;
import com.example.week.adapter.TitleAdapter;
import com.example.week.base.BaseFragment;
import com.example.week.bean.Bean;
import com.example.week.contract.HomeContract;
import com.example.week.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment<HomePresenter>implements HomeContract.IMainView {


    private RecyclerView rel;
    private ArrayList<Bean.DataDTO.BannerDTO> dtos;
    private SingleTwoAdapter singleTwoAdapter;
    private ArrayList<Bean.DataDTO.ChannelDTO> channelDTOS;
    private SingleThreeAdapter singleThreeAdapter;
    private ArrayList<Bean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private GridLayoutAdapter gridLayoutAdapter;
    private ArrayList<Bean.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
    private GridLayoutSixAdapter gridLayoutSixAdapter;
    private ArrayList<Bean.DataDTO.TopicListDTO> topicListDTOS;
    private HorizontalAdapter horizontalAdapter;
    private ArrayList<Bean.DataDTO.CategoryListDTO> goodsListDTOS;
    private FuAdapter fuAdapter;
    private DelegateAdapter delegateAdapter;


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
        //singleLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(12);// 设置设置布局内每行布局的宽与高的比
        //第一行适配器
        SingleAdapter singleAdapter = new SingleAdapter(singleLayoutHelper);
        //第二行
        //banner图片集合
        dtos = new ArrayList<>();
        SingleLayoutHelper helper = new SingleLayoutHelper();
        singleTwoAdapter = new SingleTwoAdapter(dtos, helper);
        //第三行
        channelDTOS = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //gridLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格
        singleThreeAdapter = new SingleThreeAdapter(channelDTOS, getContext(), gridLayoutHelper);

        //第四行
        SingleLayoutHelper singleFourHelper = new SingleLayoutHelper();
        SingleFourAdapter singleFourAdapter = new SingleFourAdapter(singleFourHelper);

        //第五行
        newGoodsListDTOS = new ArrayList<>();
        GridLayoutHelper FivegridLayoutHelper = new GridLayoutHelper(4);
        FivegridLayoutHelper.setItemCount(4);
        FivegridLayoutHelper.setPadding(20,20,20,20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        FivegridLayoutHelper.setMargin(20,20,20,20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        FivegridLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的
        // gridLayoutHelper特有属性（下面会详细说明）
        FivegridLayoutHelper.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        FivegridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        FivegridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        FivegridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        FivegridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        gridLayoutAdapter = new GridLayoutAdapter(newGoodsListDTOS,getContext(),FivegridLayoutHelper);

        //人气推荐
        SingleLayoutHelper SixsingleLayoutHelper = new SingleLayoutHelper();
        SingleSixAdapter singleSixAdapter = new SingleSixAdapter(SixsingleLayoutHelper);
        //第六行
        hotGoodsListDTOS = new ArrayList<>();
        GridLayoutHelper SixgridLayoutHelper = new GridLayoutHelper(3);
        SixgridLayoutHelper.setItemCount(3);
        SixgridLayoutHelper.setPadding(20,20,20,20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        SixgridLayoutHelper.setMargin(20,20,20,20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        //SixgridLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的
        // gridLayoutHelper特有属性（下面会详细说明）
        //SixgridLayoutHelper.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        SixgridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        SixgridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        SixgridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        SixgridLayoutHelper.setSpanCount(1);// 设置每行多少个网格
        gridLayoutSixAdapter = new GridLayoutSixAdapter(hotGoodsListDTOS, getContext(), SixgridLayoutHelper);




//第七行
        topicListDTOS = new ArrayList<>();
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        horizontalAdapter = new HorizontalAdapter(getContext(), linearLayoutHelper, topicListDTOS);




        //第八行
  //      GridLayoutHelper FivegridLayoutHelper = new GridLayoutHelper(4);
//        FivegridLayoutHelper.setItemCount(4);
//        FivegridLayoutHelper.setPadding(20,20,20,20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        FivegridLayoutHelper.setMargin(20,20,20,20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        FivegridLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的
//        // gridLayoutHelper特有属性（下面会详细说明）
//        FivegridLayoutHelper.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
//        FivegridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
//        FivegridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
//        FivegridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
//        FivegridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
//        gridLayoutAdapter = new GridLayoutAdapter(newGoodsListDTOS,getContext(),FivegridLayoutHelper);
        goodsListDTOS = new ArrayList<>();
//        GridLayoutHelper FugridLayoutHelper = new GridLayoutHelper(2);
//        FugridLayoutHelper.setItemCount(4);
//        FugridLayoutHelper.setPadding(20,20,20,20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        FugridLayoutHelper.setMargin(20,20,20,20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        FugridLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的
//        // gridLayoutHelper特有属性（下面会详细说明）
//        FugridLayoutHelper.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
//        FugridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
//        FugridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
//        //FugridLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
//        FugridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
//        FugridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
//        //fuAdapter = new FuAdapter(goodsListDTOS, getContext(), FugridLayoutHelper);

        //设置适配器
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        delegateAdapter.addAdapter(singleAdapter);
        delegateAdapter.addAdapter(singleTwoAdapter);
        delegateAdapter.addAdapter(singleThreeAdapter);
        delegateAdapter.addAdapter(singleFourAdapter);
        delegateAdapter.addAdapter(gridLayoutAdapter);
        delegateAdapter.addAdapter(singleSixAdapter);
        delegateAdapter.addAdapter(gridLayoutSixAdapter);
        delegateAdapter.addAdapter(initTitle("专题精选"));
        delegateAdapter.addAdapter(horizontalAdapter);
        //delegateAdapter.addAdapter(fuAdapter);


        rel.setLayoutManager(virtualLayoutManager);
        rel.setAdapter(delegateAdapter);
    }

    private DelegateAdapter.Adapter initTitle(String title) {

        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setBgColor(Color.WHITE);
        linearLayoutHelper.setMarginTop(20);
        TitleAdapter titleAdapter = new TitleAdapter(linearLayoutHelper,getContext(),title);
        return titleAdapter;
    }

    private DelegateAdapter.Adapter initCategory(List<Bean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList) {
        //每行个数
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        //公共属性
        //总共个数
        gridLayoutHelper.setItemCount(goodsList.size());
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        //子元素垂直间距
        gridLayoutHelper.setVGap(50);
        gridLayoutHelper.setHGap(20);
        //是否自动填充空白区域
        gridLayoutHelper.setAutoExpand(false);
        //每行多少网格
        gridLayoutHelper.setSpanCount(2);
        fuAdapter = new FuAdapter(goodsList, getContext(), gridLayoutHelper);
        return fuAdapter;
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
        channelDTOS.addAll(bean.getData().getChannel());
        newGoodsListDTOS.addAll(bean.getData().getNewGoodsList());
        hotGoodsListDTOS.addAll(bean.getData().getHotGoodsList());
        topicListDTOS.addAll(bean.getData().getTopicList());
        goodsListDTOS.addAll(bean.getData().getCategoryList());
        for (int i = 0; i <goodsListDTOS.size(); i++) {
            delegateAdapter.addAdapter(initTitle(goodsListDTOS.get(i).getName()));
            delegateAdapter.addAdapter(initCategory(goodsListDTOS.get(i).getGoodsList()));
        }
       // Toast.makeText(getContext(), dtos.get(0).getImage_url().toString(), Toast.LENGTH_SHORT).show();
        singleTwoAdapter.notifyDataSetChanged();
        singleThreeAdapter.notifyDataSetChanged();
        gridLayoutAdapter.notifyDataSetChanged();
        gridLayoutSixAdapter.notifyDataSetChanged();
        horizontalAdapter.notifyDataSetChanged();
       // fuAdapter.notifyDataSetChanged();
    }
}