package com.ifading.babynote.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ifading.babynote.R;
import com.ifading.babynote.utils.PatternUtil;
import com.ifading.common.log.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register_ed_username)
    protected EditText mEdUsername;
    @BindView(R.id.register_ed_password)
    protected EditText mEdPassword;
    @BindView(R.id.register_ed_repassword)
    protected EditText mEdRepassword;
    @BindView(R.id.register_ed_phone)
    protected EditText mEdPhoen;
    @BindView(R.id.register_ed_mail)
    protected EditText mEdMail;

    @BindView(R.id.register_btn_register)
    protected Button mBtnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.register_btn_register})
    protected void onclick(View v) {
        if (v == mBtnRegister) {

            String username = mEdUsername.getText().toString();
            String password = mEdPassword.getText().toString();
            String repassword = mEdRepassword.getText().toString();
            String phone = mEdPhoen.getText().toString();
            String email = mEdMail.getText().toString();
            if (username.length() == 0) {
                ToastUtils.showToast("用户名不能为空");
                mEdUsername.requestFocus();
                return;
            }
            if (password.length() == 0) {
                ToastUtils.showToast("密码不能为空");
                return;
            }
            if (repassword.length() == 0) {
                ToastUtils.showToast("确认密码不能为空");

                return;
            }
            if (phone.length() == 0) {
                ToastUtils.showToast("手机号码不能为空");
                return;
            }
            if (email.length() == 0) {
                ToastUtils.showToast("邮箱不能为空");
                return;
            }

            if (!PatternUtil.isPassword(password)||!PatternUtil.isPassword(repassword)) {
                ToastUtils.showToast("密码只有由字母数字下划线组成");
                mEdPassword.setText("");
                mEdRepassword.setText("");
                return;
            }

            if (!PatternUtil. isMobile(phone)) {
                ToastUtils.showToast("请输入正确的手机号");
                return;
            }

            if (!PatternUtil. isEmail(email)) {
                ToastUtils.showToast("邮箱格式错误");

                return;
            }

            if (!password.equals(repassword)) {
                ToastUtils.showToast("确认密码与密码不一致,请确认");
                mEdPassword.setText("");
                mEdRepassword.setText("");
                return;
            }

            // TODO: 20180915// 网络请求去

        }
    }


}
