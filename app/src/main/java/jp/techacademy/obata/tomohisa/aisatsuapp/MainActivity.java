package jp.techacademy.obata.tomohisa.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        text = (TextView) findViewById(R.id.text);

    }
    @Override
    public void onClick(View v){
        showTimePickerDialog();
    }

    private void showTimePickerDialog(){

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        if (hourOfDay>=2 & hourOfDay<10){
                            text.setText("おはよう");
                        }else if (hourOfDay>=10 & hourOfDay<18){
                            text.setText("こんにちは");
                        }else if ((hourOfDay>=18 & hourOfDay<24) || (hourOfDay>=0 & hourOfDay<2)) {
                            text.setText("こんばんは");
                        }
                    }
                },
                13,
                0,
                true);

        timePickerDialog.show();
    }
}
