package sk.tuke.hra3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.GameState;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<EntityScoreHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        mediaPlayer = MediaPlayer.create(this, R.raw.level_selecrion);
        mediaPlayer.setLooping(true);

        recyclerView = findViewById(R.id.myRecycleView);
        layoutManager = new LinearLayoutManager(this);
        List<EntityScoreModel> data = Tools.getEntityScoreData();
        adapter = new EntityScoreAdapter(data,new WeakReference<Context>(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void startGame(View view) {
        DrawView drawView = new DrawView(this);
        setContentView(drawView);
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

    class DbGetData extends AsyncTask<EntityScore, Integer, List<EntityScore>> {

        @Override
        protected List<EntityScore> doInBackground(EntityScore... entityScores) {
            List<EntityScore> data = DbTools.getDbContext(new WeakReference<>(MainActivity.this)).entityScoreDAO().getAll();
            if(data.size() == 0) {
                DbTools.getDbContext(new WeakReference<Context>(MainActivity.this)).entityScoreDAO().insertEntityScore(entityScores);
                return DbTools.getDbContext(new WeakReference<Context>(MainActivity.this)).entityScoreDAO().getAll();
            }
            else
                return DbTools.getDbContext(new WeakReference<Context>(MainActivity.this)).entityScoreDAO().getAll();
        }

        @Override
        protected void onPostExecute(List<EntityScore> entityScores) {
            super.onPostExecute(entityScores);
            ((TextView)findViewById(R.id.tv_score)).setText(entityScores.get(0).getScore());
        }
    }

}