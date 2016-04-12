package com.sergiocasero.blog.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.nimbees.platform.NimbeesClient;
import com.nimbees.platform.NimbeesException;
import com.nimbees.platform.callbacks.NimbeesRegistrationCallback;
import com.sergiocasero.blog.R;
import com.sergiocasero.blog.observer.NotificationObserver;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String user = "sergio.casero23@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerNimbeesUser();
        observeNotifications();
    }

    private void registerNimbeesUser() {
        try {
            NimbeesClient.init(getApplicationContext());
        } catch (NimbeesException e) {
            e.printStackTrace();
        }
        NimbeesClient.getUserManager().register(user, new NimbeesRegistrationCallback() {
            @Override
            public void onSuccess() {
                //Usuario registrado
            }

            @Override
            public void onFailure(NimbeesException e) {
                //Fallo
            }
        });
    }

    private void observeNotifications() {
        Observer observer = new Observer() {
            @Override
            public void update(Observable observable, Object data) {
                String message = (String) data;
                Log.i(TAG, message);
            }
        };

        NotificationObserver.getInstance().addObserver(observer);
    }
}
