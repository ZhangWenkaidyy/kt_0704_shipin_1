package com.kevin.zwk.jiecaoplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {
    private JCVideoPlayerStandard jCVideoPlayerStandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //节操播放器
        jCVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jCVideoPlayerStandard);

        //添加网址，以及视频标题
        jCVideoPlayerStandard.setUp("http://flv2.bn.netease.com/videolib3/1607/04/fVeaL4622/SD/fVeaL4622-mobile.mp4","这就是爱吧");

    }
}
