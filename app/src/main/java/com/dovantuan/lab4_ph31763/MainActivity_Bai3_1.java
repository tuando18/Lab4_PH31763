package com.dovantuan.lab4_ph31763;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_Bai3_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai31);

        EditText edtUsername = findViewById(R.id.edt_User);
        EditText edtPassword = findViewById(R.id.edt_pass);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
//        edtUsername.setText(data.getString("username"));
//        edtPassword.setText(data.getString("password"));
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("username");
//        String pass = intent.getStringExtra("password");
//        edtUsername.setText(name);
//        edtPassword.setText(pass);

        Button btnLogin = findViewById(R.id.btn_login);
        Button btnSign = findViewById(R.id.btn_dk);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_Bai3_1.this, MainActivity_Bai3_2.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bundle != null) {
                    String user = bundle.getString("username");
                    String pass = bundle.getString("password");

                    boolean u = user.equals(edtUsername.getText().toString());
                    boolean p = pass.equals(edtPassword.getText().toString());

                    if (u && p) {
                        Toast.makeText(MainActivity_Bai3_1.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity_Bai3_1.this, HomeActivity.class));
                    } else {
                        Toast.makeText(MainActivity_Bai3_1.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}