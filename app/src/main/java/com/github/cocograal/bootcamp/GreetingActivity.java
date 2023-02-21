package com.github.cocograal.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        TextView textView = findViewById(R.id.greetingMessage);
        textView.setText(String.format("Welcome %s", name));

    }
}