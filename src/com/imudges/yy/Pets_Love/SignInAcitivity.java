package com.imudges.yy.Pets_Love;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import cn.bmob.v3.listener.FindListener;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by yangyang on 2017/1/14.
 */
public class SignInAcitivity extends Activity implements TextWatcher{
    public EditText et_sign_in_email = null;
    public EditText et_sign_in_password = null;
    public EditText et_sign_in_nick_name;
    public RadioGroup sex;
    public RadioButton male;
    public RadioButton female;
    public String userSex;
    public Map<String ,String > userMessage;
    public Button btn_submit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        initData();
        this.sex.setOnCheckedChangeListener(new OnCheckedChangeListenerImp());
        /**
         * 连接Bmob,上传数据
         * */
        /**
         * 返回数据至MainActivity，自动填写刚才注册的信息
         * */
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", (Serializable) userMessage);
        Intent data = new Intent();
        data.putExtras(bundle);//"key=>value"对
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_sign_in_email.addTextChangedListener(SignInAcitivity.this);
                if(et_sign_in_email.getText().toString()!=""&&et_sign_in_password.getText().toString()!=""){
                    setResult(2,data);
                    finish();
                }
                /**
                 * 需要检查email和password是否修改
                 * */
                else{
                    Toast.makeText(SignInAcitivity.this,"请填写您的邮箱或密码",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void initData(){
        btn_submit = (Button) findViewById(R.id.btn_submit_signin);
        et_sign_in_email = (EditText) findViewById(R.id.et_sign_in_email);
        et_sign_in_password = (EditText) findViewById(R.id.et_sign_in_password);
        et_sign_in_nick_name = (EditText) findViewById(R.id.et_sign_in_nick_name);
        sex = (RadioGroup) findViewById(R.id.sex);
        male = (RadioButton) findViewById(R.id.male);
        female =(RadioButton) findViewById(R.id.female);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        userMessage.put("email",et_sign_in_email.getText().toString());
        userMessage.put("password",et_sign_in_password.getText().toString());
    }

    private class OnCheckedChangeListenerImp implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if(male.getId()==i){
                userSex = "male";
            }
            else{
                userSex = "female";
            }
        }
    }
}


