package com.sonia.matdaan;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class cr2 extends AppCompatActivity {
    private EditText mAddress, mVoterid;
    private TextView TextView;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference mroot = db.getReference().child("Users_info");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cr2);

        mAddress = findViewById(R.id.Address);
        mVoterid = findViewById(R.id.voterid);
        TextView = findViewById(R.id.btn);



        TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Adress  = mAddress.getText().toString();
                String  voterid = mVoterid.getText().toString();

                HashMap<String , String> usermap = new HashMap<>();

                usermap.put("Address", Adress);
                usermap.put("voterid" ,voterid);

                mroot.setValue(usermap);

                Intent intent = new Intent(cr2.this, Userinfo.class);
                startActivity(intent);


            }
        });

    }
}