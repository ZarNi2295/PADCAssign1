package myanmar.keyfields.app.pocsimplehabits.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesProgramDataVO implements BaseCompoment {

    @SerializedName("category-id")
    String categoryId;
    @SerializedName("title")
    String title;
    @SerializedName("programs")
    List<ProgramVO> programs;

    public CategoriesProgramDataVO() {

    }


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProgramVO> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramVO> programs) {
        this.programs = programs;
    }
}


