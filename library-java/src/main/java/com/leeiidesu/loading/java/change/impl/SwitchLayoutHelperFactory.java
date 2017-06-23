package com.leeiidesu.loading.java.change.impl;

import android.view.View;

import com.leeiidesu.loading.java.change.Mode;
import com.leeiidesu.loading.java.change.SwitchLayoutHelper;

/**
 * Created by leeiides on 2017/6/23.
 */

public class SwitchLayoutHelperFactory {


    public static SwitchLayoutHelper getSwitchLayoutHelper(Mode mode, View view) {
        switch (mode) {
            case REPLACE:
                return new ReplaceSwitchLayoutHelper(view);
            case COVER:
                return new CoverSwitchLayoutHelper(view);
        }
        return new ReplaceSwitchLayoutHelper(view);
    }

    public static SwitchLayoutHelper getSwitchLayoutHelperFromReplaceMode(View view) {
        return new ReplaceSwitchLayoutHelper(view);
    }

    public static SwitchLayoutHelper getSwitchLayoutHelperFromCoverMode(View view) {
        return new CoverSwitchLayoutHelper(view);
    }

}
