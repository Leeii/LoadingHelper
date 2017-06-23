package com.leeiidesu.loading.java.change.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.leeiidesu.loading.java.change.SwitchLayoutHelper;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by leeiides on 2017/6/23.
 */

class ReplaceSwitchLayoutHelper implements SwitchLayoutHelper {

    private View mOriginView;

    private ViewGroup mParentView;

    private int indexOfView;

    private View mCurrentView;

    private ViewGroup.LayoutParams originParams;


    ReplaceSwitchLayoutHelper(@NonNull View view) {
        mOriginView = view;
        originParams = view.getLayoutParams();

        if (view.getParent() == null) {
            mParentView = (ViewGroup) view.getRootView().findViewById(android.R.id.content);
        } else {
            mParentView = (ViewGroup) view.getParent();
        }

        indexOfView = mParentView.indexOfChild(view);

        mCurrentView = view;
    }

    @Override
    public synchronized void switchLayout(@NonNull View targetView) {
        if (mCurrentView == targetView) return;
        indexOfView = mParentView.indexOfChild(mCurrentView);

        if (mParentView.getChildAt(indexOfView) != targetView) {
            mParentView.removeView(mCurrentView);

            mParentView.addView(targetView, indexOfView, originParams);

            mCurrentView = targetView;
        }
    }

    @Override
    public void removeAllViews() {
        if (mCurrentView != mOriginView) {
            switchLayout(mOriginView);
        }

        mParentView = null;
        mCurrentView = null;
        originParams = null;
        mOriginView = null;
    }

    @NonNull
    @Override
    public View getCurrentStatusView() {
        return mCurrentView;
    }
}
