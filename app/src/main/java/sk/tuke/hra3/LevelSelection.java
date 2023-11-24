package sk.tuke.hra3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LevelSelection extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Skryť stavový riadok
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_level_selection);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //Nastavenie tlačidiel pre obtiažnosti
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buttonEasy = findViewById(R.id.button_easy);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buttonNormal = findViewById(R.id.button_normal);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button buttonHard = findViewById(R.id.button_hard);

        buttonEasy.setOnClickListener(v -> {
            startActivity(new Intent(LevelSelection.this, EasyLevelActivity.class));
            finish();
        });

        buttonNormal.setOnClickListener(v -> {
            startActivity(new Intent(LevelSelection.this, Normal.class));
            finish();
        });

        buttonHard.setOnClickListener(v -> {
            startActivity(new Intent(LevelSelection.this, Hard.class));
            finish();
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.level_selecrion);
        mediaPlayer.setLooping(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
