package com.lynkdev.googleappengine.apihelpers.createemployee;

import com.lynkdev.googleappengine.util.Config;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by LynkMieu on 11/30/2016.
 */

public interface CreateEmployeeApi {
    @POST(Config.CREATE_API)
    Call<ResponseBody> createEmployee(@Body RequestBody body);
}
