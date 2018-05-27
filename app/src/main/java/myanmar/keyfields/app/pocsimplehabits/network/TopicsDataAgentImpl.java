package myanmar.keyfields.app.pocsimplehabits.network;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import myanmar.keyfields.app.pocsimplehabits.events.RestApiEvents;
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
        Call<GetTopicsResponse> loadMMNewsCall = theAPI.loadMMNews(pageNo, accessToken);
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
}
