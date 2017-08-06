package com.example.lenovo.alarms;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
static int i=0;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
     //   Toast.makeText(context,"AlarmReceived ",Toast.LENGTH_SHORT).show();

        //for notification
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle(" MY Notification")
                .setAutoCancel(true) //so that it will itself removed from notification bar once clicked if false then we have to remove it from notification bar
                .setContentText("pendingIntentId"+i++ +"");
      Intent resultIntent=new Intent(context,MainActivity.class);
        resultIntent.putExtra("id",i);
        PendingIntent resultPendingIntent=PendingIntent.getActivity(context,i++,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        Intent j=new Intent(context,abc.class);
        j.putExtra("ihih",4);
        PendingIntent pendingIntent2=PendingIntent.getActivity(context,2,j,PendingIntent.FLAG_CANCEL_CURRENT);

        //FLAG_UPDATE_CURRENT update current pendingIntent to new id value
       //FLAG_CANCEL_CURRENT
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
      //mId allows you to update the notification later on
        mNotificationManager.notify(0,mBuilder.build());
        //.build() created Notification object from mBuilder

    }
}
