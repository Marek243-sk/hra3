package sk.tuke.hra3;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Game.class}, version = 1)
public abstract class GameDb extends RoomDatabase {
    public abstract GameDao gameDao();
}
