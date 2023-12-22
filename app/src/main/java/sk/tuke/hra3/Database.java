package sk.tuke.hra3;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Database extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GameAdapter gameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        recyclerView = findViewById(R.id.myRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gameAdapter = new GameAdapter(new ArrayList<>(),this);
        recyclerView.setAdapter(gameAdapter);

        new DbLoadData(this).execute();
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        int score = intent.getIntExtra("score",0);

        if (date != null && !date.trim().isEmpty()) {
            Game newGame = new Game(date, score);
            new DbInsertData(this).execute(newGame);

        }
    }

    private static class DbLoadData extends AsyncTask<Void, Void, List<Game>> {
        private WeakReference<Context> contextWeakReference;

        DbLoadData(Context context) {
            contextWeakReference = new WeakReference<>(context);
        }

        @Override
        protected List<Game> doInBackground(Void... voids) {
            GameDb gameDb =DbTools.getDbContext(contextWeakReference);
            return gameDb.gameDao().getAllGames();
        }

        @Override
        protected void onPostExecute(List<Game> games) {
            Context context = contextWeakReference.get();
            if (context instanceof Database) {
                Database database = (Database) context;
                database.gameAdapter = new GameAdapter(games, database);
                database.recyclerView.setAdapter(database.gameAdapter);
            }
        }
    }

    private static class DbInsertData extends AsyncTask<Game, Void, Void> {
        private WeakReference<Context> contextWeakReference;

        DbInsertData(Context context) {
            contextWeakReference = new WeakReference<>(context);
        }

        @Override
        protected Void doInBackground(Game... games) {
            GameDb db = DbTools.getDbContext(contextWeakReference);
            db.gameDao().insertGames(games);
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            Context context = contextWeakReference.get();
            if (context instanceof Database) {
                Database database = (Database) context;
                new DbLoadData(context).execute();
            }
        }
    }
}
