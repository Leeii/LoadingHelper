package com.leeiidesu.loading.java.change;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by leeiides on 2017/6/23.
 */

public interface SwitchLayoutHelper {
    void switchLayout(@NonNull View targetView);

    void removeAllViews();

    @NonNull
    View getCurrentStatusView();
}
