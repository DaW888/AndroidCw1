package com.szkola.dw.cw1.Helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class PreviewText extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text;
    Integer colour;
    public PreviewText(Context context, Typeface tf, String _text, Integer _color) {
        super(context);
        text = _text;
        colour = _color;
        paint.reset();
        paint.setAntiAlias(true);
        paint.setTextSize(90);
        paint.setTypeface(tf);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(colour);
        canvas.drawText(text, 0, 70, paint);
    }
}
