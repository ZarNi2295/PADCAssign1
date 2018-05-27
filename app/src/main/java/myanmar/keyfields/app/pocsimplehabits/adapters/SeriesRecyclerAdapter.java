package myanmar.keyfields.app.pocsimplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import myanmar.keyfields.app.pocsimplehabits.R;
import myanmar.keyfields.app.pocsimplehabits.data.vo.HabitStarterVO;
import myanmar.keyfields.app.pocsimplehabits.viewholders.BaseViewHolder;
import myanmar.keyfields.app.pocsimplehabits.viewholders.DataViewHolder;

/**
 * Created by ZNMSW on 26-May-18.
 */
public class SeriesRecyclerAdapter extends BaseRecyclerAdapter<BaseViewHolder, HabitStarterVO> {
    public SeriesRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull List<Object> payloads) {

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_small, parent, false);
        return new DataViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
