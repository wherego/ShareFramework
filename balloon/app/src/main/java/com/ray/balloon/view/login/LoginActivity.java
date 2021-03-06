package com.ray.balloon.view.login;

import android.content.Intent;
import android.os.Bundle;

import com.corelibs.base.BaseActivity;
import com.ray.balloon.R;
import com.ray.balloon.presenter.LoginPresenter;
import com.ray.balloon.view.main.MainActivity;

import butterknife.Bind;
import butterknife.OnClick;
import carbon.widget.Button;
import carbon.widget.CheckBox;
import carbon.widget.EditText;
import carbon.widget.Toolbar;

/**
 * Created by Administrator on 2016/2/29.
 */
public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.et_password)
    EditText et_password;
    @Bind(R.id.remember_enabled)
    CheckBox remember_enabled;
    @Bind(R.id.btn_login)
    Button btn_login;
    @Bind(R.id.btn_reg)
    Button btn_reg;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        toolbar.setText(R.string.login_title);
        toolbar.setBackgroundColor(getResources().getColor(R.color.main));
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @OnClick(R.id.btn_login)
    protected void login() {
        getPresenter().login(et_phone.getText().toString(), et_password.getText().toString());
    }

    @OnClick(R.id.btn_reg)
    protected void register() {
        Intent it =new Intent(this,RegisterActivity.class);
        startActivity(it);
    }


    @Override
    public void loginSuccess() {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}
