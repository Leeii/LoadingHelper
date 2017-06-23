package com.leeiidesu.loading.library.change.impl

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.leeiidesu.loading.library.change.SwitchLayoutHelper

/**
 * 覆盖式切换
 * Created by leeiides on 2017/6/23.
 */
class CoverSwitchLayoutHelper(view: View) : SwitchLayoutHelper {

    private val mOriginView = view
    private val originParams: ViewGroup.LayoutParams = view.layoutParams

    private val mParentView: ViewGroup

    private var indexOfView: Int

    private var mCurrentView: View

    private var mFrameLayout: FrameLayout = FrameLayout(view.context)

    init {
        if (view.parent == null) {
            mParentView = view.rootView.findViewById(android.R.id.content) as ViewGroup
        } else {
            mParentView = view.parent as ViewGroup
        }

        indexOfView = mParentView.indexOfChild(view)

        mCurrentView = view

        mParentView.removeView(mCurrentView)
        mFrameLayout.addView(mCurrentView, originParams)

        mParentView.addView(mFrameLayout, indexOfView, originParams)
    }


    override fun switchLayout(targetView: View) {
        if (mCurrentView === targetView) return

        if (mFrameLayout.childCount == 2) {
            mFrameLayout.removeViewAt(1)
        }

        if (targetView !== mOriginView) mFrameLayout.addView(targetView, 1, originParams)

        mCurrentView = targetView
    }
}
