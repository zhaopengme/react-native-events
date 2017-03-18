package me.zhaopeng.RNEvents;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Created by zhaopeng on 2017/3/18.
 */

public class SendEvent {

    private ReactContext reactContext;

    public SendEvent(ReactContext reactContext) {
        this.reactContext = reactContext;
    }

    private void sendEvent(String eventName, @Nullable WritableMap params) {
        this.reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    public void sender(String sign) {
        WritableMap et = Arguments.createMap();
        et.putString("event", sign);
        sendEvent("RNEvents", et);
    }

}
