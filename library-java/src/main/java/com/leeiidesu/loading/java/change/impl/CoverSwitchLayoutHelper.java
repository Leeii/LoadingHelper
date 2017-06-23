package com.leeiidesu.loading.java.change.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.leeiidesu.loading.java.change.SwitchLayoutHelper;

import java.security.acl.Group;

/**
 * Created by leeiides on 2017/6/23.
 */

class CoverSwitchLayoutHelper implements SwitchLayoutHelper {

    private View mOriginView;

    private ViewGroup mParentView;

    private int indexOfView;

    private View mCurrentView;

    private ViewGroup.LayoutParams originParams;

    private FrameLayout mFrameLayout;


    CoverSwitchLayoutHelper(@NonNull View view) {
        mOriginView = view;

        originParams = view.getLayoutParams();

        if (view.getParent() == null) {
            mParentView = (ViewGroup) view.getRootView().findViewById(android.R.id.content);
        } else {
            mParentView = (ViewGroup) view.getParent();
        }

        indexOfView = mParentView.indexOfChild(view);

        mCurrentView = view;

        mFrameLayout = new FrameLayout(view.getContext());
        mParentView.removeView(mCurrentView);
        mFrameLayout.addView(mCurrentView, originParams);

        mParentView.addView(mFrameLayout, indexOfView, originParams);
    }

    @Override
    public synchronized void switchLayout(@NonNull View targetView) {
        if (mCurrentView == targetView) return;

        if (mFrameLayout.getChildCount() == 2) {
            mFrameLayout.removeViewAt(1);
        }

        if (targetView != mOriginView) mFrameLayout.addView(targetView, 1, originParams);

        mCurrentView = targetView;

    }

    @Override
    public void removeAllViews() {
        mFrameLayout.removeView(mOriginView);
        mParentView.removeView(mFrameLayout);
        mParentView.addView(mOriginView, indexOfView, originParams);

        mFrameLayout = null;
        mParentView = null;
        mCurrentView = null;
        mOriginView = null;
        originParams = null;
    }

    @NonNull
    @Override
    public  View getCurrentStatusView() {
        return mCurrentView;
    }
}
