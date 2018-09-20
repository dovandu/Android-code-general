package vn.com.famtech.driverorderinmaps.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import vn.com.famtech.driverorderinmaps.interfacea.OnRecyclerViewItemClickListener;

/**
 * Created by GIAVI on 6/14/2017.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        init(itemView);
    }

    public abstract void init(View view);

    public abstract void showDataOnView(Object data, int index);

    public abstract void showDataSetClickItem(int index, OnRecyclerViewItemClickListener listener);


}
