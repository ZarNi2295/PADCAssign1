package myanmar.keyfields.app.pocsimplehabits.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import myanmar.keyfields.app.pocsimplehabits.R;
import myanmar.keyfields.app.pocsimplehabits.adapters.HomeRecyclerAdapter;
import myanmar.keyfields.app.pocsimplehabits.data.models.HabitModel;
import myanmar.keyfields.app.pocsimplehabits.data.vo.BaseCompoment;
import myanmar.keyfields.app.pocsimplehabits.data.vo.HabitStarterVO;
import myanmar.keyfields.app.pocsimplehabits.data.vo.TopicVO;
import myanmar.keyfields.app.pocsimplehabits.events.RestApiEvents;

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

        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

        onBindUI(view);
        HabitModel.getInstance().startLoadingTopics();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsDataLoaded(RestApiEvents.NewsTopicsLoadedEvent event) {
        //mAdapter.appendNewData(event.getLoadTopics());
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAllDataLoaded(RestApiEvents.AllDataLoadedEvent event){
        List<BaseCompoment> baseCompomentList = HabitModel.getInstance().getFinalDataFromNetwork();
        Log.d("Total Items", String.valueOf(baseCompomentList.size()));
        mAdapter.setNewData(baseCompomentList);
    }
}
