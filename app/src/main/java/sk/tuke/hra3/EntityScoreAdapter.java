package sk.tuke.hra3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;

public class EntityScoreAdapter extends RecyclerView.Adapter<EntityScoreHolder> {
    private List<EntityScoreModel> _data;
    private WeakReference<Context> _context;

    public EntityScoreAdapter(List<EntityScoreModel> data, WeakReference<Context> contextWeakReference) {
        _context = contextWeakReference;
        _data = data;
    }

    public void refreshData(List<EntityScoreModel> data) {
        _data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EntityScoreHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(_context.get()).inflate(R.layout.recycle_view,viewGroup,false);
        return new EntityScoreHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntityScoreHolder entityScoreHolder, int i) {
        entityScoreHolder.score.setText(_data.get(i).score);
        entityScoreHolder.time.setText(_data.get(i).time);

    }

    @Override
    public int getItemCount() {
        if(_data!=null)
            return _data.size();
        return 0;
    }
}
