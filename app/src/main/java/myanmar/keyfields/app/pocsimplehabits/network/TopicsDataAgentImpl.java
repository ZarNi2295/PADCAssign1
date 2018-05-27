package myanmar.keyfields.app.pocsimplehabits.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import myanmar.keyfields.app.pocsimplehabits.events.RestApiEvents;
import myanmar.keyfields.app.pocsimplehabits.network.responses.GetCategoriesProgramResponse;
import myanmar.keyfields.app.pocsimplehabits.network.responses.GetCurrentProgram;
import myanmar.keyfields.app.pocsimplehabits.network.responses.GetTopicsResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TopicsDataAgentImpl implements TopicsDataAgent {

    private static TopicsDataAgentImpl objInstance;

    private TopicsAPI theAPI;

    private TopicsDataAgentImpl() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        theAPI = retrofit.create(TopicsAPI.class);

    }

    public static TopicsDataAgentImpl getInstance() {
        if (objInstance == null) {
            objInstance = new TopicsDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void loadTopics(String accessToken, int pageNo) {
        Call<GetTopicsResponse> loadMMNewsCall = theAPI.loadTopics(pageNo, accessToken);
        loadMMNewsCall.enqueue(new Callback<GetTopicsResponse>() {
            @Override
            public void onResponse(Call<GetTopicsResponse> call, Response<GetTopicsResponse> response) {
                GetTopicsResponse getNewsResponse = response.body();
                if (getNewsResponse != null
                        && getNewsResponse.getTopicVOList().size() > 0) {
                    RestApiEvents.NewsTopicsLoadedEvent newsDataLoadedEvent = new RestApiEvents.NewsTopicsLoadedEvent(
                            getNewsResponse.getPageNo(), getNewsResponse.getTopicVOList());
                    EventBus.getDefault().post(newsDataLoadedEvent);
                } else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetTopicsResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

    @Override
    public void loadCurrentProgram(String accessToken, int pageNo) {
        Call<GetCurrentProgram> getCurrentProgramCall = theAPI.loadCurrentProgram(pageNo, accessToken);
        getCurrentProgramCall.enqueue(new Callback<GetCurrentProgram>() {
            @Override
            public void onResponse(Call<GetCurrentProgram> call, Response<GetCurrentProgram> response) {
                GetCurrentProgram getNewsResponse = response.body();
                if (getNewsResponse != null) {
                    RestApiEvents.CurrentProgramLoadedEvent newsDataLoadedEvent = new RestApiEvents.CurrentProgramLoadedEvent(
                           getNewsResponse.getStartItemVOS());
                    EventBus.getDefault().post(newsDataLoadedEvent);
                } else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCurrentProgram> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }

    @Override
    public void loadCategoriesProgram(String accessToken, int pageNo) {
        Call<GetCategoriesProgramResponse> getCurrentProgramCall = theAPI.loadCategoriesProgram(pageNo, accessToken);
        getCurrentProgramCall.enqueue(new Callback<GetCategoriesProgramResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesProgramResponse> call, Response<GetCategoriesProgramResponse> response) {
                GetCategoriesProgramResponse getNewsResponse = response.body();
                if (getNewsResponse != null
                        && getNewsResponse.getCategoriesProgramDataVOS().size() > 0) {
                    RestApiEvents.CategoriesProgramLoadedEvent newsDataLoadedEvent = new RestApiEvents.CategoriesProgramLoadedEvent(
                            getNewsResponse.getCategoriesProgramDataVOS());
                    EventBus.getDefault().post(newsDataLoadedEvent);
                } else {
                    RestApiEvents.ErrorInvokingAPIEvent errorEvent
                            = new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now. Pls try again later.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetCategoriesProgramResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorEvent = new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }
}
