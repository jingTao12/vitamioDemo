package com.ida.vitamiodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //监测vitamio是否解压解码包
        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
            return;

        videoView = findViewById(R.id.vitamio_view);

        videoView.setVideoURI(Uri.parse("rtmp://live.hkstv.hk.lxdns.com/live/hks1"));
        videoView.setMediaController(new MediaController(this));

        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);
            }
        });
    }
}
