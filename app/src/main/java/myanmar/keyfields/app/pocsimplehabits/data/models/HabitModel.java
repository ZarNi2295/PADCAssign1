package myanmar.keyfields.app.pocsimplehabits.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import myanmar.keyfields.app.pocsimplehabits.data.vo.BaseCompoment;
import myanmar.keyfields.app.pocsimplehabits.events.RestApiEvents;
import myanmar.keyfields.app.pocsimplehabits.network.TopicsDataAgentImpl;
import myanmar.keyfields.app.pocsimplehabits.utils.AppConstants;

/**
 * Created by ZNMSW on 27-May-18.
 */
public class HabitModel {
    public static HabitModel objInstance;
    private List<BaseCompoment> mData;
    private int topicsPageIndex = 1;

    private HabitModel() {
        EventBus.getDefault().register(this);
        mData = new ArrayList<>();
    }

    public static HabitModel getInstance() {
        if (objInstance == null) {
            objInstance = new HabitModel();
        }
        return objInstance;
    }

    public void startLoadingTopics() {
        TopicsDataAgentImpl.getInstance().loadTopics(AppConstants.ACCESS_TOKEN, topicsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onTopicsDataLoaded(RestApiEvents.NewsTopicsLoadedEvent event) {
        mData.addAll(event.getLoadTopics());
        TopicsDataAgentImpl.getInstance().loadCurrentProgram(AppConstants.ACCESS_TOKEN, topicsPageIndex);
        // topicsPageIndex = event.getLoadedPageIndex() + 1;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCurrentProgramDataLoaded
            (RestApiEvents.CurrentProgramLoadedEvent event) {
        List<BaseCompoment> baseCompomentList = new ArrayList<>();
        baseCompomentList.add(event.getStartItemVOS());
        mData.addAll(baseCompomentList);
        TopicsDataAgentImpl.getInstance().loadCategoriesProgram(AppConstants.ACCESS_TOKEN, topicsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSeriesProgramDataLoaded(RestApiEvents.CategoriesProgramLoadedEvent event) {
        mData.addAll(event.getCategoriesProgramDataVOS());
        //EventBus.getDefault().post(new RestApiEvents.CurrentProgramLoadedEvent(event.getCategoriesProgramDataVOS()));
        EventBus.getDefault().post(new RestApiEvents.AllDataLoadedEvent());
    }

    public List<BaseCompoment> getFinalDataFromNetwork(){
        return mData;
    }

}
