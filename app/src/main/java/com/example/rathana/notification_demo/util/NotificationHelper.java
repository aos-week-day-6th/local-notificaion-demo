package com.example.rathana.notification_demo.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.rathana.notification_demo.DetailActivity;
import com.example.rathana.notification_demo.R;

public class NotificationHelper {
    public  static  final String CHANNEL_ID="ch-01";
    public static void createNotificationChannel(Context context){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=
                    new NotificationChannel(CHANNEL_ID,"normal user",NotificationManager.IMPORTANCE_HIGH);

            channel.setDescription("for normal user");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);

        }

    }

    public static void createNotification(Context context){

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context,CHANNEL_ID);

        Bitmap bitmap=BitmapFactory.decodeResource(context.getResources(),R.drawable.car);
        builder.setSmallIcon(R.drawable.car);
        builder.setLargeIcon(bitmap);
        builder.setContentTitle("1000$ win");
        builder.setContentText("Win 1000$ tonight");
        String bigText="You have a chance to win 1000$ tonight by joining to play game";
        //builder.setStyle(new NotificationHelper().createBigTextStyle(bigText));
        builder.setStyle(new NotificationHelper().createBigPictureStyle(bitmap));
        builder.setContentIntent(createPendingIntent(context));
        NotificationManager notificationManager=
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        int id = (int) (System.currentTimeMillis()/1000);
        notificationManager.notify(id,builder.build());

    }

    private static PendingIntent createPendingIntent(Context context){
        Intent intent= new Intent(context,DetailActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(
                context,1,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        return pendingIntent;
    }

    private NotificationCompat.BigTextStyle createBigTextStyle(String text){
        NotificationCompat.BigTextStyle style=new NotificationCompat.BigTextStyle();
        style.bigText(text);
        return style;
    }

    private NotificationCompat.BigPictureStyle createBigPictureStyle(Bitmap bitmap){
        NotificationCompat.BigPictureStyle style=new NotificationCompat.BigPictureStyle();
        style.bigPicture(bitmap);
        return style;
    }

}

















