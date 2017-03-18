package me.zhaopeng.RNEvents;

import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/**
 * Created by zhaopeng on 2017/3/18.
 */


public class PhoneListener extends PhoneStateListener {


    private SendEvent sendEvent;

    public PhoneListener(SendEvent sendEvent) {
        this.sendEvent = sendEvent;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {

        switch (state) {
            //当处于待机状态中
            case TelephonyManager.CALL_STATE_IDLE:
                this.sendEvent.sender("CALL_STATE_IDLE");
                break;
            // 当处于通话中
            case TelephonyManager.CALL_STATE_OFFHOOK:
                this.sendEvent.sender("CALL_STATE_OFFHOOK");
                break;
            //当处于拨号状态中..
            case TelephonyManager.CALL_STATE_RINGING:
                this.sendEvent.sender("CALL_STATE_RINGING");
                break;
            default:
                break;
        }
        super.onCallStateChanged(state, incomingNumber);
    }

}

