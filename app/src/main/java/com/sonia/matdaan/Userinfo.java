package com.sonia.matdaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Userinfo extends AppCompatActivity {
    //variable
    private EditText mName, mFathersname, mMothersname, mPhone, mAadhar;
    private ImageView mImageBtn, menutop;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;


    ListView mylistview;

    ArrayList<String> myArrayList = new ArrayList<>();

    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);



        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(Userinfo.this,android.R.layout.simple_list_item_1,myArrayList);
        mylistview = (ListView) findViewById(R.id.listview1);

        mylistview.setAdapter(myArrayAdapter);
        mRef = FirebaseDatabase.getInstance().getReference().child("Users_m");

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                String value = dataSnapshot.getValue(String.class);
                myArrayList.add(value);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                myArrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_userinfo);


//        mName = findViewById(R.id.Name);
//        mFathersname = findViewById(R.id.Fathersname);
//        mMothersname = findViewById(R.id.mothersname);
//        mAadhar=findViewById(R.id.aadhar);
//        mPhone = findViewById(R.id.phone);
//        mImageBtn = findViewById(R.id.imgUserProfile);
//
//        StorageReference mImageStorage = FirebaseStorage.getInstance().getReference();
//
//        FirebaseUser mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
//        String current_uid = mCurrentUser.getUid();
//
//        DatabaseReference mUserDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);
//        mUserDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String name = snapshot.child("name").getValue().toString();
//                String image = snapshot.child("image").getValue().toString();
//                String status = snapshot.child("status").getValue().toString();
//                String thumb_image = snapshot.child("thumb_image").getValue().toString();
//
//                mName.setText(name);
//                //mStatus.setText(status);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        user = FirebaseAuth.getInstance().getCurrentUser();
//        reference = FirebaseDatabase.getInstance().getReference("users");
//        userID = user.getUid();
//
//        final TextView mNameTextview = (TextView) findViewById(R.id.reg_Name);
//        final TextView maddressTextview = (TextView) findViewById(R.id.Address);
//         final TextView mAadharTextview = (TextView) findViewById(R.id.aadhar);
//        final TextView mPhoneTextview = (TextView) findViewById(R.id.phone);
//
//        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                gender userProfile = snapshot.getValue(gender.class);
//
//                if (userProfile != null){
//                    String mName = userProfile.mName;
//                    String mAadhar = userProfile.mAadhar;
//                    String mPhone = userProfile.mPhone;
//
//                   mNameTextview.setText(mName);
//                   mAadharTextview.setText(mAadhar);
//                   mPhoneTextview.setText(mPhone);
//
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(Userinfo.this, "something wrong happened!", Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//

    }
}