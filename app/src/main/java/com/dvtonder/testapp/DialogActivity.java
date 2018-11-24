package com.dvtonder.testapp;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;

public abstract class DialogActivity extends AppCompatActivity {
    private boolean mUsingLightTheme;

    @SuppressLint("InlinedApi")
    protected void applyTheme(boolean darkTheme) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // If we are in keyguard, override the default transparent theme
        Window window = getWindow();

        int flags = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        window.getDecorView().setSystemUiVisibility(flags);

        setTheme(darkTheme ? R.style.Activity_Transparent : R.style.Activity_Transparent_Light);

        mUsingLightTheme = !darkTheme;
    }

    protected boolean isUsingLightTheme() {
        return mUsingLightTheme;
    }

}
