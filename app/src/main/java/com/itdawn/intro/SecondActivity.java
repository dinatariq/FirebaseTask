package com.itdawn.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myText=findViewById(R.id.myText);
        int myInt=getIntent().getIntExtra("myInt",0);
        myText.setText(String.valueOf(myInt));
    }
}