package com.frocerie.demoalqalam.service_pack;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.frocerie.demoalqalam.main_activity.FrontPage;

/**
 * Created by avocet on 12/09/17.
 */

public class RebootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent updIntent = new Intent(context, MyIntentService.class);
        // Create a PendingIntent to be triggered when the alarm goes off
        final PendingIntent pIntent = PendingIntent.getService(context, FrontPage.ALARM_REQ_CODE, updIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Setup periodic alarm every 10 seconds
        long firstMillis = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, 60000, pIntent);
    }
}
