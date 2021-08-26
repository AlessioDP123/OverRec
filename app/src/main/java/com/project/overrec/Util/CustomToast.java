package com.project.overrec.Util;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.project.overrec.R;

public class CustomToast extends Toast {
    public CustomToast(Context context) {
        super(context);
    }

    public static void showToast(Context context, String text){
        Toast toast = new Toast(context);
        View layout = LayoutInflater.from(context).inflate(R.layout.custom_toast,null);
        ((TextView)layout.findViewById(R.id.customToastText)).setText(text);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void showErrorToast(Context context, String text){
        Toast toast = new Toast(context);
        View layout = LayoutInflater.from(context).inflate(R.layout.custom_toast,null);
        ((TextView)layout.findViewById(R.id.customToastText)).setText(text);
        ((LinearLayout) layout.findViewById(R.id.customToastLayout)).setBackground(ContextCompat.getDrawable(context, R.drawable.custom_toast_background_error));
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}
