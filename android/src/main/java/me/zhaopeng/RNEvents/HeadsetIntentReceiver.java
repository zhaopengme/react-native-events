package me.zhaopeng.RNEvents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

/**
 * Created by zhaopeng on 2017/3/18.
 */

public class HeadsetIntentReceiver extends BroadcastReceiver {
    private static final String ACTION_HEADSET_PLUG = (android.os.Build.VERSION.SDK_INT >= 21) ? AudioManager.ACTION_HEADSET_PLUG : Intent.ACTION_HEADSET_PLUG;

    private String TAG = "HeadSet";
    private SendEvent sendEvent;


    public HeadsetIntentReceiver(SendEvent sendEvent) {
        this.sendEvent = sendEvent;
        Log.d(TAG, "Created");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_HEADSET_PLUG)) {
            int state = intent.getIntExtra("state", -1);
            switch (state) {
                case (0):
                    Log.d(TAG, "Headset unplugged");
                    this.sendEvent.sender("HEADSET_OFF");
                    break;
                case (1):
                    Log.d(TAG, "Headset plugged");
                    this.sendEvent.sender("HEADSET_ON");
                    break;
                default:
                    Log.d(TAG, "Error");
                    this.sendEvent.sender("HEADSET_ERROR");
            }
        }
    }
}