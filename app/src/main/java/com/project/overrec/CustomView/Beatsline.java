package com.project.overrec.CustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

i
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.project.overrec.R;
import com.project.overrec.SessionManager;

/**
 * linea dei battiti
 */
public class Beatsline extends View {

    private Timebars lines;
    private SessionManager session;
    private Paint linesColor, blue, controlBarColor;

    public Beatsline(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        linesColor = new Paint(Paint.ANTI_ALIAS_FLAG);
        linesColor.setColor(ResourcesCompat.getColor(getResources(), R.color.SecondBackground, null));
        linesColor.setStyle(Paint.Style.FILL);
        blue = new Paint(Paint.ANTI_ALIAS_FLAG);
        blue = new Paint(Paint.ANTI_ALIAS_FLAG);
        blue.setColor(ResourcesCompat.getColor(getResources(), R.color.Player, null));
        blue.setStyle(Paint.Style.FILL);
        blue.setStrokeWidth(4);
        controlBarColor = new Paint(Paint.ANTI_ALIAS_FLAG);
        controlBarColor.setColor(ResourcesCompat.getColor(getResources(), R.color.Rec, null));
        controlBarColor.setStyle(Paint.Style.FILL);
        controlBarColor.setAlpha(150);
    }

    @Override
    protected void onDraw(Canvas c) {
        if(session != null) {
            c.drawRect(0, 0, getWidth(), 4, linesColor);
            lines.drawBeat(c, getWidth(), 35, 25);
            float PBpos = session.fromSamplesIndexToViewIndex(session.getPlayBarPos(), getWidth());
            c.drawLine(PBpos, getHeight(), PBpos, 0, blue);
            int CBpos = session.fromSamplesIndexToViewIndex(session.getRecBarPos(), getWidth());
            c.drawRoundRect(CBpos - 30, 0, CBpos + 30, getHeight(), 20, 20, controlBarColor);
        }
    }

    public void setSession(SessionManager session) {
        this.session = session;
        lines = new Timebars(this.getContext(), session, true, 3, 1);
    }
}
