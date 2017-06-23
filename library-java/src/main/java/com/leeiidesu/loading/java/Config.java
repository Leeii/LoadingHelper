package com.leeiidesu.loading.java;

import android.support.annotation.DrawableRes;

/**
 * Created by leeiides on 2017/6/23.
 */

public class Config {
    private @DrawableRes
    int loadingIcon;
    private String loadingMessage;

    private @DrawableRes
    int noNetworkIcon;
    private String noNetworkMessage;
    private String noNetworkRetryText;

    private @DrawableRes
    int errorIcon;
    private String errorMessage;
    private String errorRetryText;

    private @DrawableRes
    int emptyIcon;
    private String emptyMessage;
    private String emptyRetryText;
    private LoadingHelper.OnRetryClickListener l;


    public Config(int loadingIcon, String loadingMessage,
                  int noNetworkIcon, String noNetworkMessage, String noNetworkRetryText,
                  int errorIcon, String errorMessage, String errorRetryText,
                  int emptyIcon, String emptyMessage, String emptyRetryText,
                  LoadingHelper.OnRetryClickListener l) {
        this.loadingIcon = loadingIcon;
        this.loadingMessage = loadingMessage;
        this.noNetworkIcon = noNetworkIcon;
        this.noNetworkMessage = noNetworkMessage;
        this.noNetworkRetryText = noNetworkRetryText;
        this.errorIcon = errorIcon;
        this.errorMessage = errorMessage;
        this.errorRetryText = errorRetryText;
        this.emptyIcon = emptyIcon;
        this.emptyMessage = emptyMessage;
        this.emptyRetryText = emptyRetryText;
        this.l = l;
    }


    public int getLoadingIcon() {
        return loadingIcon;
    }

    public String getLoadingMessage() {
        return loadingMessage;
    }

    public int getNoNetworkIcon() {
        return noNetworkIcon;
    }

    public String getNoNetworkMessage() {
        return noNetworkMessage;
    }

    public String getNoNetworkRetryText() {
        return noNetworkRetryText;
    }

    public int getErrorIcon() {
        return errorIcon;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorRetryText() {
        return errorRetryText;
    }

    public int getEmptyIcon() {
        return emptyIcon;
    }

    public String getEmptyMessage() {
        return emptyMessage;
    }

    public String getEmptyRetryText() {
        return emptyRetryText;
    }

    public LoadingHelper.OnRetryClickListener getOnRetryClickListener() {
        return l;
    }

    public static class Builder {
        private Config config;

        public Builder() {
            config = new Config(R.mipmap.ic_loading_state_loading, "正在加载...",
                    R.mipmap.ic_loading_state_no_network, "未连接到互联网，请检查网络配置", "点击屏幕重新加载",
                    R.mipmap.state_img_chucuo, "数据加载失败", "重试",
                    R.mipmap.state_img_nodata, "什么都没有哦", "重新加载", null
            );
        }

        public Builder setLoadingIcon(@DrawableRes int iconRes) {
            config.loadingIcon = iconRes;
            return this;
        }

        public Builder setLoadingMessage(String message) {
            config.loadingMessage = message;
            return this;
        }

        public Builder setNoNetworkIcon(@DrawableRes int iconRes) {
            config.noNetworkIcon = iconRes;
            return this;
        }

        public Builder setNoNetworkMessage(String message) {
            config.noNetworkMessage = message;
            return this;
        }

        public Builder setNoNetworkRetryText(String text) {
            config.noNetworkRetryText = text;
            return this;
        }

        public Builder setErrorIcon(@DrawableRes int iconRes) {
            config.errorIcon = iconRes;
            return this;
        }

        public Builder setErrorMessage(String message) {
            config.errorMessage = message;
            return this;
        }

        public Builder setErrorRetryText(String text) {
            config.errorRetryText = text;
            return this;
        }

        public Builder setEmptyIcon(@DrawableRes int iconRes) {
            config.emptyIcon = iconRes;
            return this;
        }

        public Builder setEmptyMessage(String message) {
            config.emptyMessage = message;
            return this;
        }

        public Builder setEmptyRetryText(String text) {
            config.emptyRetryText = text;
            return this;
        }

        public Builder setOnRetryClickListener(LoadingHelper.OnRetryClickListener l) {
            config.l = l;
            return this;
        }

        public Config build() {
            return config;
        }
    }
}
