package myanmar.keyfields.app.pocsimplehabits.network;

import myanmar.keyfields.app.pocsimplehabits.network.responses.GetCategoriesProgramResponse;
import myanmar.keyfields.app.pocsimplehabits.network.responses.GetCurrentProgram;
import myanmar.keyfields.app.pocsimplehabits.network.responses.GetTopicsResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aung on 12/3/17.
 */

public interface TopicsAPI {

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicsResponse> loadTopics(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);


    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentProgram> loadCurrentProgram(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);


    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoriesProgramResponse> loadCategoriesProgram(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);
}
