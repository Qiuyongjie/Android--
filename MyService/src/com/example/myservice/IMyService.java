package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class IMyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("1");
		return null;
	}

	@Override
	public void onCreate() {
		
		super.onCreate();
		System.out.println("1");
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		
		super.onStart(intent, startId);
		System.out.println("1");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("1");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		
		super.onDestroy();
		System.out.println("1");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("1");
		return super.onUnbind(intent);
	}

}
