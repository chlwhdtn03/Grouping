package com.chlwhdtn.grouping.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chlwhdtn.grouping.R;
import com.google.android.material.snackbar.Snackbar;

public class MessageBox {

    public static void show(View v, String text, MessageType type) {
        LayoutInflater inflater = LayoutInflater.from(v.getContext());
        View snackView = inflater.inflate(R.layout.messagebox, null, false);

        ImageView img = snackView.findViewById(R.id.popup_img);
        TextView tv = snackView.findViewById(R.id.popup_text);

        switch(type) {
            case WARNING: img.setImageDrawable(v.getContext().getDrawable(R.drawable.ic_warning)); break;
            case DONE: img.setImageDrawable(v.getContext().getDrawable(R.drawable.ic_done)); break;
            case ERROR: img.setImageDrawable(v.getContext().getDrawable(R.drawable.ic_error)); break;
        }

        tv.setText(text);

        Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();

        layout.setForegroundGravity(Gravity.TOP);
        layout.setPadding(0,0,0,0);
        layout.addView(snackView, 0);
        snackbar.show();

    }

}
