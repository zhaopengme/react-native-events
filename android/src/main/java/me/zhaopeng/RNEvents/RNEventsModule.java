package me.zhaopeng.RNEvents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNEventsModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final String TAG = "RNEventsModule";

    private ReactApplicationContext reactContext;
    private SendEvent sendEvent;
    private HeadsetIntentReceiver headsetIntentReceiver;
    private static final String ACTION_HEADSET_PLUG = (android.os.Build.VERSION.SDK_INT >= 21) ? AudioManager.ACTION_HEADSET_PLUG : Intent.ACTION_HEADSET_PLUG;

    public RNEventsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNEvents";
    }


    @Override
    public void initialize() {
        super.initialize();
        this.sendEvent = new SendEvent(this.reactContext);
        PhoneListener phoneListener = new PhoneListener(this.sendEvent);
        TelephonyManager phoneManager = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (phoneManager != null) {
            phoneManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
        }
        Log.d(TAG, "startWiredHeadsetEvent()");

        headsetIntentReceiver = new HeadsetIntentReceiver (this.sendEvent);
        IntentFilter filter = new IntentFilter(ACTION_HEADSET_PLUG);
        ReactContext reactContext1 = getReactApplicationContext();
        if (reactContext1 != null) {
            reactContext1.registerReceiver(headsetIntentReceiver, filter);
        } else {
            Log.d(TAG, "startWiredHeadsetEvent() reactContext is null");
        }
    }


    @Override
    public void onHostResume() {
        Log.d(TAG, "onResume()");
    }

    @Override
    public void onHostPause() {
        Log.d(TAG, "onResume()");
    }

    @Override
    public void onHostDestroy() {
        Log.d(TAG, "onResume()");
    }
}
