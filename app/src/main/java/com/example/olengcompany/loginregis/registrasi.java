package com.example.olengcompany.loginregis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.olengcompany.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registrasi extends AppCompatActivity {
    EditText email_regist, password_regist, namalengkap_regist;
    FloatingActionButton button_regist;
    FirebaseAuth auth;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        email_regist = findViewById(R.id.editTextTextPersonName_regis);
        password_regist = findViewById(R.id.editTextTextPassword_regis);
        namalengkap_regist = findViewById(R.id.editTextTextPersonName_namalengkap);
        button_regist = findViewById(R.id.button_regitrasi);

        button_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProccessRegist();
            }
        });
    }

    private void ProccessRegist() {
        String email = email_regist.getText().toString();
        String password = password_regist.getText().toString();
        String namalengkap = namalengkap_regist.getText().toString();

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

        if (TextUtils.isEmpty(namalengkap))
        {
            Toast.makeText(getApplicationContext(),"Silahkan Mengisi Nama Lengkap", Toast.LENGTH_LONG).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        user = FirebaseAuth.getInstance().getCurrentUser();
                        databaseReference = firebaseDatabase.getReference("clientregis").child(user.getUid());
                        databaseReference.child("clientnamalengkap").setValue(namalengkap)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(getApplicationContext(),"Berhasil Membuat Akun", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(registrasi.this, login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(registrasi.this, "Terjadi kesalahan, silahkan mencoba beberapa saat", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
    }
}