package com.blogspot.programer27android.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.util.Calendar;

public class DatePeck extends AppCompatActivity {
    TextView tv;
    Button btn;
    int year_x,mont_x,day_x;
    static final int DIALOG_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv= (TextView) findViewById(R.id.tv);
        setContentView(R.layout.date_peck);
        final Calendar cal = Calendar.getInstance();
        year_x=cal.get(Calendar.YEAR);
        mont_x=cal.get(Calendar.MONTH);
        year_x=cal.get(Calendar.DAY_OF_MONTH);

        showdialogclik();
    }
    public void showdialogclik(){
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerlistener, year_x,mont_x,day_x);
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerlistener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            mont_x = monthOfYear + 1;
            day_x = dayOfMonth;
            Toast.makeText(DatePeck.this, year_x+"/"+mont_x+"/"+day_x, Toast.LENGTH_LONG).show();
            tv.setText(year_x+"/"+mont_x+"/"+day_x);
        }
    };
}
