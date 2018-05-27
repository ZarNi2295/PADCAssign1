package myanmar.keyfields.app.pocsimplehabits.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import myanmar.keyfields.app.pocsimplehabits.data.vo.TopicVO;
import myanmar.keyfields.app.pocsimplehabits.events.RestApiEvents;
import myanmar.keyfields.app.pocsimplehabits.network.TopicsDataAgentImpl;
import myanmar.keyfields.app.pocsimplehabits.utils.AppConstants;

/**
 * Created by ZNMSW on 27-May-18.
 */
public class HabitModel {
    public static HabitModel objInstance;
    private List<TopicVO> topicVOS;
    private int topicsPageIndex = 1;

    private HabitModel() {
        EventBus.getDefault().register(this);
        topicVOS = new ArrayList<>();
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
        topicVOS.addAll(event.getLoadNews());
        topicsPageIndex = event.getLoadedPageIndex() + 1;
    }
}
