package myanmar.keyfields.app.pocsimplehabits.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myanmar.keyfields.app.pocsimplehabits.R;
import myanmar.keyfields.app.pocsimplehabits.data.vo.BaseCompoment;
import myanmar.keyfields.app.pocsimplehabits.data.vo.HabitStarterVO;
import myanmar.keyfields.app.pocsimplehabits.viewholders.BaseViewHolder;
import myanmar.keyfields.app.pocsimplehabits.viewholders.DataViewHolder;
import myanmar.keyfields.app.pocsimplehabits.viewholders.StartViewHolder;

/**
 * Created by ZNMSW on 06-Apr-18.
 */
public class HomeRecyclerAdapter extends BaseRecyclerAdapter<BaseViewHolder, BaseCompoment> {

    private static final int SERIRES_TOP = 0;
    private static final int MORING_MEDIATE = 1;
    private static final int HEALTHY_RECYCLER = 2;


    public HomeRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        if (viewType == SERIRES_TOP) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customviewholder, parent, false);
            return new DataViewHolder(itemView);
        } else if (viewType == MORING_MEDIATE) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_medium, parent, false);
            return new DataViewHolder(itemView);
        } else if (viewType == HEALTHY_RECYCLER) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder, parent, false);
            return new StartViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_medium, parent, false);
            return new DataViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        // holder.bind(mData.get(position));

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return SERIRES_TOP;
        } else if (position == 1) {
            return MORING_MEDIATE;
        } else if (position == 2) {
            return HEALTHY_RECYCLER;
        } else {
            return position;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
