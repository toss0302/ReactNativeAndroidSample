package com.bigwin.reactandroid;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;

/**
 * Created by bigwin on 2/8/17.
 */

public class UIManagerModule extends ReactContextBaseJavaModule implements ActivityEventListener {

    private static final String E_LAYOUT_ERROR = "E_LAYOUT_ERROR";

    public UIManagerModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "UIManagerAndroid";
    }

    // callback
    @ReactMethod
    public void measureLayout(
            int tag,
            int ancestorTag,
            Callback errorCallback,
            Callback successCallback) {
        try {
            measureLayout(tag, ancestorTag, mMeastureBuffer);
            float relativeX = PixelUtil.toDIPFromPixel(mMeasureBuffer[0]);
            float relativeY = PixelUtil.toDIPFromPixel(mMeasureBuffer[1]);
            float width = PixelUtil.toDIPFromPixel(mMeasureBuffer[2]);
            float height = PixelUtil.toDIPFromPixel(mMeasureBuffer[3]);
            successCallback.invoke(relativeX, relativeY, width, height);
        } catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }
    }

    // Promises
    @ReactMethod
    public void measureLayout(
            int tag,
            int ancestorTag,
            Promise promise) {
        try {
            measureLayout(tag, ancestorTag, mMeasureBuffer);

            WritableMap map = Arguments.createMap();

            map.putDouble("relativeX", PixelUtil.toDIPFromPixel(mMeasureBuffer[0]));
            map.putDouble("relativeY", PixelUtil.toDIPFromPixel(mMeasureBuffer[1]));
            map.putDouble("width", PixelUtil.toDIPFromPixel(mMeasureBuffer[2]));
            map.putDouble("height", PixelUtil.toDIPFromPixel(mMeasureBuffer[3]));

            promise.resolve(map);
        } catch (IllegalViewOperationException e) {
            promise.reject(E_LAYOUT_ERROR, e);
        }
    }

    // Sending Events to JavaScript
    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    WritableMap params = Arguments.createMap();

    sendEvent(reactContext, "keyboardWillShow", params);

}
