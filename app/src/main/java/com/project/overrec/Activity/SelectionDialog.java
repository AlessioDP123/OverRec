package com.project.overrec.Activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.project.overrec.R;
import com.project.overrec.SessionManager;

public class SelectionDialog extends Dialog {
    private SessionManager session;
    OnDeleteListener deleteListener;

    public SelectionDialog(@NonNull Context context, SessionManager session) {
        super(context);
        this.session = session;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_dialog);
        final CheckBox checkBoxSawTheEnds = findViewById(R.id.checkBox_sew_the_ends);

        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(deleteListener != null)
                    deleteListener.onDelete(checkBoxSawTheEnds.isChecked());
                dismiss();
            }
        });
    }

    public void setOnDeleteListener(OnDeleteListener listener){
        deleteListener = listener;
    }

    public interface OnDeleteListener{
        void onDelete(boolean sewTheEnds);
    }

}
