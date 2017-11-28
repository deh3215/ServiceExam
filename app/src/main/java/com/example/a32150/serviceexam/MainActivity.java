package com.example.a32150.serviceexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPLay(View v)  {
        Intent intent = new Intent();
        intent.setClass(this, MusicService.class);
        if (v.getId() == R.id.btn_play) {
            intent.putExtra("operate", 0);
            startService(intent);
        }
    }

    public void onPause(View v)  {
        Intent intent = new Intent();
        intent.setClass(this, MusicService.class);
        if (v.getId() == R.id.btn_pause) {
            intent.putExtra("operate", 1);
            startService(intent);
        }
    }

    public void onStop(View v)  {
        Intent intent = new Intent();
        intent.setClass(this, MusicService.class);
        if (v.getId() == R.id.btn_stop) {
            intent.putExtra("operate", 2);
            startService(intent);
        }
    }
}
