package com.example.dell.kangdl.presenter;

import com.example.dell.kangdl.model.IModel;
import com.example.dell.kangdl.view.LoginView;
import com.example.dell.kangdl.view.RegView;

/**
 * Created by DELL on 2018/5/8.
 */

public interface IPresenter {
    void loginPresenter(IModel iModel, LoginView loginView);
    void regPresenter(IModel iModel, RegView regView);
}
