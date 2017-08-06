package com.example.lenovo.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager am=(AlarmManager)MainActivity.this.getSystemService(Context.ALARM_SERVICE);
                //context.ALARM_SERVICE brings services corresponding to alarm

                Intent i=new Intent(MainActivity.this,AlarmReceiver.class);

                PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,1,i,0);

                //getBroadCast brings pendingIntent
                //both these pending requet are same acc. to system so there requsetCode must be different in order to differentiate if they corresponding to same receiver
                //mainActivity is context ,1=requestCode,i=Intent,0=flag
                //pendingIntent is used to perform action after certain time when alarm is generted

                am.set(AlarmManager.RTC,System.currentTimeMillis()+2000,pendingIntent);
               // am.set(AlarmManager.RTC,System.currentTimeMillis()+2000,pendingIntent2);
            }
        });
    }
}
