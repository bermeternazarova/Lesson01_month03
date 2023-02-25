package com.example.lesson01_month03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editActivity extends AppCompatActivity {
    EditText nameEt;
    EditText ageEt;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        nameEt=findViewById(R.id.name_et);
        ageEt=findViewById(R.id.age_et);
        saveBtn=findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String name = nameEt.getText().toString();
                String age = ageEt.getText().toString();
                intent.putExtra("username",name);
                intent.putExtra("userage",age);
                setResult(RESULT_OK ,intent);
                finish();
            }
        });
    }
}