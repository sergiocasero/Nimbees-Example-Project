package com.sergiocasero.blog.notification;

import android.content.Context;
import android.util.Log;

import com.nimbees.platform.NimbeesNotificationManager;

import java.util.Map;

/**
 * Created by sergiocasero on 14/3/16.
 */
public class MyNotificationManager extends NimbeesNotificationManager {


    private static final String TAG = "MyNotificationManager";

    public MyNotificationManager(Context context) {
        super(context);
    }

    @Override
    public void handleSimpleMessage(long idNotification, String message, Map<String, String> additionalContent) {
        super.handleSimpleMessage(idNotification, message, additionalContent);

        Log.i(TAG, message);
    }
}
