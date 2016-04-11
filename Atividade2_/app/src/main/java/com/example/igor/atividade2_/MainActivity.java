package com.example.igor.atividade2_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAlteraTxt = (Button)findViewById(R.id.change);
        btnAlteraTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                EditText textField = (EditText)findViewById(R.id.textField);
                TextView label = (TextView)findViewById(R.id.label);
                label.setText(textField.getText().toString());
            }
        } );
    }


}
