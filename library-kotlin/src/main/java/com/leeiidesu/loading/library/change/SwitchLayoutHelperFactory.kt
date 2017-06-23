package com.leeiidesu.loading.library.change

import android.view.View
import com.leeiidesu.loading.library.change.impl.CoverSwitchLayoutHelper
import com.leeiidesu.loading.library.change.SwitchLayoutHelper
import com.leeiidesu.loading.library.change.impl.ReplaceSwitchLayoutHelper

/**
 * Created by leeiides on 2017/6/23.
 */
class SwitchLayoutHelperFactory {
    enum class Mode {
        REPLACE, COVER
    }

    companion object {
        fun getSwitchLayoutHelper(mode: Mode, originView: View): SwitchLayoutHelper {
            when (mode) {
                Mode.REPLACE -> return ReplaceSwitchLayoutHelper(originView)
                Mode.COVER -> return CoverSwitchLayoutHelper(originView)
            }
        }
    }
}

