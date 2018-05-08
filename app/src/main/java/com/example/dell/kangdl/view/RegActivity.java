package com.example.dell.kangdl.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.kangdl.R;
import com.example.dell.kangdl.model.IModelImpl;
import com.example.dell.kangdl.presenter.PresenterImpl;

/**
 * Created by DELL on 2018/5/8.
 */

public class RegActivity extends AppCompatActivity implements RegView,View.OnClickListener{

    private EditText edit_name;
    private EditText edit_pass;
    private Button btn_reg;
    private PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        initViews();

    }

    private void initViews() {
        edit_name = (EditText) findViewById(R.id.mobile);
        edit_pass = (EditText) findViewById(R.id.pwd);
        btn_reg = (Button) findViewById(R.id.reg);

        btn_reg.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reg:
                presenter = new PresenterImpl();
                presenter.regPresenter(new IModelImpl(),this);
                break;
        }
    }

    @Override
    public String getUsername() {
        return edit_name.getText().toString();
    }

    @Override
    public String getPassword() {
        return edit_pass.getText().toString();
    }



    @Override
    public void showSuccessMsg() {
        Toast.makeText(RegActivity.this, "注册成功---", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMsg() {
        Toast.makeText(RegActivity.this, "注册失败---", Toast.LENGTH_SHORT).show();
    }
}
