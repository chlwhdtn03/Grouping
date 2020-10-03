package com.chlwhdtn.grouping.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chlwhdtn.grouping.R;

public class MessageBox {

    public static void show(Context context, String text, MessageType type) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.messagebox, null, false);

        ImageView img = v.findViewById(R.id.popup_img);
        TextView tv = v.findViewById(R.id.popup_text);

        switch(type) {
            case WARNING: img.setImageDrawable(context.getDrawable(R.drawable.ic_warning)); break;
            case DONE: img.setImageDrawable(context.getDrawable(R.drawable.ic_done)); break;
            case ERROR: img.setImageDrawable(context.getDrawable(R.drawable.ic_error)); break;
        }

        tv.setText(text);

        Toast t = new Toast(context);
        t.setView(v);
        t.setDuration(t.LENGTH_LONG);
        t.show();


    }

}
