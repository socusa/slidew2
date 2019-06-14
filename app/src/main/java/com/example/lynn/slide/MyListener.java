package com.example.lynn.slide;

import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import static com.example.lynn.slide.MainActivity.*;

public class MyListener implements View.OnTouchListener {
    private int offsetX;
    private int offsetY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)v.getLayoutParams();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            offsetX = (int)(event.getRawX() - params.leftMargin);
            offsetY = (int)(event.getRawY() - params.topMargin);
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            params.leftMargin = (int)(event.getRawX() - offsetX);
            params.topMargin = (int)(event.getRawY() - offsetY);

            v.setLayoutParams(params);
        }

        return (true);
    }
}
