package myanmar.keyfields.app.pocsimplehabits.events;


import java.util.List;

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
        private List<TopicVO> loadNews;

        public NewsTopicsLoadedEvent(int loadedPageIndex, List<TopicVO> loadNews) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadNews = loadNews;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<TopicVO> getLoadNews() {
            return loadNews;
        }
    }
}
