package com.app.oldnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;
    public static final String CHANNEL_ID_1 = "Cricket";
    public static final String CHANNEL_ID_2 = "Hockey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = NotificationManagerCompat.from(this);
    }

    public void channel1(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // create channel in new versions of android
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID_1, "Cricket", importance);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            notificationManager.createNotificationChannel(notificationChannel);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, CHANNEL_ID_1)
                        .setSmallIcon(R.drawable.ic_money)
                        .setContentTitle("Channel 1")
                        .setContentText("This is from channel1")
                        .setAutoCancel(true);
        //.setSound(defaultSoundUri)

        Notification nc = notificationBuilder.build();
        // 0 is id of notification
        notificationManager.notify(1, nc);
    }

    public void channel2(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // create channel in new versions of android

            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID_2, "Hockey", importance);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            notificationManager.createNotificationChannel(notificationChannel);


        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, CHANNEL_ID_2)
                        .setSmallIcon(R.drawable.ic_money)
                        .setContentTitle("Channel2")
                        .setContentText("This is from channel 2")
                        .setAutoCancel(true);
        //.setSound(defaultSoundUri)

        Notification nc = notificationBuilder.build();
        // 0 is id of notification
        notificationManager.notify(2, nc);
    }
}
