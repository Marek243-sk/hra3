package sk.tuke.hra3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.GameState;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public void startGame(View view) {
        DrawView drawView = new DrawView(this);
        setContentView(drawView);
    }


}