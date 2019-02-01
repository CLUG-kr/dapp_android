package com.example.yoons.da;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Code_cpp extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_cpp);
        TextView textView = (TextView) findViewById(R.id.view);
        textView.setMovementMethod(new ScrollingMovementMethod());
        context = this;


    }

    public void compilebutton(View v) {
        final EditText edit = (EditText) findViewById(R.id.edit_text);
        TextView textView = (TextView) findViewById(R.id.view);
        Log.v("EditText", edit.getText().toString());

        //get text from edittext and convert it to string
        String messageString = edit.getText().toString();
        //set string from edittext to textview
        //textView.setText(messageString);
        //clear edittext after sending text to message
        //editMessage.setText("");


        writeToFile(messageString,context);
        Toast.makeText(getApplicationContext(), "된듯", Toast.LENGTH_LONG).show();

    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.c", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            Log.e("Success", "File write Success ");
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public void savebutton(View v){
        String msg = readFromFile(context);
        EditText edit = (EditText) findViewById(R.id.edit_text);
        edit.setText(msg);

    }
    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.c");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString).append("\n");
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
    public void aa(View v){
        try {
            /*File path = context.getFilesDir();
            path.setReadable(true); //Sets all permissions for every owner back to read-only
            path.setWritable(true); //Sets the owner's permissions to writeable
            path.setExecutable(true);*/


            // Executes the command.

           //Process process = Runtime.getRuntime().exec("system/bin/ls/data/data/com.example.yoons.da/files");
            // Process process = Runtime.getRuntime().exec("chmod -777 /data/data/com.example.yoons.da&&g++ config.cpp&&./a.out");
            Process process = Runtime.getRuntime().exec("chmod 777  /data/data/com.example.yoons.da/config.cpp");
///system/bin/mkdir /data/data/com.example.yoons.da;
          //  Process process = Runtime.getRuntime().exec("/data/local/bin:/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin\n  ");
            // Reads stdout.
            // NOTE: You can write to stdin of the command using
            //       process.getOutputStream().7
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();

            // Waits for the command to finish.
            process.waitFor();


            Log.v("MSG","1");
             process = Runtime.getRuntime().exec("ls");//gcc config.c -o a");
             //process=Runtime.getRuntime().exec("gcc config.c");
///system/bin/mkdir /data/data/com.example.yoons.da;
            //  Process process = Runtime.getRuntime().exec("/data/local/bin:/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin\n  ");
            // Reads stdout.
            // NOTE: You can write to stdin of the command using
            //       process.getOutputStream().7
             reader = new BufferedReader(new InputStreamReader(process.getInputStream()));


            output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();

            // Waits for the command to finish.
            process.waitFor();
            Log.v("MSG","2");



            process=Runtime.getRuntime().exec("g++ config.cpp ");
///system/bin/mkdir /data/data/com.example.yoons.da;
            //  Process process = Runtime.getRuntime().exec("/data/local/bin:/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin\n  ");
            // Reads stdout.
            // NOTE: You can write to stdin of the command using
            //       process.getOutputStream().7
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));


            output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();

            // Waits for the command to finish.
            process.waitFor();
            Log.v("MSG","3");
            //return output.toString();
            String result=output.toString();
            TextView textView = (TextView) findViewById(R.id.view);
            textView.setText(result);
            Log.v("result",output.toString());

        } catch (IOException e) {

            throw new RuntimeException(e);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
    }
}




