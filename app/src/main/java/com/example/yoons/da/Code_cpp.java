package com.example.yoons.da;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;


public class Code_cpp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_cpp);
        TextView textView = (TextView) findViewById(R.id.view);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void cbutton(View v) {
        final EditText edit = (EditText) findViewById(R.id.edit_text);
        TextView textView = (TextView) findViewById(R.id.view);
        Log.v("EditText", edit.getText().toString());

        //get text from edittext and convert it to string
        String messageString = edit.getText().toString();
        //set string from edittext to textview
        textView.setText(messageString);
        //clear edittext after sending text to message
        //editMessage.setText("");

    }

    public void aa(View v){
        try {

            // Executes the command.

           Process process = Runtime.getRuntime().exec("system/bin/mkdir/data/data/com.example.yoons.da; /system/bin/cd /data/data/com.example.yoons.da;system/bin/pwd; ");
///system/bin/mkdir /data/data/com.example.yoons.da;
          //  Process process = Runtime.getRuntime().exec("/data/local/bin:/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin\n  ");
            // Reads stdout.
            // NOTE: You can write to stdin of the command using
            //       process.getOutputStream().
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();

            // Waits for the command to finish.
            process.waitFor();

            //return output.toString();
            String result=output.toString();
            TextView textView = (TextView) findViewById(R.id.view);
            textView.setText(result);

        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }
}




