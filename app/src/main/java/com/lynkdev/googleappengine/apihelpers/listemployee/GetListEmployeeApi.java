package com.lynkdev.googleappengine.apihelpers.listemployee;


import com.lynkdev.googleappengine.util.Config;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by LynkMieu on 11/22/2016.
 */

public interface GetListEmployeeApi {
    @GET(Config.LIST_API)
    Call<ResponseBody> getListEmployee();
}
