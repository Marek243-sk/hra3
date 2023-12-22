package sk.tuke.hra3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class GameOver extends AppCompatActivity {

    TextView pointsTV;
    ImageView trophy;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_activity);
        trophy = findViewById(R.id.trophyImg);
        pointsTV = findViewById(R.id.pointsTV);

        int points = getIntent().getIntExtra("Points", 0);
        pointsTV.setText("Points: " + points);

        if (points == 320) {
            trophy.setVisibility(View.VISIBLE);
        } else {
            trophy.setVisibility(View.INVISIBLE);
        }
    }

    public  void restart(View view) {
        Intent intent = new Intent(GameOver.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view) {
        finish();
    }
}