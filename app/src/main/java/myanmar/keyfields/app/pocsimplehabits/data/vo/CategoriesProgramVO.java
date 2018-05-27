package myanmar.keyfields.app.pocsimplehabits.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesProgramVO {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("apiVersion")
    private String apiVersion;
    @SerializedName("page")
    private String page;
    @SerializedName("categoriesPrograms")
    private List<CategoriesProgramDataVO> categoriesPrograms;

    public CategoriesProgramVO() {
    }

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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<CategoriesProgramDataVO> getCategoriesPrograms() {
        return categoriesPrograms;
    }

    public void setCategoriesPrograms(List<CategoriesProgramDataVO> categoriesPrograms) {
        this.categoriesPrograms = categoriesPrograms;
    }
}
