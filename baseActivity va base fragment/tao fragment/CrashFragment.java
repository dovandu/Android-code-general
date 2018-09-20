package vn.com.famtech.driverorderinmaps.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class CrashFragment extends Fragment implements View.OnClickListener {

    public CrashFragment() {
        // Required empty public constructor
    }

    View view;
    ImageView im_back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_crash, container, false);
        init();

        return view;
    }

    private void init() {
    }
	
	@Override
    public void onClick(View v) {
        switch (v.getId()){
            /*case R.id.btn:
                
                break;*/
        }
    }


}
