package com.example.a32150.serviceexam;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

    public static boolean isStop = true;
    private int count;
    //private Thread t;
    MediaPlayer mp;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        isStop = false;
        mp = MediaPlayer.create(this, R.raw.boss);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }

    boolean isPause = true;
    //boolean isStop = true;
    int operate = 0;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    try {
         operate = intent.getIntExtra("operate", -1);
    }   catch(Exception e) {

        operate = 0;
    }

        switch (operate) {
            case 0://play
                if (!mp.isPlaying()) {
                    mp.start();
                    isStop = false;
                }
                break;
            case 1://pause
                if (mp.isPlaying()) {
                    isPause = true;
                    mp.pause();
                }   else    {
                    mp.start();
                    isPause = false;
                }
                break;
            case 2://stop
                if (mp.isPlaying()) {
                    mp.stop();
                    mp = MediaPlayer.create(this, R.raw.boss);
                    isStop = true;
                }
                break;
            default:
                stopService(intent);
                break;
        }

        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }


    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
