package sk.tuke.hra3;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class EntityScore {

    @PrimaryKey(autoGenerate = true)
    private long Id;

    @ColumnInfo(name = "score")
    private String score;

    @ColumnInfo(name = "time")
    private String time;

    public EntityScore(String score, String time) {
        this.score = score;
        this.time = time;
    }

    @Ignore
    public EntityScore() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
