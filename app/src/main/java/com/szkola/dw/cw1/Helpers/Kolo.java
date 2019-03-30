package com.szkola.dw.cw1.Helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Kolo extends View {
    public Kolo(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.argb(255, 100, 240, 255)); // lub paint.setColor(Color.RED); // przezroczystosc - 0
        canvas.drawCircle(250, 250, 200, paint);
    }
}
