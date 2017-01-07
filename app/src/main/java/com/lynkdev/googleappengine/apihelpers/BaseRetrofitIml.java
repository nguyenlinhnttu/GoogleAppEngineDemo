package com.lynkdev.googleappengine.apihelpers;


import com.lynkdev.googleappengine.util.Config;

import retrofit2.Retrofit;

/**
 * Created by darkpiv on 17/10/2016.
 */

public abstract class BaseRetrofitIml {
    private Retrofit retrofit;

    protected Retrofit getRetrofit() {
        if (retrofit == null)
            return new Retrofit.Builder().baseUrl(Config.BASE_URL).build();
        else return retrofit;
    }

}
