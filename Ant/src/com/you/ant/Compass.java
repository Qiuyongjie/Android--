package com.you.ant;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Compass extends Activity implements SensorEventListener {
	private ImageView img_compass;
	// the rotate angle
	private float currentDegree = 0f;

	private SensorManager mSensorManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compass);

		// get reference
		img_compass = (ImageView) findViewById(R.id.img_compass);

		// get service
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

	}

	@Override
	protected void onResume() {
		// register
		mSensorManager.registerListener(this,
				mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_GAME);
		super.onResume();
	}

	@Override
	protected void onPause() {
		//unregister
		mSensorManager.unregisterListener(this);
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		mSensorManager.unregisterListener(this);
		super.onStop();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compass, menu);
		return true;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		int sensorType = event.sensor.getType();
		switch (sensorType) {
		case Sensor.TYPE_ORIENTATION:
			  float degree = event.values[0];
			  
			  RotateAnimation ani = new RotateAnimation(currentDegree, -degree,
					  Animation.RELATIVE_TO_SELF, 0.5f,
					  Animation.RELATIVE_TO_SELF,0.5f);
			  
			  ani.setDuration(200);
			  img_compass.setAnimation(ani);
			  currentDegree = -degree;
			break;

		default:
			break;
		}
	}

}
