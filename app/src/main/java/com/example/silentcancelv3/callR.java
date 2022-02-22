package com.example.silentcancelv3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.CountDownTimer;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class callR extends BroadcastReceiver {
    private String _phoneN;
    static int count;
    static int min;
    String s;
    int lestMin;
    Calendar time = Calendar.getInstance();
    public static AudioManager am;
    PhoneStateListener phoneListener = new PhoneStateListener();


    public void onReceive(Context context, Intent intent) {




        TelephonyManager telephony = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        telephony.listen(new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                s = incomingNumber;

            }
        },PhoneStateListener.LISTEN_CALL_STATE);



        //if call coming
        if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)) {

            //initialize the TelephonyManager to get the number
            _phoneN = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

                lestMin = min;
                min = time.get(Calendar.MINUTE);

                if (lestMin != min && lestMin != 0)
                {
                    count = -1;
                }
           if (count >=1)
           {
               am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
               count = -1;
           }
            count++;



        }

        Toast t = Toast.makeText(context,"ring:"+s,Toast.LENGTH_LONG);
        t.show();
    }
}






