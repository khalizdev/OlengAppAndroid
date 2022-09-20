package com.example.olengcompany.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.olengcompany.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class utama extends Fragment {
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    TextView idemail, idstatus, idnama;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    public utama() {
    }
    public static utama newInstance(String param1, String param2) {
        utama fragment = new utama();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_utama, container, false);
        idemail = view.findViewById(R.id.id_email);
        idnama = view.findViewById(R.id.id_nama);
        idemail.setText(user.getEmail());

//        databaseReference = firebaseDatabase.getReference("clientregist").child(user.getUid()).child("clientnamalengkap")
//                .getClass()
//        idnama.setText((CharSequence) databaseReference);



        return view;
    }
}