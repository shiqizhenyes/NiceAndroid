package me.nice.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdpter<T> extends RecyclerView.Adapter<BaseViewHolder> {


    private List<T> dataList;

    private int itemLayoutId;


    public BaseAdpter( List<T> dataList, int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
        this.dataList = dataList;
    }

    public BaseAdpter(int itemLayoutId, List<T> dataList) {
        this.itemLayoutId = itemLayoutId;
        this.dataList = dataList;
    }


    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }


    abstract void cover(BaseViewHolder holder, T item, int poison);


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayoutId, viewGroup,false);
        return new BaseViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        cover(baseViewHolder, dataList.get(i) ,i);
    }


    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }


}
