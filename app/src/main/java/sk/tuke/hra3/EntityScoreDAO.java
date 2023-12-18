package sk.tuke.hra3;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EntityScoreDAO {

    @Query("SELECT * FROM EntityScore")
    List<EntityScore> getAll();

    @Query("SELECT * FROM EntityScore WHERE Id LIKE :Id")
    EntityScore getById(int Id);

    @Insert
    void insertEntityScore(EntityScore... entityScores);

    @Delete
    void deleteEntityScore(EntityScore entityScore);
}
