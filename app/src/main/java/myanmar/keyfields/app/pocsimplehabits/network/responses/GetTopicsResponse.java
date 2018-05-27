package myanmar.keyfields.app.pocsimplehabits.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import myanmar.keyfields.app.pocsimplehabits.data.vo.TopicVO;

/**
 * Created by aung on 12/3/17.
 */

public class GetTopicsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int pageNo;

    @SerializedName("topics")
    private List<TopicVO> topicVOList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPageNo() {
        return pageNo;
    }

    public List<TopicVO> getTopicVOList() {
        if (topicVOList == null) {
            topicVOList = new ArrayList<>();
        }
        return topicVOList;
    }
}
