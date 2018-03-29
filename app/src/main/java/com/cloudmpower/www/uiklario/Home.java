package com.cloudmpower.www.uiklario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.SeekBar;

public class Home extends AppCompatActivity {
    private AppCompatSeekBar seekBar;
    private short batteryLevel;
    private AppCompatTextView seekBarLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getAllElements();
    }
    private void getAllElements() {
        seekBarLabel = (AppCompatTextView) findViewById(R.id.seekBarLabel);
        seekBar = (AppCompatSeekBar) findViewById(R.id.level);
        seekBarLabel.setText(Integer.toString(seekBar.getProgress()));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                batteryLevel = (short) progress;
                seekBarLabel.setText(Short.toString(batteryLevel));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setBackgroundService(View view) {
        Intent serviceIntent = new Intent(getBaseContext(), BatteryAlertService.class);
        serviceIntent.putExtra("EXTRAS_BATTERY_LEVEL", (int)this.batteryLevel);
        startService(serviceIntent);
    }
}
