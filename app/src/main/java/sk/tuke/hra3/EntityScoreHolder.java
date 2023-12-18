package sk.tuke.hra3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EntityScoreHolder extends RecyclerView.ViewHolder {

    TextView score;
    TextView time;

    public EntityScoreHolder(@NonNull View itemView) {
        super(itemView);
        score = itemView.findViewById(R.id.tv_score);
        time = itemView.findViewById(R.id.tv_time);
    }
}
