package sk.tuke.hra3;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.lang.ref.WeakReference;

public class DbTools {
    private static EntityScoreDatabase _db;
    public DbTools(WeakReference<Context> refContext) {
        getDbContext(refContext);
    }

    public static EntityScoreDatabase getDbContext(WeakReference<Context> refContext) {
        if(_db!=null)
            return _db;
        return Room.databaseBuilder(refContext.get(), EntityScoreDatabase.class, "movie-db").build();
    }
}
