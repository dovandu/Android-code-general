package vn.com.famtech.driverorderinmaps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import vn.com.famtech.driverorderinmaps.interfacea.OnRecyclerViewItemClickListener;

/**
 * Created by GIAVI on 6/14/2017.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    Context context;
    List list;


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
            holder.showDataOnView(list.get(position), position);
            holder.showDataSetClickItem( position, listener );
        }

    }

    public abstract  BaseViewHolder getViewHolder(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    private OnRecyclerViewItemClickListener listener;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener)
    {
        this.listener = listener;
    }



}
