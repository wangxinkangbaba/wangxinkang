package com.example.dell.kangdl.presenter;

import com.example.dell.kangdl.http.HttpConfig;
import com.example.dell.kangdl.model.IModel;
import com.example.dell.kangdl.model.LoginListener;
import com.example.dell.kangdl.model.RegListener;
import com.example.dell.kangdl.view.LoginView;
import com.example.dell.kangdl.view.RegView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 2018/5/8.
 */

public class PresenterImpl implements IPresenter{

    @Override
    public void loginPresenter(IModel iModel, final LoginView loginView) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",loginView.getUsername());
        map.put("password",loginView.getPassword());
        iModel.loginModel(HttpConfig.login_url, map, new LoginListener() {
            @Override
            public void LoginSuccess(String json) {
                loginView.showSuccessMsg();
            }

            @Override
            public void LoginError(String error) {
                loginView.showErrorMsg();
            }
        });
    }

    @Override
    public void regPresenter(IModel iModel,final RegView regView) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",regView.getUsername());
        map.put("password",regView.getPassword());
        iModel.regModel(HttpConfig.reg_url, map, new RegListener() {
            @Override
            public void regSuccess(String json) {
                regView.showSuccessMsg();
            }

            @Override
            public void regError(String error) {
                regView.showErrorMsg();
            }
        });
    }
}
