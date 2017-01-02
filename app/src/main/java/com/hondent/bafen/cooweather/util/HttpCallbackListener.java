package com.hondent.bafen.cooweather.util;

/**
 * Created by bafen on 2017/1/1.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
