package com.leeiidesu.loading.library

import android.support.annotation.DrawableRes

/**
 * 配置 Created by dgg on 2017/6/23.
 */
data class Config(var loadingIcon: Int, var loadingMessage: String,
                  var noNetworkIcon: Int, var noNetworkMessage: String, var noNetworkRetryText: String,
                  var errorIcon: Int, var errorMessage: String, var errorRetryText: String,
                  var emptyIcon: Int, var emptyMessage: String, var emptyRetryText: String,
                  var l: LoadingHelper.OnRetryClickListener?) {
    companion object Builder {


        private var config = Config(R.mipmap.ic_loading_state_loading, "正在加载...",
                R.mipmap.ic_loading_state_no_network, "未连接到互联网，请检查网络配置", "点击屏幕重新加载",
                R.mipmap.state_img_chucuo, "数据加载失败", "重试",
                R.mipmap.state_img_nodata, "什么都没有哦", "重新加载", null
        )


        fun setLoadingIcon(@DrawableRes iconRes: Int): Builder {
            config.loadingIcon = iconRes
            return this
        }

        fun setLoadingMessage(message: String): Builder {
            config.loadingMessage = message
            return this
        }

        fun setNoNetworkIcon(@DrawableRes iconRes: Int): Builder {
            config.noNetworkIcon = iconRes
            return this
        }

        fun setNoNetworkMessage(message: String): Builder {
            config.noNetworkMessage = message
            return this
        }

        fun setNoNetworkRetryText(text: String): Builder {
            config.noNetworkRetryText = text
            return this
        }

        fun setErrorIcon(@DrawableRes iconRes: Int): Builder {
            config.errorIcon = iconRes
            return this
        }

        fun setErrorMessage(message: String): Builder {
            config.errorMessage = message
            return this
        }

        fun setErrorRetryText(text: String): Builder {
            config.errorRetryText = text
            return this
        }

        fun setEmptyIcon(@DrawableRes iconRes: Int): Builder {
            config.emptyIcon = iconRes
            return this
        }

        fun setEmptyMessage(message: String): Builder {
            config.emptyMessage = message
            return this
        }

        fun setEmptyRetryText(text: String): Builder {
            config.emptyRetryText = text
            return this
        }

        fun setOnRetryClickListener(l: LoadingHelper.OnRetryClickListener): Builder {
            config.l = l
            return this
        }

        fun build(): Config {
            return config
        }
    }
}