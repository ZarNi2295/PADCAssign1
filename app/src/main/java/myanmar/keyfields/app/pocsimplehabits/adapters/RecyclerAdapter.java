package myanmar.keyfields.app.pocsimplehabits.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myanmar.keyfields.app.pocsimplehabits.R;

/**
 * Created by ZNMSW on 06-Apr-18.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DataViewHolder> {

    private int rowLayout;
    public Context context;
    private static final int VIEW_1 = 1;
    private static final int VIEW_2 = 2;
    private static final int VIEW_3 = 3;
    private RecyclerView.Adapter mAdapter;

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
        if (viewType == VIEW_1) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customviewholder, parent, false);
            return new DataViewHolder(itemView);
        } else if (viewType == VIEW_2) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
            return new DataViewHolder(itemView);
        } else if (viewType == VIEW_3) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder, parent, false);
            return new DataViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_medium, parent, false);
            return new DataViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        if (position == VIEW_3) {
            RecyclerView recyclerView = holder.itemView.findViewById(R.id.recycleViewScore);
           /* recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            mAdapter = new RecyclerAdapter(R.layout.viewholder_small, context);
            recyclerView.setAdapter(mAdapter);*/
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_1;
        } else if (position == 1) {
            return VIEW_2;
        } else if (position == 2) {
            return VIEW_3;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

}
