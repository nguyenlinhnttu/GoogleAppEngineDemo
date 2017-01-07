package com.lynkdev.googleappengine.listeners;

import org.json.JSONObject;

/**
 * Created by Ryan on 6/8/16.
 */
public interface OnCreateListener {
    void onFetchSuccess(JSONObject jsonObject);
    void onFetchFault(Exception e);
}
