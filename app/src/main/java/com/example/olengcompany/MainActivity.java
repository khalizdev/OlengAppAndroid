package com.example.olengcompany;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.olengcompany.fragment.pengaturan;
import com.example.olengcompany.fragment.riwayat;
import com.example.olengcompany.fragment.utama;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    ChipNavigationBar navbar;
    FragmentManager fragmentManager;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navbar = findViewById(R.id.buttom_navigation);
        if (savedInstanceState == null)
        {
            navbar.setItemSelected(R.id.utama, true);
            fragmentManager = getSupportFragmentManager();
            utama utama =new utama();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_main, utama)
                    .commit();
        }

        navbar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch(i){
                    case R.id.utama:
                        fragment = new utama();
                        break;
                    case R.id.riwayat:
                        fragment = new riwayat();
                        break;
                    case R.id.pengaturan:
                        fragment = new pengaturan();
                        break;
                }
                if (fragment != null)
                {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_main, fragment)
                            .commit();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Kesalahan Jaringan", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}