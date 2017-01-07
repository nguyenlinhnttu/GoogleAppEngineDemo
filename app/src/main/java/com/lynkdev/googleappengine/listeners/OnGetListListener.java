package com.lynkdev.googleappengine.listeners;

import com.lynkdev.googleappengine.Model.Employee;

import java.util.ArrayList;

/**
 * Created by Ryan on 6/8/16.
 */
public interface OnGetListListener {
    void onFetchSuccess(ArrayList<Employee> list);
    void onFetchFault(Exception e);
}
