package com.example.dell.kangdl.http;

/**
 * Created by DELL on 2018/5/8.
 */

public interface OkLoadListener {
    void okLoadSuccess(String json);
    void okLoadError(String error);
}
