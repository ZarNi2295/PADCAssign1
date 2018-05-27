package myanmar.keyfields.app.pocsimplehabits.events;


import java.util.List;

import myanmar.keyfields.app.pocsimplehabits.data.vo.CategoriesProgramDataVO;
import myanmar.keyfields.app.pocsimplehabits.data.vo.StartItemVO;
import myanmar.keyfields.app.pocsimplehabits.data.vo.TopicVO;

/**
 * Created by aung on 12/2/17.
 */

public class RestApiEvents {

    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class NewsTopicsLoadedEvent {
        private int loadedPageIndex;
        private List<TopicVO> loadTopics;

        public NewsTopicsLoadedEvent(int loadedPageIndex, List<TopicVO> loadTopics) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadTopics = loadTopics;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<TopicVO> getLoadTopics() {
            return loadTopics;
        }
    }

    public static class CurrentProgramLoadedEvent {
        private StartItemVO startItemVOS;

        public CurrentProgramLoadedEvent(StartItemVO startItemVOS) {
            this.startItemVOS = startItemVOS;
        }

        public StartItemVO getStartItemVOS() {
            return startItemVOS;
        }
    }

    public static class CategoriesProgramLoadedEvent {
        private List<CategoriesProgramDataVO> categoriesProgramDataVOS;

        public CategoriesProgramLoadedEvent(List<CategoriesProgramDataVO> categoriesProgramDataVOS) {
            this.categoriesProgramDataVOS = categoriesProgramDataVOS;
        }

        public List<CategoriesProgramDataVO> getCategoriesProgramDataVOS() {
            return categoriesProgramDataVOS;
        }
    }

    public static class AllDataLoadedEvent {

    }
}
