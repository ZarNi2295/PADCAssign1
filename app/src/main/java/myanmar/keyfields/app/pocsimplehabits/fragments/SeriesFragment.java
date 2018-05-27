package myanmar.keyfields.app.pocsimplehabits.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import myanmar.keyfields.app.pocsimplehabits.R;
import myanmar.keyfields.app.pocsimplehabits.adapters.HomeRecyclerAdapter;
import myanmar.keyfields.app.pocsimplehabits.data.vo.BaseCompoment;
import myanmar.keyfields.app.pocsimplehabits.data.vo.HabitStarterVO;
import myanmar.keyfields.app.pocsimplehabits.data.vo.TopicVO;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends Fragment {
    RecyclerView recyclerView, recyclerViewMain;
    private HomeRecyclerAdapter mAdapter;

    public SeriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        onBindUI(view);
        return view;
    }

    private void onBindUI(View view) {
        //recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewScore);
        recyclerViewMain = (RecyclerView) view.findViewById(R.id.main_recycle_view);

        recyclerViewMain.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new HomeRecyclerAdapter(getActivity());
        recyclerViewMain.setAdapter(mAdapter);

        List<BaseCompoment> baseCompomentList = new ArrayList<>();
        baseCompomentList.add(new HabitStarterVO("a", "b"));
        baseCompomentList.add(new TopicVO("dfa", "der", "er", "reree"));

        mAdapter.appendNewData(baseCompomentList);


    }
}
