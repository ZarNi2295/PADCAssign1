package myanmar.keyfields.app.pocsimplehabits.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ZNMSW on 26-May-18.
 */
public class TopicVO {
    @SerializedName("topic-name")
    private String newsId;

    @SerializedName("topic-desc")
    private String brief;

    @SerializedName("icon")
    private String details;

    @SerializedName("background")
    private List<String> images;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
