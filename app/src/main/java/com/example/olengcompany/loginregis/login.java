package com.example.olengcompany.loginregis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.olengcompany.MainActivity;
import com.example.olengcompany.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    TextView on_regis;
    FloatingActionButton login;
    EditText email_login, password_login;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        login = findViewById(R.id.login_button);
        on_regis = findViewById(R.id.on_regis_login);
        email_login = findViewById(R.id.editTextTextPersonName_login);
        password_login = findViewById(R.id.editTextTextPassword_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProcessLogin();
            }
        });

        on_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, registrasi.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void ProcessLogin() {
        String email = email_login.getText().toString();
        String password = password_login.getText().toString();
        if (TextUtils.isEmpty(email))
        {
            Toast.makeText(getApplicationContext(),"Silahkan Mengisi Email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password))
        {
            Toast.makeText(getApplicationContext(),"Silahkan Mengisi Password", Toast.LENGTH_LONG).show();
            return;
        }
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Berhasil Login",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(com.example.olengcompany.loginregis.login.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Akun Tidak Terdaftar, Silahkan Registrasi Terlebih Dahulu",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}