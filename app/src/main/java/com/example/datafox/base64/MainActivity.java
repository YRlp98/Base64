package com.example.datafox.base64;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Objects
    private TextView TVMainText;
    private TextView TVCoded;
    private TextView TVDecoded;
    private String userText;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find string objects
        TVMainText = findViewById(R.id.TVMainText);
        TVCoded = findViewById(R.id.TVCoded);
        TVDecoded = findViewById(R.id.TVDecoded);

    }

    //String Text
    public void submitOnClick(View view) {

        String testValue = "Hello World!";

        EditText editText = findViewById(R.id.edtText);
        userText = editText.getText().toString();

        TVMainText.setText(new String(userText));
        TVCoded.setText(new String(code()));
        TVDecoded.setText(new String(deCode()));

        Log.d("Test", "defaultValue = " + testValue);
        Log.d("Test", "codedValue = " + new String(code()));
        Log.d("Test", "decodedValue = " + new String(deCode()));
    }

    private byte[] code() {
        return android.util.Base64.encode(userText.getBytes(), android.util.Base64.DEFAULT);
    }

    private byte[] deCode() {
        return android.util.Base64.decode(code(), android.util.Base64.DEFAULT);
    }
}