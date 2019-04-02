package com.societe.anonyme.clockapp;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText hoursEdit,minutesEdit;
    int hours,minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoursEdit = findViewById(R.id.hoursinput);
        minutesEdit = findViewById(R.id.minuteinput);


    }

    public void StartService(View view) {
        Intent intent = new Intent(getApplicationContext(),classOfService.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this,0,intent,0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(hoursEdit.getText().toString()));
        calendar.set(Calendar.MINUTE,Integer.parseInt(minutesEdit.getText().toString()));
        calendar.set(Calendar.SECOND,00);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);


    }
    public void StopService(View view){
        stopService(new Intent(getBaseContext(),classOfService.class));
    }
}
