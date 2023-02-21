package com.github.cocograal.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void greet(View view) {
        EditText edText = (EditText) findViewById(R.id.editPersonNameText);
        String name = edText.getText().toString();
        System.out.println(name);

        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}