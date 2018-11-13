package com.example.administrator.androidpractice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText account_login;
    private  EditText password_login;
    private CheckBox remember_login;
    private  CheckBox autologin_login;
    private Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public  void init(){
        button_login=findViewById(R.id.login_button);
        account_login=findViewById(R.id.account);
        password_login=findViewById(R.id.password);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid=account_login.getText().toString().trim();
                String userpass=password_login.getText().toString().trim();
                if (userid.equals("")){
                    Toast.makeText(MainActivity.this,R.string.loginError,Toast.LENGTH_LONG).show();
                    return;
                }
                if (userpass.equals("")){
                    Toast.makeText(MainActivity.this,R.string.passError,Toast.LENGTH_LONG).show();
                    return;
                }
                if (userid.equals("admin")&&userpass.equals("admin")){
                    Toast.makeText(MainActivity.this,R.string.loginSuccess,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,R.string.loginError,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

