package myanmar.keyfields.app.pocsimplehabits.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ZNMSW on 26-May-18.
 */
public class TopicVO implements BaseCompoment {
    @SerializedName("topic-name")
    private String topicId;

    @SerializedName("topic-desc")
    private String topicDesc;

    @SerializedName("icon")
    private String icon;

    @SerializedName("background")
    private String background;

    public TopicVO(String topicId, String topicDesc, String icon, String background) {
        this.topicId = topicId;
        this.topicDesc = topicDesc;
        this.icon = icon;
        this.background = background;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
