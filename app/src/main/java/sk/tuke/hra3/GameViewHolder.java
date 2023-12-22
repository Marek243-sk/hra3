package sk.tuke.hra3;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GameViewHolder extends RecyclerView.ViewHolder {
    TextView date;
    TextView score;

    public GameViewHolder(@NonNull View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.tv_date);
        score = itemView.findViewById(R.id.tv_score);
    }
}
