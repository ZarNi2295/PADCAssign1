package myanmar.keyfields.app.pocsimplehabits.network;

/**
 * Created by aung on 12/3/17.
 */

public interface TopicsDataAgent {

    void loadTopics(String accessToken, int pageNo);

    void loadCurrentProgram(String accessToken, int pageNo);

    void loadCategoriesProgram(String accessToken, int pageNo);
}
