package com.example.yoons.da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View v){
        Toast.makeText(getApplicationContext(), "시작버튼이 눌렸어요", Toast.LENGTH_LONG).show();
        Intent intent=new Intent(getApplicationContext(),Code_cpp.class);
        startActivity(intent);
    }
}
