package com.example.igor.atividade3_;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Igor on 10/04/2016.
 */
public class Activity2  extends AppCompatActivity {

    public final static String MSG = "com.example.igor.atividade3_.MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Intent intent = getIntent();
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(intent.getStringExtra(MainActivity.MSG));

    }
    public void sendMessage(View v) {
        Intent intent = new Intent();
        EditText editText = (EditText)findViewById(R.id.editText);
        intent.putExtra(MSG, editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}