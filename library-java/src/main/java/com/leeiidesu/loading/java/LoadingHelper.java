package com.leeiidesu.loading.java;

import android.view.View;

import com.leeiidesu.loading.java.change.Mode;
import com.leeiidesu.loading.java.change.SwitchLayoutHelper;
import com.leeiidesu.loading.java.change.impl.SwitchLayoutHelperFactory;
import com.leeiidesu.loading.java.impl.LoadingHelperImpl;

/**
 * Created by leeiides on 2017/6/23.
 */

public abstract class LoadingHelper {
    public enum Status {
        LOADING, EMPTY, ERROR, NORMAL, NO_NETWORK
    }

    public interface OnRetryClickListener {
        void onRetry(View view, Status status);
    }

    public static LoadingHelper with(View originView) {
        return with(originView, new Config.Builder().build());
    }

    public static LoadingHelper with(View originView, Config config) {
        return with(originView, config, Mode.REPLACE);
    }

    public static LoadingHelper with(View originView, Mode mode) {
        return with(originView, new Config.Builder().build(), mode);
    }

    public static LoadingHelper with(View originView, Config config, Mode mode) {
        return new LoadingHelperImpl(originView, config, SwitchLayoutHelperFactory.getSwitchLayoutHelper(mode, originView));
    }

    /**
     * 显示加载中布局
     */
    public abstract void showLoading();

    /**
     * 显示空布局
     */
    public abstract void showEmpty();

    /**
     * 显示错误布局
     */
    public abstract void showError();

    /**
     * 显示原布局
     */
    public abstract void showOrigin();

    /**
     * 显示无网布局
     */
    public abstract void showNoNetwork();

    /**
     * 移除所有View
     */
    public abstract void removeAllView();

    public abstract void setOnRetryClickListener(OnRetryClickListener l);

    /**
     * 加入自定义布局
     *
     * @param status 布局对应的状态
     * @param view   view
     */
    public abstract void putCustomViewByStatus(Status status, View view);
}
