package com.example.myapplication2.clases.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication2.R;

public class NotificacionMainActivity extends AppCompatActivity {
    private static String channelId = "Canal_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion_main);

        VerificarPorPermiso();

        findViewById(R.id.btnotificacion).setOnClickListener(enviarNOtificacionOnClick());
    }

    private void VerificarPorPermiso() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(NotificacionMainActivity.this,
                    Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(NotificacionMainActivity.this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);

            }

        }
    }

    private View.OnClickListener enviarNOtificacionOnClick() {
        return v -> {
            enviarNotificacion();
        };
    }

    private void enviarNotificacion() {

        Intent intent;
        NotificationCompat.Builder builder;
        PendingIntent pendingIntent;
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        builder = crearBuilder();
        intent = crearIntent();
        crearPendingIntent(builder, intent);
        crearCanal(notificationManager);

        notificationManager.notify(0, builder.build());


    }

    private void crearCanal(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE) {
            Log.i("notificacion", "ADentro del if");

            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelId);

            if (notificationChannel == null) {
                Log.i("notificacion", "Canal fue null");
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(channelId, "Descripcion del canal", importance);
                notificationChannel.setLightColor(Color.GREEN);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    private PendingIntent crearPendingIntent(NotificationCompat.Builder builder, Intent intent) {
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_MUTABLE);
        builder.setContentIntent(pendingIntent);
        return pendingIntent;
    }


    private NotificationCompat.Builder crearBuilder() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelId);
        builder.setSmallIcon(R.drawable.icon_notifications_).
                setContentTitle("Este es un mensaje").
                setContentText("Este es el texto del mensaje").
                setAutoCancel(true).
                setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder;
    }

    private Intent crearIntent() {
        Intent intent = new Intent(NotificacionMainActivity.this, HomeNotificacionActivity.class);
        intent.putExtra("mensaje", "Este es el mensaje que le llego por notificacion sdfsdfasfsd");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }
}


