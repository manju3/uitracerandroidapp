package com.cloudmpower.www.uiklario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private AppCompatSeekBar seekBar;
    private short batteryLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getAllElements();
    }
    private void getAllElements() {
        seekBar = (AppCompatSeekBar) findViewById(R.id.level);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             //Toast.makeText(getBaseContext(),Integer.toString(progress),Toast.LENGTH_SHORT).show();
                batteryLevel = (short) progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
   public void seekBarCallBack() {

   }
}
