package com.example.platzigram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.platzigram.view.ContainerActivity;
import com.example.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UI();

        textView.setOnClickListener(v -> {
                Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
                startActivity(intent);
        });


    }

    public void UI(){
        textView = (TextView) findViewById(R.id.createhere);
    }
}
