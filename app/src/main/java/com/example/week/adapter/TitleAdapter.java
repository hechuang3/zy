package com.example.week.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.week.R;

public class TitleAdapter extends DelegateAdapter.Adapter {
    private String title;
    private SingleLayoutHelper singleLayoutHelper;

    public TitleAdapter(String title, SingleLayoutHelper singleLayoutHelper) {
        this.title = title;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title, parent, false);
        return new TitleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TitleHolder titleHolder= (TitleHolder) holder;
        titleHolder.tv.setText(title);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class TitleHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public TitleHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.single_title_tv);
        }
    }
}
