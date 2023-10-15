package com.example.project;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class UserActivity extends AppCompatActivity {
    CalendarView calenderView;
    Calendar calendar;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.button);
        calenderView = findViewById(R.id.calendarView);
        calendar = Calendar.getInstance();
        setDate(1,1,2021);
        getDate();

        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(UserActivity.this, dayOfMonth + "/" + (month+1) + "/" + year, Toast.LENGTH_SHORT).show();
                tv.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month+1) + "/" + String.valueOf(year));

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MdActivity.class);
                startActivity(intent);
            }
        });
    }
    public void getDate(){
        long date=calenderView.getDate();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selectedDate = simpleDateFormat.format(calendar.getTime());
        //Toast.makeText(this,selectedDate,Toast.LENGTH_SHORT).show();

    }
    public void setDate(int day, int month, int year) {
        calendar.set(Calendar.YEAR,year);
    calendar.set(Calendar.MONTH,month-1);
    calendar .set(Calendar.DAY_OF_MONTH,day);
   // long milli=calendar.getTimeInMillis();
    //calenderView.setDate(milli);
    }
}
