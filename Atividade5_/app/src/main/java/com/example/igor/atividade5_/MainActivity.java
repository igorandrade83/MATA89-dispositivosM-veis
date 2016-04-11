package com.example.igor.atividade5_;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Intent.ACTION_CALL;
import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity {

    int request_code = 1;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private boolean possoFazerLigacao() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button liga = (Button) findViewById(R.id.button);
        if (liga != null) {
            liga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText numero = (EditText) findViewById(R.id.editText);
                    Intent i = new Intent(ACTION_CALL, Uri.parse("tel:" + numero.getText().toString()));
                    if (possoFazerLigacao()) {
                        startActivity(i);
                    }
                }
            });
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode== request_code){
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ACTION_VIEW, Uri.parse(data.getData().toString()));
                startActivity(i);
            }
        }
    }
}
