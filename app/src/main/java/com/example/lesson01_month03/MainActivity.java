package com.example.lesson01_month03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button editButton;
    TextView nameTV;
    TextView ageTV;
    Button addphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editButton=findViewById(R.id.edit_btn);
        nameTV=findViewById(R.id.name_tv);
        ageTV=findViewById(R.id.age_tv);
        addphoto=findViewById(R.id.gallery_btn);

        ActivityResultLauncher<Intent>profile=registerForActivityResult(new ActivityResultContracts.
                StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode()== Activity.RESULT_OK){
                   nameTV.setText(result.getData().getStringExtra("username"));
                    ageTV.setText(result.getData().getStringExtra("userage"));
                }

            }
        });


        addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent- new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,editActivity.class);
                // startActivity(intent);
                profile.launch(intent);

            }
        });
    }

}