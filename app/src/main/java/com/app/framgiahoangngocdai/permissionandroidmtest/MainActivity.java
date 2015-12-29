package com.app.framgiahoangngocdai.permissionandroidmtest;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST = 1;

    private TextView textStatus1;
    private TextView textStatus2;
    private TextView textStatus3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate","run");

        textStatus1 = (TextView) findViewById(R.id.textStatus1);
        textStatus2 = (TextView) findViewById(R.id.textStatus2);
        textStatus3 = (TextView) findViewById(R.id.textStatus3);
        checkPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.d("size", ">> " + grantResults.length);
        if (requestCode == 1) {
            for (int i = 0; i < grantResults.length; i++) {
                switch (i) {
                    case 0:
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            textStatus1.setText("On");
                        } else {
                            textStatus1.setText("Off");
                        }
                        break;
                    case 1:
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            textStatus2.setText("On");
                        } else {
                            textStatus2.setText("Off");
                        }
                        break;
                    case 2:
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            textStatus3.setText("On");
                        } else {
                            textStatus3.setText("Off");
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void checkPermission() {
        Log.d("checkPermission","run");
        String[] listPermission = new String[] {android.Manifest.permission.GET_ACCOUNTS,
                android.Manifest.permission.READ_SMS,
                android.Manifest.permission.READ_PHONE_STATE};
        boolean isOn = false;

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
            textStatus1.setText("On");
        } else {
            textStatus1.setText("Off");
            isOn = true;
        }
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED) {
            textStatus2.setText("On");
        } else {
            textStatus2.setText("Off");
            isOn = true;
        }
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            textStatus3.setText("On");
        } else {
            textStatus3.setText("Off");
            isOn = true;
        }
        if (isOn){
            Log.d("request", "go");
            ActivityCompat.requestPermissions(this, listPermission, MY_PERMISSIONS_REQUEST);
        }
    }
}
