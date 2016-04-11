package com.example.igor.atividade4_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.goSite);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent i = new Intent("app.atividades.matc89.atividade1.ACTIVITY");
                    Bundle extras = new Bundle();
                    EditText site = (EditText) findViewById(R.id.addressSite);
                    extras.putString("Site", site.getText().toString());
                    i.putExtras(extras);
                    startActivityForResult(i, 1);
                }
            });
        }
    }
}
