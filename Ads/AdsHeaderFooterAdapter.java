package com.famtech.coinmarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.famtech.coinmarket.R;
import com.famtech.coinmarket.support.OnRecyclerViewItemClickListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.List;

/**
 * Created by dovan on 10/16/2017.
 */

public abstract class AdsHeaderFooterAdapter extends BaseAdapter {

    private String mIdAdsHeader;
    private String mIdAdsFooter;
    private BaseViewHolder mHeaderHolder;
    private BaseViewHolder mFooterHolder;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;

    public AdsHeaderFooterAdapter(Context context, List list) {
        super(context, list);
    }

    public AdsHeaderFooterAdapter(Context context, List list, String idAdsHeader, String idAdsFooter) {
        super(context, list, true, true);
        this.mIdAdsHeader = idAdsHeader;
        this.mIdAdsFooter = idAdsFooter;

    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView;
        if(viewType == TYPE_HEADER) {
            rowView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ads_header, parent, false);
//            View v = inflater.inflate (R.layout.item_ads_header, parent, false);
            mHeaderHolder = new HeaderViewHolder(rowView, mIdAdsHeader);
            return mHeaderHolder;
        } else if(viewType == TYPE_FOOTER) {
            rowView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ads_footer, parent, false);
//            View v = inflater.inflate (R.layout.item_ads_footer, parent, false);
            mFooterHolder = new FooterViewHolder(rowView, mIdAdsFooter);
            return mFooterHolder;
        } else if(viewType == TYPE_ITEM) {
            return super.onCreateViewHolder(parent, viewType);
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (!(holder instanceof FooterViewHolder) && !(holder instanceof HeaderViewHolder)){
            super.onBindViewHolder(holder, position);
        }
    }

    @Override
    public int getItemViewType (int position) {
        if(isPositionHeader (position)) {
            return TYPE_HEADER;
        } else if(isPositionFooter (position)) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader (int position) {
        return position == 0;
    }

    private boolean isPositionFooter (int position) {
        return position == getItemCount() - 1;
    }

    public void onPause() {
        if (mFooterHolder != null)
            mFooterHolder.onPause();

        if (mHeaderHolder != null)
            mHeaderHolder.onPause();

    }

    public void onResume() {
        if (mFooterHolder != null)
            mFooterHolder.onResume();

        if (mHeaderHolder != null)
            mHeaderHolder.onResume();
    }

    public void onDestroy() {
        if (mFooterHolder != null)
            mFooterHolder.onDestroy();

        if (mHeaderHolder != null)
            mHeaderHolder.onDestroy();
    }


    /******************************* FOOTER VIEW HOLDER *********************/
   public class FooterViewHolder extends BaseViewHolder {
        private AdView mAdsBannerFooter;

        public FooterViewHolder (View itemView, String mUnitID) {
            super (itemView);
            View adContainer = itemView.findViewById(R.id.adMobView);

            mAdsBannerFooter = new AdView(context);
            mAdsBannerFooter.setAdSize(AdSize.BANNER);
            mAdsBannerFooter.setAdUnitId(mUnitID);
            ((RelativeLayout)adContainer).addView(mAdsBannerFooter);
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice("9C0B8A183C74F361EF072DF6371FCE69")
                    .build();
            mAdsBannerFooter.loadAd(adRequest);
        }

        @Override
        public void showDataOnView(Object data, int index) {
        }

        @Override
        public void showDataSetClickItem(int index, OnRecyclerViewItemClickListener listener) {

        }

        public void onPause() {
            if (mAdsBannerFooter != null) {
                mAdsBannerFooter.pause();
            }
        }

        public void onResume() {
            if (mAdsBannerFooter != null) {
                mAdsBannerFooter.resume();
            }
        }

        public void onDestroy() {
            if (mAdsBannerFooter != null) {
                mAdsBannerFooter.destroy();
            }
        }

    }

    /*******************************HEADER VIEW HOLDER *********************/

    private class HeaderViewHolder extends BaseViewHolder {

        private AdView mAdsBannerHeader;

        public HeaderViewHolder (View itemView, String mUnitId) {
            super (itemView);
            View adContainer = itemView.findViewById(R.id.adMobView);

            mAdsBannerHeader = new AdView(context);
            mAdsBannerHeader.setAdSize(AdSize.BANNER);
            mAdsBannerHeader.setAdUnitId(mUnitId);
            ((RelativeLayout)adContainer).addView(mAdsBannerHeader);
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .addTestDevice("9C0B8A183C74F361EF072DF6371FCE69")
                    .build();
            mAdsBannerHeader.loadAd(adRequest);
        }

        @Override
        public void showDataOnView(Object data, int index) {
        }

        @Override
        public void showDataSetClickItem(int index, OnRecyclerViewItemClickListener listener) {

        }

        public void onPause() {
            if (mAdsBannerHeader != null) {
                mAdsBannerHeader.pause();
            }
        }

        public void onResume() {
            if (mAdsBannerHeader != null) {
                mAdsBannerHeader.resume();
            }
        }

        public void onDestroy() {
            if (mAdsBannerHeader != null) {
                mAdsBannerHeader.destroy();
            }
        }
    }

}
