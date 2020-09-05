package com.example.dogapp20.userClasses;

import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.dogapp20.R;

public class NotificationHelper {
    public static String CHANNEL_ID = "dogproject";
    public static void displayNotification(Context context,String title,String body){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_dogicon)
                .setContentTitle(title)
                .setContentText(body)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationMgr = NotificationManagerCompat.from(context);
        notificationMgr.notify(1,mBuilder.build());
    }
}
