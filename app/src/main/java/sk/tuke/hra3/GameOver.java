package sk.tuke.hra3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    TextView pointsTV;
    ImageView trophy;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_activity);
        trophy = findViewById(R.id.trophyImg);
        pointsTV = findViewById(R.id.pointsTV);
        int points = getIntent().getExtras().getInt("points");
        if (points == 240) {
            trophy.setVisibility(View.VISIBLE);
        }
        pointsTV.setText("" + points);
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
