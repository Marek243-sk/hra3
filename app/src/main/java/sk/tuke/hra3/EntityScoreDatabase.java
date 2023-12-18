package sk.tuke.hra3;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {EntityScore.class}, version = 1, exportSchema = false)
public abstract class EntityScoreDatabase extends RoomDatabase {
    public abstract EntityScoreDAO entityScoreDAO();
}
