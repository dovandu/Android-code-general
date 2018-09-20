package vn.com.giavi.phatgiao.dialogfragment;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.com.giavi.phatgiao.R;


public class BaseDialogFragment extends DialogFragment {

    public BaseDialogFragment() {
        // Required empty public constructor
    }

    @VisibleForTesting
    public ProgressDialog mProgressDialog;
    protected View v;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (v == null) return;
        Log.d("fragment", "onViewCreated");
    }

   /* public void callFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fmContent, fragment);
        transaction.commit();
    }*/

    public void showDialogFragment(DialogFragment dialogFragment) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Dialog);
        dialogFragment.show(ft, "dialog");
    }

    public void showDalogFragmentFull(DialogFragment dialogFragment) {
        try {
            FragmentManager fm = getFragmentManager();
            dialogFragment.setRetainInstance(true);
            dialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_NoActionBar);
            dialogFragment.show(fm, "fragment_name");
        } catch (ClassCastException e) {
        }

    }

    protected void initToolBar(View view, String title) {
        ImageView im_back = (ImageView) view.findViewById(R.id.im_back);
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(title);
    }

   /* public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getContext());
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }*/

    /*public void showDialog(String title, String content){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                getContext());

        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder
                .setMessage(content)
                .setCancelable(false)
                .setPositiveButton(getResources().getString(R.string.yes),new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity

                    }
                })
                .setNegativeButton(getResources().getString(R.string.no),new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.dismiss();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }*/

    public String replaceSpecialCharter(String content) {
        String result = content;
        if (content != null) {
            result = result.replaceAll("[-+.^:,]", "");
        }
        return result;
    }




}
