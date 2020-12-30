package com.example.for1612;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    public MyService() {
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Notification notification= new Notification.Builder(this).build();
        startForeground(777, notification);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("MyLoad", "Load start");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("MyLoad", "Load over");
                stopForeground(false);
                stopSelf();
            }
        }).start();
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "Service start");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "Service over");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
