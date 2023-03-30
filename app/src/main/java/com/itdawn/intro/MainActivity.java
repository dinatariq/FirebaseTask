package com.itdawn.intro;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;



public class MainActivity<savedInstanceState> extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        //

        mainBinding.sendButton.setOnClickListener(view -> Toast.makeText(this, "Send Button", Toast.LENGTH_SHORT).show());
        sendDataToActivity2();
        mainBinding.sendButton.setText("Data received from Result Activity");

        {

        }

        launchForResult();
    }
    ActivityResultLauncher<Intent> activityLauncher ;
    private void launchForResult() {
        Intent intentForResult = new Intent(this, ResultActivity.class);
        activityLauncher.launch(intentForResult);


    }

    private void sendDataToActivity2() {
        Intent sendIntent = new Intent(this, ResultActivity.class);
        sendIntent.putExtra("myString", "I am from Main Activity");
        startActivity(sendIntent);

    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            mainBinding.sendButton.setText(result.getData().getStringExtra("myData"));
        }
    });
}