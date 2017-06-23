package com.leeiidesu.loading.library.impl

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.leeiidesu.loading.library.Config
import com.leeiidesu.loading.library.LoadingHelper
import com.leeiidesu.loading.library.R
import com.leeiidesu.loading.library.change.SwitchLayoutHelper

/**
 * Created by dgg on 2017/6/23.
 */
class LoadingHelperImpl internal constructor(view: View, config: Config, switchLayoutHelper: SwitchLayoutHelper) : LoadingHelper {
    /**
     * 布局切换操作类
     */
    private val mSwitchLayoutHelper: SwitchLayoutHelper = switchLayoutHelper

    private var mOriginView: View = view
    private var mConfig: Config = config


    var onRetryListener: LoadingHelper.OnRetryClickListener? = config.l

    val mViewMap: MutableMap<LoadingHelper.Status, View> = mutableMapOf()


    override fun showLoading() {
        var loadingView: View? = mViewMap[LoadingHelper.Status.LOADING]

        if (loadingView == null) {
            loadingView = LayoutInflater.from(mOriginView.context)
                    .inflate(R.layout.layout_status_loading, null, false)

            assert(loadingView != null)

            val icon: ImageView = loadingView.findViewById(R.id.loadIcon) as ImageView
            val text: TextView = loadingView.findViewById(R.id.loadText) as TextView

            loadingView.setTag(R.id.status_layout_icon, icon)
            loadingView.setTag(R.id.status_layout_message, text)

            putCustomViewByStatus(LoadingHelper.Status.LOADING, loadingView)
        }

        val icon: ImageView? = loadingView!!.getTag(R.id.status_layout_icon) as ImageView
        icon?.setImageResource(mConfig.loadingIcon)

        val text: TextView? = loadingView.getTag(R.id.status_layout_message) as TextView
        text?.text = mConfig.loadingMessage

        mSwitchLayoutHelper.switchLayout(loadingView)
    }

    override fun showEmpty() {
        var emptyView: View? = mViewMap[LoadingHelper.Status.EMPTY]

        if (emptyView == null) {
            emptyView = LayoutInflater.from(mOriginView.context)
                    .inflate(R.layout.layout_status_empty, null, false)

            assert(emptyView != null)

            val icon: ImageView = emptyView.findViewById(R.id.icon) as ImageView
            val text: TextView = emptyView.findViewById(R.id.text) as TextView
            val retry: TextView = emptyView.findViewById(R.id.retry) as TextView

            emptyView.setTag(R.id.status_layout_icon, icon)
            emptyView.setTag(R.id.status_layout_message, text)
            emptyView.setTag(R.id.status_layout_retry_text, retry)

            putCustomViewByStatus(LoadingHelper.Status.EMPTY, emptyView)
        }

        val icon: ImageView? = emptyView!!.getTag(R.id.status_layout_icon) as ImageView
        icon?.setImageResource(mConfig.emptyIcon)

        val text: TextView? = emptyView.getTag(R.id.status_layout_message) as TextView
        text?.text = mConfig.emptyMessage

        val retry: TextView? = emptyView.getTag(R.id.status_layout_retry_text) as TextView
        retry?.text = mConfig.emptyRetryText
        retry?.visibility = if (TextUtils.isEmpty(mConfig.emptyRetryText)) View.GONE else View.VISIBLE

        mSwitchLayoutHelper.switchLayout(emptyView)
    }

    override fun showError() {
        var errorView: View? = mViewMap[LoadingHelper.Status.ERROR]

        if (errorView == null) {
            errorView = LayoutInflater.from(mOriginView.context)
                    .inflate(R.layout.layout_status_error, null, false)

            assert(errorView != null)

            val icon: ImageView = errorView.findViewById(R.id.icon) as ImageView
            val text: TextView = errorView.findViewById(R.id.text) as TextView
            val retry: TextView = errorView.findViewById(R.id.retry) as TextView

            errorView.setTag(R.id.status_layout_icon, icon)
            errorView.setTag(R.id.status_layout_message, text)
            errorView.setTag(R.id.status_layout_retry_text, retry)

            putCustomViewByStatus(LoadingHelper.Status.ERROR, errorView)
        }

        val icon: ImageView? = errorView!!.getTag(R.id.status_layout_icon) as ImageView
        icon?.setImageResource(mConfig.errorIcon)

        val text: TextView? = errorView.getTag(R.id.status_layout_message) as TextView
        text?.text = mConfig.errorMessage

        val retry: TextView? = errorView.getTag(R.id.status_layout_retry_text) as TextView
        retry?.text = mConfig.errorRetryText
        retry?.visibility = if (TextUtils.isEmpty(mConfig.errorRetryText)) View.GONE else View.VISIBLE

        mSwitchLayoutHelper.switchLayout(errorView)
    }

    override fun showOrigin() {
        mSwitchLayoutHelper.switchLayout(mOriginView)
    }

    override fun showNoNetwork() {
        var noNetworkView: View? = mViewMap[LoadingHelper.Status.ERROR]

        if (noNetworkView == null) {
            noNetworkView = LayoutInflater.from(mOriginView.context)
                    .inflate(R.layout.layout_status_no_network, null, false)

            assert(noNetworkView != null)

            val icon: ImageView = noNetworkView.findViewById(R.id.icon) as ImageView
            val text: TextView = noNetworkView.findViewById(R.id.text) as TextView
            val retry: TextView = noNetworkView.findViewById(R.id.retry) as TextView

            noNetworkView.setTag(R.id.status_layout_icon, icon)
            noNetworkView.setTag(R.id.status_layout_message, text)
            noNetworkView.setTag(R.id.status_layout_retry_text, retry)

            putCustomViewByStatus(LoadingHelper.Status.ERROR, noNetworkView)
        }

        val icon: ImageView? = noNetworkView!!.getTag(R.id.status_layout_icon) as ImageView
        icon?.setImageResource(mConfig.noNetworkIcon)

        val text: TextView? = noNetworkView.getTag(R.id.status_layout_message) as TextView
        text?.text = mConfig.noNetworkMessage

        val retry: TextView? = noNetworkView.getTag(R.id.status_layout_retry_text) as TextView
        retry?.text = mConfig.noNetworkRetryText
        retry?.visibility = if (TextUtils.isEmpty(mConfig.noNetworkRetryText)) View.GONE else View.VISIBLE

        mSwitchLayoutHelper.switchLayout(noNetworkView)
    }

    override fun removeAllView() {
        mViewMap.clear()
    }

    override fun putCustomViewByStatus(status: LoadingHelper.Status, view: View) {
        mViewMap.put(status, view)
    }

    override fun setOnRetryClickListener(l: LoadingHelper.OnRetryClickListener) {
        onRetryListener = l
    }

}