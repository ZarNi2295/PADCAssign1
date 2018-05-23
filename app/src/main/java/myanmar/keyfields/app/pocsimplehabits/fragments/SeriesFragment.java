package myanmar.keyfields.app.pocsimplehabits.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myanmar.keyfields.app.pocsimplehabits.R;
import myanmar.keyfields.app.pocsimplehabits.adapters.RecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends Fragment {
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    public SeriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_series, container, false);
        onBindUI(view);
        return view;
    }

    private void onBindUI(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewScore);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mAdapter = new RecyclerAdapter(R.layout.viewholder_small
                , getActivity());
        recyclerView.setAdapter(mAdapter);
    }
}