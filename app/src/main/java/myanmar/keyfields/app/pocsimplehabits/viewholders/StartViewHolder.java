package myanmar.keyfields.app.pocsimplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import myanmar.keyfields.app.pocsimplehabits.R;
import myanmar.keyfields.app.pocsimplehabits.adapters.HomeRecyclerAdapter;
import myanmar.keyfields.app.pocsimplehabits.adapters.SeriesRecyclerAdapter;
import myanmar.keyfields.app.pocsimplehabits.data.vo.HabitStarterVO;

/**
 * Created by ZNMSW on 26-May-18.
 */
public class StartViewHolder extends BaseViewHolder<HabitStarterVO> {
    private RecyclerView.Adapter mAdapter;
    RecyclerView recyclerView;

    public StartViewHolder(View itemView) {
        super(itemView);
        recyclerView = itemView.findViewById(R.id.recycleViewScore1);
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new SeriesRecyclerAdapter(itemView.getContext());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setData(HabitStarterVO data) {

    }

    @Override
    public void onClick(View v) {

    }
}
