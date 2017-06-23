package com.leeiidesu.loading.java;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.leeiidesu.loading.java.change.SwitchLayoutHelper;

import java.util.HashMap;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by leeiides on 2017/6/23.
 */

public class LoadingHelperImpl extends LoadingHelper {
    private View originView;
    private Config config;
    private SwitchLayoutHelper mSwitchLayoutHelper;

    private HashMap<Status, View> mViewMap = new HashMap<>();
    private OnRetryClickListener mOnRetryClickListener;


    LoadingHelperImpl(View originView, Config config, SwitchLayoutHelper switchLayoutHelper) {
        this.originView = originView;
        this.config = config;
        this.mSwitchLayoutHelper = switchLayoutHelper;

        mOnRetryClickListener = config.getOnRetryClickListener();

        mViewMap.put(Status.NORMAL, originView);
    }

    @Override
    public void showLoading() {
        View loadingView = mViewMap.get(Status.LOADING);

        if (loadingView == null) {
            loadingView = LayoutInflater.from(originView.getContext())
                    .inflate(R.layout.layout_status_loading, null, false);
            ImageView icon = (ImageView) loadingView.findViewById(R.id.loadIcon);
            TextView text = (TextView) loadingView.findViewById(R.id.loadText);

            loadingView.setTag(R.id.status_layout_icon, icon);
            loadingView.setTag(R.id.status_layout_message, text);

            putCustomViewByStatus(Status.LOADING, loadingView);
        }

        ImageView icon = (ImageView) loadingView.getTag(R.id.status_layout_icon);
        if (icon != null) icon.setImageResource(config.getLoadingIcon());

        TextView text = (TextView) loadingView.getTag(R.id.status_layout_message);
        if (text != null) text.setText(config.getLoadingMessage());

        stopAnimationIfExist(mSwitchLayoutHelper.getCurrentStatusView());
        startAnimationIfExist(loadingView);
        mSwitchLayoutHelper.switchLayout(loadingView);

    }

    @Override
    public void showEmpty() {
        View emptyView = mViewMap.get(Status.EMPTY);

        if (emptyView == null) {
            emptyView = LayoutInflater.from(originView.getContext())
                    .inflate(R.layout.layout_status_empty, null, false);
            ImageView icon = (ImageView) emptyView.findViewById(R.id.icon);
            TextView text = (TextView) emptyView.findViewById(R.id.text);
            TextView retry = (TextView) emptyView.findViewById(R.id.retry);

            emptyView.setTag(R.id.status_layout_icon, icon);
            emptyView.setTag(R.id.status_layout_message, text);
            emptyView.setTag(R.id.status_layout_retry_text, retry);

            putCustomViewByStatus(Status.EMPTY, emptyView);
        }

        ImageView icon = (ImageView) emptyView.getTag(R.id.status_layout_icon);
        if (icon != null) icon.setImageResource(config.getEmptyIcon());

        TextView text = (TextView) emptyView.getTag(R.id.status_layout_message);
        if (text != null) text.setText(config.getEmptyMessage());

        TextView retry = (TextView) emptyView.getTag(R.id.status_layout_retry_text);
        if (retry != null) {
            retry.setText(config.getEmptyRetryText());
            retry.setVisibility(config.getEmptyRetryText() == null ? View.GONE : View.VISIBLE);
            final View finalEmptyView = emptyView;
            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnRetryClickListener.onRetry(finalEmptyView, Status.EMPTY);
                }
            });
        }

        stopAnimationIfExist(mSwitchLayoutHelper.getCurrentStatusView());
        startAnimationIfExist(emptyView);

        mSwitchLayoutHelper.switchLayout(emptyView);
    }

    @Override
    public void showError() {
        View errorView = mViewMap.get(Status.ERROR);

        if (errorView == null) {
            errorView = LayoutInflater.from(originView.getContext())
                    .inflate(R.layout.layout_status_error, null, false);
            ImageView icon = (ImageView) errorView.findViewById(R.id.icon);
            TextView text = (TextView) errorView.findViewById(R.id.text);
            TextView retry = (TextView) errorView.findViewById(R.id.retry);

            errorView.setTag(R.id.status_layout_icon, icon);
            errorView.setTag(R.id.status_layout_message, text);
            errorView.setTag(R.id.status_layout_retry_text, retry);

            putCustomViewByStatus(Status.ERROR, errorView);
        }

        ImageView icon = (ImageView) errorView.getTag(R.id.status_layout_icon);
        if (icon != null) icon.setImageResource(config.getErrorIcon());

        TextView text = (TextView) errorView.getTag(R.id.status_layout_message);
        if (text != null) text.setText(config.getErrorMessage());

        TextView retry = (TextView) errorView.getTag(R.id.status_layout_retry_text);
        if (retry != null) {
            retry.setText(config.getErrorRetryText());
            retry.setVisibility(config.getErrorRetryText() == null ? View.GONE : View.VISIBLE);
            final View finalErrorView = errorView;
            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnRetryClickListener.onRetry(finalErrorView, Status.ERROR);
                }
            });
        }

        stopAnimationIfExist(mSwitchLayoutHelper.getCurrentStatusView());
        startAnimationIfExist(errorView);

        mSwitchLayoutHelper.switchLayout(errorView);
    }

    @Override
    public void showOrigin() {

        stopAnimationIfExist(mSwitchLayoutHelper.getCurrentStatusView());
        mSwitchLayoutHelper.switchLayout(originView);
    }

    @Override
    public void showNoNetwork() {
        View noNetworkView = mViewMap.get(Status.NO_NETWORK);

        if (noNetworkView == null) {
            noNetworkView = LayoutInflater.from(originView.getContext())
                    .inflate(R.layout.layout_status_no_network, null, false);
            ImageView icon = (ImageView) noNetworkView.findViewById(R.id.icon);
            TextView text = (TextView) noNetworkView.findViewById(R.id.text);
            TextView retry = (TextView) noNetworkView.findViewById(R.id.retry);

            noNetworkView.setTag(R.id.status_layout_icon, icon);
            noNetworkView.setTag(R.id.status_layout_message, text);
            noNetworkView.setTag(R.id.status_layout_retry_text, retry);

            putCustomViewByStatus(Status.NO_NETWORK, noNetworkView);
        }

        ImageView icon = (ImageView) noNetworkView.getTag(R.id.status_layout_icon);
        if (icon != null) icon.setImageResource(config.getNoNetworkIcon());

        TextView text = (TextView) noNetworkView.getTag(R.id.status_layout_message);
        if (text != null) text.setText(config.getNoNetworkMessage());

        TextView retry = (TextView) noNetworkView.getTag(R.id.status_layout_retry_text);
        if (retry != null) {
            retry.setText(config.getNoNetworkRetryText());
            retry.setVisibility(config.getNoNetworkRetryText() == null ? View.GONE : View.VISIBLE);
            final View finalNoNetworkView = noNetworkView;
            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnRetryClickListener.onRetry(finalNoNetworkView, Status.NO_NETWORK);
                }
            });
        }

        stopAnimationIfExist(mSwitchLayoutHelper.getCurrentStatusView());
        startAnimationIfExist(noNetworkView);

        mSwitchLayoutHelper.switchLayout(noNetworkView);
    }

    @Override
    public void removeAllView() {
        mViewMap.clear();
        mViewMap = null;
        originView = null;
        config = null;
        mSwitchLayoutHelper.removeAllViews();
        mSwitchLayoutHelper = null;
    }

    @Override
    public void setOnRetryClickListener(LoadingHelper.OnRetryClickListener l) {
        this.mOnRetryClickListener = l;
    }

    @Override
    public void putCustomViewByStatus(LoadingHelper.Status status, View view) {
        mViewMap.put(status, view);
    }

    private void stopAnimationIfExist(View currentView) {
        Object tag = currentView.getTag(R.id.status_layout_icon);
        if (tag != null && tag instanceof GifImageView) {
            GifImageView gif = (GifImageView) tag;
            Drawable drawable = gif.getDrawable();

            if (drawable instanceof GifDrawable) {
                GifDrawable gifDrawable = (GifDrawable) drawable;
                gifDrawable.stop();
            }
        }
    }

    private void startAnimationIfExist(View currentView) {
        Object tag = currentView.getTag(R.id.status_layout_icon);
        if (tag != null && tag instanceof GifImageView) {
            GifImageView gif = (GifImageView) tag;
            Drawable drawable = gif.getDrawable();

            if (drawable instanceof GifDrawable) {
                GifDrawable gifDrawable = (GifDrawable) drawable;
                gifDrawable.start();
            }
        }
    }

}
