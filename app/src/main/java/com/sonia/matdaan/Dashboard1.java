package com.sonia.matdaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Dashboard1 extends AppCompatActivity{
ImageView evm;
ImageView cmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard1);

        evm=findViewById(R.id.evm);
        evm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Parties.class));
                //Toast.makeText(Dashboard.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cmp=findViewById(R.id.cmp);
        cmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Complaint.class));
            }
        });

    }
}
