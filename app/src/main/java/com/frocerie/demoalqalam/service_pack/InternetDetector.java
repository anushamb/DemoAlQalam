package com.frocerie.demoalqalam.service_pack;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.frocerie.demoalqalam.R;

/**
 * Created by avocet on 12/09/17.
 */

public class InternetDetector extends BroadcastReceiver {

    private Context _context;

    private NotificationManager mNotifiyManager;
    private NotificationCompat.Builder mBuilder;
    private Uri soundNotifyUri;
    int id = 23;

    public InternetDetector(){

    }

    public InternetDetector(Context context){
        this._context = context;
    }


    @Override
    public void onReceive(Context ctx, Intent intent) {

        this._context = ctx;

        mNotifiyManager = (NotificationManager) _context.getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = null;
        soundNotifyUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION| Notification.DEFAULT_VIBRATE);
        mBuilder = new NotificationCompat.Builder(_context);

        if(Build.VERSION.SDK_INT >= 21){
            mBuilder.setSmallIcon(R.drawable.ic_settings);
            mBuilder.setColor(ContextCompat.getColor(_context,android.R.color.holo_green_dark));
            mBuilder.setLargeIcon(BitmapFactory.decodeResource(_context.getResources(),R.mipmap.ic_launcher));
        }else{
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);

        }

        if (isConnectedToInternet())
            mBuilder.setContentText("You set On Internet.");
        else
            mBuilder.setContentText("You set OFF Internet.");
            mBuilder.setContentTitle("Internet Notification");
        mNotifiyManager.notify(id,mBuilder.build());
        return;
    }

    public boolean isConnectedToInternet() {
        ConnectivityManager cm =
                (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnected();
        return isConnected;
    }

    //Only show alert for foreground internet call - Check internet connection
    public void alertTurnOnInternet() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= 21)
            builder = new AlertDialog.Builder(_context, android.R.style.Theme_Material_Light_Dialog_Alert);
        else
            builder = new AlertDialog.Builder(_context);
        builder.setTitle(_context.getString(R.string.tit_alert_internet));
        builder.setMessage(_context.getString(R.string.alert_internet));
        builder.setIcon(R.drawable.ic_settings);
        builder.setPositiveButton(_context.getString(R.string.settings), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                _context.startActivity(intent);
                dialog.cancel();
            }
        });
        builder.setNegativeButton(_context.getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
