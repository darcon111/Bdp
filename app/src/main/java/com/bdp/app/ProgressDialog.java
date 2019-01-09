package com.bdp.app;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;

public class ProgressDialog {

    private Activity activity;
    private Dialog dialog;

    public ProgressDialog(Activity activity) {
        this.activity = activity;
    }

    public void hideDialog(){
        dialog.dismiss();
    }

    public void showDialog() {

        dialog  = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.progressdialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        dialog.show();
    }


}
