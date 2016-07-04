package com.kevin.zwk.ksmediaplayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.View;

import com.ksyun.media.player.IMediaPlayer;
import com.ksyun.media.player.KSYMediaPlayer;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private KSYMediaPlayer ksyMediaPlayer;
    private MyVideoView myVideoView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ksyMediaPlayer = new KSYMediaPlayer.Builder(this).build();
        myVideoView = (MyVideoView) findViewById(R.id.myVideoView);
        surfaceHolder = myVideoView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                surfaceHolder = holder;
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
//surfaceHolder.setFormat(PixelFormat.RGBX_8888);
        ksyMediaPlayer = new KSYMediaPlayer.Builder(this).build();

    }

    public void playclick(View view) {
        // String path= Environment.getExternalStorageState()
        ksyMediaPlayer.reset();

        try {
            ksyMediaPlayer.setDataSource(MainActivity.this, Uri.parse("rtmp://live.hkstv.hk.lxdns.com/live/hks"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ksyMediaPlayer.setDisplay(surfaceHolder);
        ksyMediaPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                iMediaPlayer.start();

            }
        });
        ksyMediaPlayer.prepareAsync();

    }

    public void stopclick(View view) {
        ksyMediaPlayer.pause();
    }
}
