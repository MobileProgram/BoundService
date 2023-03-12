package com.mblhcmute.boundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private final MyBinder myBinder = new MyBinder();
    private MediaPlayer player;

    public MyService() {
    }

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyService", "onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MyService", "onBind");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("MyService", "onUnBind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyService", "onDestroy");
        if(player!= null) {
            player.release();
            player = null;
        }
    }

    public void startMusic() {
        if(player== null) {
            player = MediaPlayer.create(getApplicationContext(), R.raw.file_music);
        }
        player.start();
    }
}