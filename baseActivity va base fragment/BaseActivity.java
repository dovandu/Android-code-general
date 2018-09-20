package vn.com.famtech.driverorderinmaps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class BaseActivity extends AppCompatActivity {

    View progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void replaceFragment(Fragment fragment,Toolbar toolbar, String title) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fmContent, fragment);
        transaction.commit();
        toolbar.setTitle(title);
    }

    public void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fmContent, fragment);
        transaction.commit();
    }


    public void showLoadingBar() {
        if (progress != null)
            progress.setVisibility(View.VISIBLE);
    }


    public void hideLoadingBar() {
        if (progress != null)
            progress.setVisibility(View.GONE);
    }

}
