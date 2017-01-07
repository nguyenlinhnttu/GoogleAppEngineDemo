package com.lynkdev.googleappengine.presenter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.lynkdev.googleappengine.Adapter.EmployeeAdapter;
import com.lynkdev.googleappengine.Model.Employee;
import com.lynkdev.googleappengine.apihelpers.listemployee.GetListEmployeeApiIml;
import com.lynkdev.googleappengine.listeners.OnGetListListener;

import java.util.ArrayList;

/**
 * Created by LynkMieu on 11/22/2016.
 */

public class ListEmployeePresenter {
    private EmployeeAdapter employeeAdapter;
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private Activity activity;
    private GetListEmployeeApiIml apiServiceIml;


    public ListEmployeePresenter(Activity activity) {
        this.activity = activity;
        this.apiServiceIml = new GetListEmployeeApiIml();
    }

    /**
     * parse data
     * Noti adapter
     * */
    public void fetchData(final RecyclerView recyclerView) {
        apiServiceIml.getListEmployee(new OnGetListListener() {
            @Override
            public void onFetchSuccess(ArrayList<Employee> list) {
                employeeList.clear();
                employeeList.addAll(list);
                employeeAdapter = new EmployeeAdapter(activity,employeeList);
                recyclerView.setAdapter(employeeAdapter);
                employeeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFetchFault(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
