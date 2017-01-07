package com.lynkdev.googleappengine.apihelpers.createemployee;

import android.util.Log;

import com.google.gson.Gson;
import com.lynkdev.googleappengine.Model.Employee;
import com.lynkdev.googleappengine.apihelpers.BaseRetrofitIml;
import com.lynkdev.googleappengine.listeners.OnCreateListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LynkMieu on 11/30/2016.
 */

public class CreateEmployeeApiIml extends BaseRetrofitIml {

    private CreateEmployeeApi createEmployeeApi;

    public CreateEmployeeApiIml() {
        createEmployeeApi = getRetrofit().create(CreateEmployeeApi.class);
    }

    public void createEmployee(Employee employee, final OnCreateListener listener) {
        Gson gson = new Gson();
        String json = gson.toJson(employee, Employee.class);
        final RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Log.d("abc", "createEmployee: "+ json);
        Call<ResponseBody> call = createEmployeeApi.createEmployee(body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        listener.onFetchSuccess(jsonObject);
                        Log.d("abc", "onResponse: "+jsonObject.toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
               listener.onFetchFault(new Exception(t));
            }
        });

    }


}
