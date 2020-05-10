package com.example.tp2_2b;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor proximity;
    TextView proximityValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proximityValue = (TextView)findViewById(R.id.proximity);
        sensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(proximity != null)
        {
            sensorManager.registerListener(MainActivity.this, proximity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            proximityValue.setText("proximity sensor not supported");
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_PROXIMITY)
        {
            proximityValue.setText("Proximity: " + event.values[0]);
        }
    }
}

