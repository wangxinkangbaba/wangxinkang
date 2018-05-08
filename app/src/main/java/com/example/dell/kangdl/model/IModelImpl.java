package com.example.dell.kangdl.model;

import com.example.dell.kangdl.Bean.LoginBean;
import com.example.dell.kangdl.Bean.RegBean;
import com.example.dell.kangdl.http.OkHttpUtils;
import com.example.dell.kangdl.http.OkLoadListener;
import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by DELL on 2018/5/8.
 */

public class IModelImpl implements IModel{
    @Override
    public void loginModel(final String url, Map<String, String> map, final LoginListener loginListener) {
        OkHttpUtils okHttpUtils= OkHttpUtils.getHttpUtils();
        okHttpUtils.okPost(url,map);
        okHttpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Gson gson=new Gson();
                LoginBean loginBean= gson.fromJson(json, LoginBean.class);
                if (loginBean.getCode().equals("0")){
                    loginListener.LoginSuccess(json);
                }else {
                    loginListener.LoginError(json);
                }
            }

            @Override
            public void okLoadError(String error) {
                loginListener.LoginError(error);
            }
        });
    }

    @Override
    public void regModel(final String url, Map<String, String> map,final RegListener regListener) {
        OkHttpUtils okHttpUtils=OkHttpUtils.getHttpUtils();
        okHttpUtils.okPost(url,map);
        okHttpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Gson gson=new Gson();
                RegBean regBean= gson.fromJson(json, RegBean.class);
                if (regBean.getCode().equals("0")){
                    regListener.regSuccess(json);
                }else {
                    regListener.regError(json);
                }
            }

            @Override
            public void okLoadError(String error) {
                regListener.regError(error);
            }
        });
    }
}
