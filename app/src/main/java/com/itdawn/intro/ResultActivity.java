package com.itdawn.intro;


import androidx.appcompat.app.AppCompatActivity;

import androidx.viewbinding.ViewBinding;

import android.content.Intent;
import android.os.Bundle;



public class ResultActivity extends AppCompatActivity {
    //

    //

    ActivityResultBinding resultBinding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            resultBinding = ViewBinding.setdataSentView(this, R.layout.activity_result);
            //

            Intent receivedIntent = getIntent();
            resultBinding.dataSent.setText(receivedIntent.getStringExtra("myString"));

            resultBinding.sendToActivity.setOnClickListener(view -> {
                Intent intent=getIntent();
                intent.putExtra("myData","I am from Result Activity");
                setResult(RESULT_OK, intent);
                finish();
            });
        }
    }