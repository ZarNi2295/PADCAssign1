package myanmar.keyfields.app.pocsimplehabits.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ZNMSW on 06-Apr-18.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DataViewHolder> {

    private int rowLayout;
    public Context context;

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        public DataViewHolder(View v) {
            super(v);

        }
    }

    public RecyclerAdapter(int rowLayout, Context context) {
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

}
