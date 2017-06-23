package com.leeiidesu.loading.library

import android.view.View
import com.leeiidesu.loading.library.change.SwitchLayoutHelper
import com.leeiidesu.loading.library.change.SwitchLayoutHelperFactory
import com.leeiidesu.loading.library.impl.LoadingHelperImpl


/**
 * Created by dgg on 2017/6/23.
 */
interface LoadingHelper {

    companion object {

        fun with(view: View,
                 config: Config = Config.build(),
                 mode: SwitchLayoutHelperFactory.Mode = SwitchLayoutHelperFactory.Mode.REPLACE): LoadingHelper {

            return LoadingHelperImpl(view, config, SwitchLayoutHelperFactory.getSwitchLayoutHelper(mode, view))
        }
    }

    enum class Status {
        LOADING, EMPTY, ERROR, NORMAL, NO_NETWORK
    }

    interface OnRetryClickListener {
        fun onRetry(view: View, status: Status)
    }

    /**
     * 显示加载中布局
     */
    fun showLoading()

    /**
     * 显示空布局
     */
    fun showEmpty()

    /**
     * 显示错误布局
     */
    fun showError()

    /**
     * 显示原布局
     */
    fun showOrigin()

    /**
     * 显示无网布局
     */
    fun showNoNetwork()

    /**
     * 移除所有View
     */
    fun removeAllView()

    fun setOnRetryClickListener(l: OnRetryClickListener)

    fun putCustomViewByStatus(status: Status, view: View)

}