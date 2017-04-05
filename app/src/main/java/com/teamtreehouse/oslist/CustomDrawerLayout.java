package com.teamtreehouse.oslist;

import android.content.Context;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class CustomDrawerLayout extends DrawerLayout {
    private static final String TAG = CustomDrawerLayout.class.getSimpleName();

    public CustomDrawerLayout (Context context)
    {
        this(context, null);
    }

    public CustomDrawerLayout (Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public CustomDrawerLayout (Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent (MotionEvent ev)
    {
        boolean result = super.onInterceptTouchEvent(ev);

        View drawer = getChildAt(1);
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) drawer.getLayoutParams();
        if (isDrawerOpen(drawer) && ev.getAction() == MotionEvent.ACTION_DOWN && (layoutParams.gravity == Gravity.END && ev.getX() < drawer.getX())) {
            return false;
        } else {
            return result;
        }
    }
}
