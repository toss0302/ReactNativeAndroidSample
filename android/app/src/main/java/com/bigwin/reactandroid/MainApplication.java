package com.bigwin.reactandroid;

import android.app.Application;

import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bigwin on 2/8/17.
 */

public class MainApplication extends Application {

    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new AnExampleReactPackage() // <-- Add this line with your package name.
        );
    }
}
