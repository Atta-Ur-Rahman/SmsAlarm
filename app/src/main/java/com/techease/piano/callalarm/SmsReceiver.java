package com.techease.piano.callalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
/**
 * Created by AttaUrRahman on 7/6/2018.
 */
public class SmsReceiver extends BroadcastReceiver {
    private String TAG = SmsReceiver.class.getSimpleName();
    String name, phoneNumber;
    Context context1;


    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the data (SMS data) bound to intent
        Bundle bundle = intent.getExtras();

        context1 = context;

        if (bundle != null) {
            // Retrieve the SMS Messages received


            Object[] sms = (Object[]) bundle.get("pdus");

            // For every SMS message received
            for (int i = 0; i < sms.length; i++) {
                // Convert Object array
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                String phone = smsMessage.getOriginatingAddress();
                String message = smsMessage.getMessageBody().toString();

                Toast.makeText(context, phone, Toast.LENGTH_SHORT).show();
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();


                if (message.equals("789")){

                    Uri alarmTone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                    Ringtone ringtoneAlarm = RingtoneManager.getRingtone(context.getApplicationContext(), alarmTone);
                    ringtoneAlarm.play();


                    }


                }
        }

    }





}