package com.example.tp2_1c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.round;
import static java.lang.String.*;
//implements SensorEventListener

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    float ultimo_sensorX;
    float ultimo_sensorY;
    float ultimo_sensorZ;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        assert mSensorManager != null;
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        cont++;
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            if(cont > 50){
                if(sensorX - ultimo_sensorX > 5 || sensorY - ultimo_sensorY > 5 ||sensorZ - ultimo_sensorZ > 5 ||
                sensorX - ultimo_sensorX < -5 || sensorY - ultimo_sensorY < -5 ||sensorZ - ultimo_sensorZ < -5){

                    cont = 0;

                    Intent display = new Intent(this, mensagem.class);
                    display.putExtra("mensagem", "Mudou a posição");
                    startActivity(display);
                }
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    ultimo_sensorX = event.values[0];
                    ultimo_sensorY = event.values[1];
                    ultimo_sensorZ = event.values[2];
                }
            }else{
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    ultimo_sensorX = event.values[0];
                    ultimo_sensorY = event.values[1];
                    ultimo_sensorZ = event.values[2];
                }
            }

            final EditText X_view = (EditText) findViewById(R.id.x);
            final EditText Y_view = (EditText) findViewById(R.id.y);
            final EditText Z_view = (EditText) findViewById(R.id.z);
            X_view.setText(valueOf( format("%.3g%n", sensorX) ));
            Y_view.setText(valueOf( format("%.3g%n", sensorY) ));
            Z_view.setText(valueOf( format("%.3g%n", sensorZ) ));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }

    public void btn(android.view.View view){
        final TextView coord = (TextView) findViewById(R.id.coord);
        coord.setText("teste");
    }
}
