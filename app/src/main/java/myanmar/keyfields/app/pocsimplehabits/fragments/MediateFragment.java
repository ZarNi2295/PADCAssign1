package myanmar.keyfields.app.pocsimplehabits.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myanmar.keyfields.app.pocsimplehabits.R;
import myanmar.keyfields.app.pocsimplehabits.adapters.HomeViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MediateFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static MediateFragment newInstance() {
        MediateFragment fragment = new MediateFragment();
        return fragment;
    }


    public MediateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }

    private void setupViewPager(ViewPager viewPager) {
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new OnTheGoFragment(), "On The Go");
        adapter.addFragment(new SeriesFragment(), "Series");
        adapter.addFragment(new TeacherFragment(), "Teachers");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
    }
}
