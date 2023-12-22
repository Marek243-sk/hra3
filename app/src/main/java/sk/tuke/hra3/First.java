package sk.tuke.hra3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_activity);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Button buttonEasy = findViewById(R.id.firstBtn);

        buttonEasy.setOnClickListener(v -> {
            startActivity(new Intent(First.this, MainActivity.class));
            finish();
        });
    }

    /*public boolean isIntersecting(float x, float y) {


    }*/
}