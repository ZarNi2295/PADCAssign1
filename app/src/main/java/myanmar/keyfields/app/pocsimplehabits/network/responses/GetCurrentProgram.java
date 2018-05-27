package myanmar.keyfields.app.pocsimplehabits.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import myanmar.keyfields.app.pocsimplehabits.data.vo.StartItemVO;
import myanmar.keyfields.app.pocsimplehabits.data.vo.TopicVO;

/**
 * Created by ZNMSW on 27-May-18.
 */
public class GetCurrentProgram {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("currentProgram")
    private StartItemVO startItemVOS;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public StartItemVO getStartItemVOS() {
        return startItemVOS;
    }
}
