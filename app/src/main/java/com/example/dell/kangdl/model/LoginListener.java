package com.example.dell.kangdl.model;

/**
 * Created by DELL on 2018/5/8.
 */

public interface LoginListener {
    void LoginSuccess(String json);
    void LoginError(String error);
}
