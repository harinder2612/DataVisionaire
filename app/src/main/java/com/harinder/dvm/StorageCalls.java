package com.harinder.dvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class StorageCalls extends AppCompatActivity {

    ImageView pic;
    Button dwnbtn;
    StorageReference storageReference= FirebaseStorage.getInstance().getReferenceFromUrl("gs://dvmfirebaseproject-b0ea0.appspot.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_calls);
        Bundle extras= getIntent().getExtras();
        String picName= extras.getString("NameOfScreen");
        pic=findViewById(R.id.dwnPic);
        dwnbtn=findViewById(R.id.dwnbtn);
        final StorageReference myref=storageReference.child(picName.concat(".jpg"));

        System.out.println(picName);

        dwnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Glide.with(StorageCalls.this)
                        .using(new FirebaseImageLoader())
                        .load(myref)
                        .into(pic);
            }
        });


    }
}
