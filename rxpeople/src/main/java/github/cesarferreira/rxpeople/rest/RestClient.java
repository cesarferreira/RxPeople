package github.cesarferreira.rxpeople.rest;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RestClient {

    private ApiService api;

    private final String BASE_URL = "http://api.randomuser.me";

    public RestClient() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setEndpoint(BASE_URL)
                .setRequestInterceptor(new SessionRequestInterceptor())
                .setClient(new OkClient())
                .build();

        api = restAdapter.create(ApiService.class);
    }

    public ApiService getAPI() {
        return api;
    }
}
