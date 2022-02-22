package com.example.silentcancelv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private String _phoneN;
    AudioManager _am;
    callR c = new callR();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if the permission don't given yet
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},1);
            }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CALL_LOG},1);
        }
        _am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        c.am = _am;
    }



}

