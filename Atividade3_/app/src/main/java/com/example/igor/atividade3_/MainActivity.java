package com.example.igor.atividade3_;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String MSG = "com.example.igor.atividade3_.MSG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnviarTexto(View v){
        Intent intent = new Intent(this, Activity2.class);
        EditText editText = (EditText)findViewById(R.id.editText);
        intent.putExtra(MSG, editText.getText().toString());
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int reqCode, int resCode, Intent intent){
        super.onActivityResult(reqCode, resCode, intent);
        if (reqCode == 1){
            if (resCode == RESULT_OK){
                TextView msg = (TextView)findViewById(R.id.textView);
                msg.setText(intent.getStringExtra(MSG));
            }
        }
    }


}
