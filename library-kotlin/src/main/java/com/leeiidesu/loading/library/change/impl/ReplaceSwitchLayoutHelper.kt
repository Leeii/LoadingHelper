package com.leeiidesu.loading.library.change.impl

import android.view.View
import android.view.ViewGroup
import com.leeiidesu.loading.library.change.SwitchLayoutHelper

/**
 * 替换方式切换布局
 * Created by leeiides on 2017/6/23.
 */
internal class ReplaceSwitchLayoutHelper(view: View) : SwitchLayoutHelper {
    private val originParams: ViewGroup.LayoutParams = view.layoutParams

    private val mParentView: ViewGroup

    private var indexOfView: Int

    private var mCurrentView: View

    init {
        if (view.parent == null) {
            mParentView = view.rootView.findViewById(android.R.id.content) as ViewGroup
        } else {
            mParentView = view.parent as ViewGroup
        }

        indexOfView = mParentView.indexOfChild(view)

        mCurrentView = view
    }

    @Synchronized override fun switchLayout(targetView: View) {
        if (mCurrentView == targetView) return
        indexOfView = mParentView.indexOfChild(mCurrentView)

        if (mParentView.getChildAt(indexOfView) != targetView) {
            mParentView.removeView(mCurrentView)

            mParentView.addView(targetView, indexOfView, originParams)

            mCurrentView = targetView
        }
    }
}