package com.cursoandroid.executandovideos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        //Esconde a statusBar e barra de navegação
        View decorView = getWindow().getDecorView();
        int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        //int uiOpcoes = View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOpcoes);
        //decorView.setSystemUiVisibilty(uiOpcoes);

        //Esconde a ActionBar
        getSupportActionBar().hide();

        //Executar o vídeo
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.start();

    }
}