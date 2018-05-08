package com.example.dell.kangdl.model;

/**
 * Created by DELL on 2018/5/8.
 */

public interface RegListener {
    void regSuccess(String json);
    void regError(String error);
}
