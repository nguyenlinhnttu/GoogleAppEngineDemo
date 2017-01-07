package com.lynkdev.googleappengine.presenter;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.lynkdev.googleappengine.Model.Employee;
import com.lynkdev.googleappengine.apihelpers.createemployee.CreateEmployeeApiIml;
import com.lynkdev.googleappengine.listeners.OnCreateListener;

import org.json.JSONObject;

/**
 * Created by LynkMieu on 11/30/2016.
 */

public class CreateEmployeePresenter {
    String TAG = CreateEmployeePresenter.class.getSimpleName();
    Activity activity;
    CreateEmployeeApiIml riddleApiIml;

    public CreateEmployeePresenter(Activity activity) {
        this.activity = activity;
        this.riddleApiIml = new CreateEmployeeApiIml();
    }

    public void createEmployeeData(Employee employee){

        riddleApiIml.createEmployee(employee, new OnCreateListener() {
            @Override
            public void onFetchSuccess(JSONObject jsonObject) {
                Log.d("abcc", "onFetchSuccess: "  + jsonObject.toString());
                Employee employee1 = Employee.getEmployee(jsonObject);
                Toast.makeText(activity, employee1.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFetchFault(Exception e) {
                Log.e(TAG,e.toString());
            }
        });
    }
}
