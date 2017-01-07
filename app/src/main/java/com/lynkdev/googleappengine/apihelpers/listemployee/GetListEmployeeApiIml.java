package com.lynkdev.googleappengine.apihelpers.listemployee;

import android.app.Activity;
import android.util.Log;

import com.lynkdev.googleappengine.Model.Employee;
import com.lynkdev.googleappengine.apihelpers.BaseRetrofitIml;
import com.lynkdev.googleappengine.listeners.OnGetListListener;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetListEmployeeApiIml extends BaseRetrofitIml {
    String TAG = GetListEmployeeApiIml.class.getSimpleName();
    private GetListEmployeeApi apiService;
    private Activity activity;
    public GetListEmployeeApiIml() {
        apiService = getRetrofit().create(GetListEmployeeApi.class);
    }

    public void getListEmployee(final OnGetListListener dataCallback) {
        Call<ResponseBody> getEmployee = apiService.getListEmployee();
        getEmployee.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject ob = new JSONObject(response.body().string());
                    JSONArray arr = ob.getJSONArray("items");
                    dataCallback.onFetchSuccess(Employee.getListEmployee(arr));
                } catch (Exception e) {
                    dataCallback.onFetchFault(e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, t.toString());
                dataCallback.onFetchFault(new Exception(t));
            }
        });
    }

}
