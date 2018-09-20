package com.famtech.coinmarket.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.famtech.coinmarket.support.OnRecyclerViewItemClickListener;

import java.util.List;


/**
 * Created by GIAVI on 6/14/2017.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder>  {

    Context context;
    List list;
    private boolean mWithHeader;
    private boolean mWithFooter;

    public BaseAdapter(Context context, List list, boolean mWithHeader, boolean mWithFooter) {
        this.context = context;
        this.list = list;
        this.mWithHeader = mWithHeader;
        this.mWithFooter = mWithFooter;
    }

    public BaseAdapter(Context context, List list) {

        this.context = context;
        this.list = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        if(holder!=null){
            holder.showDataOnView(getItem(position), getPosition(position));
            holder.showDataSetClickItem(getPosition(position), listener );
        }
    }

    private int getPosition (int position){
        return mWithHeader ? position -1 : position;
    }

    private Object getItem(int position) {
        return mWithHeader ? list.get(position - 1) : list.get(position);
    }

    public abstract  BaseViewHolder getViewHolder(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        if (list!=null){
            int itemCount = list.size();
            if (mWithHeader)
                itemCount++;
            if (mWithFooter)
                itemCount++;
            return itemCount;
        }
        return 0;
    }

    private OnRecyclerViewItemClickListener listener;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    public void updateListItems(List items) {}
}
