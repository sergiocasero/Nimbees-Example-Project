package com.sergiocasero.blog.notification;

import android.content.Context;

import com.nimbees.platform.NimbeesNotificationManager;
import com.sergiocasero.blog.observer.NotificationObserver;

import java.util.Map;

/**
 * Created by sergiocasero on 14/3/16.
 */
public class MyNotificationManager extends NimbeesNotificationManager {


    private static final String TAG = "MyNotificationManager";

    private NotificationObserver notificationObserver;

    public MyNotificationManager(Context context) {
        super(context);

        notificationObserver = NotificationObserver.getInstance();
    }

    @Override
    public void handleSimpleMessage(long idNotification, String message, Map<String, String> additionalContent) {
        super.handleSimpleMessage(idNotification, message, additionalContent);

        notificationObserver.updateValue(message);
    }
}
