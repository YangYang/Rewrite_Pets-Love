package com.imudges.yy.Pets_Love;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    public EditText et_email;
    public EditText et_password;
    public Button btn_login;
    public Button btn_signin;
    public Map<String ,String > userMessage;
    public void initData() {
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_signin = (Button) findViewById(R.id.btn_sign_in);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initData();
        setButtonClick();
    }
    public void setButtonClick(){
        btn_login.setOnClickListener(this);
        btn_signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_login:{

            }
            case R.id.btn_sign_in:{
                Intent intent = new Intent(MainActivity.this,SignInAcitivity.class);
                startActivityForResult(intent,2);//2代表注册
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2 && resultCode == 2){
            Bundle bundle = data.getExtras();
            String test =bundle.getString("email");

            Toast.makeText(this,test,Toast.LENGTH_SHORT).show();
        }
    }
}
