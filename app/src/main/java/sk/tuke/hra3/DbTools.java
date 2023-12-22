package sk.tuke.hra3;

import android.content.Context;
import androidx.room.Room;
import java.lang.ref.WeakReference;

public class DbTools {
    private static GameDb _db;

    public static GameDb getDbContext(WeakReference<Context> refContext) {
        if (_db == null) {
            _db = Room.databaseBuilder(refContext.get(), GameDb.class, "gameDb").fallbackToDestructiveMigration().build();
        }
        return _db;
    }
}
