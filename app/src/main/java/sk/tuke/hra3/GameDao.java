package sk.tuke.hra3;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GameDao {
    @Query("SELECT * FROM Game")
    List<Game> getAllGames();

    @Insert
    void insertGames(Game... games);
}
