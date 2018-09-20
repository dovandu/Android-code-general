package vn.com.famtech.driverorderinmaps.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import vn.com.famtech.driverorderinmaps.R;

public class BaseFragment extends Fragment {

    public BaseFragment() {
        // Required empty public constructor
    }

    protected View progress;
    protected View v;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (v == null) return;
        Log.d("fragment", "onViewCreated");
    }

    public void callFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fmContent, fragment);
        transaction.commit();
    }


    public void hindeProgress() {
        if (progress == null) return;
        progress.setVisibility(View.GONE);
    }

    public void showProgress() {
        if (progress == null) return;
        progress.setVisibility(View.VISIBLE);
    }


}
