package vn.com.famtech.driverorderinmaps.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by GIAVI on 7/14/2016.
 */
public abstract class BasePagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public BasePagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {

        return  getTabPosition(position);
    }

    @Override
    public int getCount() {
        if (mNumOfTabs!=0){
            return mNumOfTabs;
        }
        return 0;
    }

    protected abstract Fragment getTabPosition(int position);

}
