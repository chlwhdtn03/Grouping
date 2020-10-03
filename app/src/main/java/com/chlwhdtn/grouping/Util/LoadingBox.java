package com.chlwhdtn.grouping.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chlwhdtn.grouping.R;

public class LoadingBox {

    private Context context;
    private String text;
    private AlertDialog dialog;

    public LoadingBox(Context context, String text) {
        this.context = context;
        this.text = text;
        makeLoading();
    }

    private void makeLoading() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.loadingbox, null);

        TextView tv = view.findViewById(R.id.loading_text);

        if(text != null) {
            tv.setText(text);
        }

        dialog = new AlertDialog.Builder(context)
                .setView(view)
                .create();
    }

    public void show() {
        dialog.show();
    }

    public void close() {
        if(dialog.isShowing())
            dialog.dismiss();
    }

}
