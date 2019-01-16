package com.example.yoons.da;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Code_cpp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_cpp);

    }
    public void cbutton(View v){
        final EditText edit =  (EditText) findViewById(R.id.edit_text);
        TextView textView = (TextView) findViewById(R.id.view);
        Log.v("EditText", edit.getText().toString());

        //get text from edittext and convert it to string
        String messageString=edit.getText().toString();
        //set string from edittext to textview
        textView.setText(messageString);
        //clear edittext after sending text to message
        //editMessage.setText("");
    }

}
