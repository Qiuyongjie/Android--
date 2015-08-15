package com.you.ant;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Stopwatch extends Activity implements OnClickListener{
	private Button btn_rstCount;
	private Button btn_startContinue;
	private ListView list;
	private TextView tv_seconds;
	private TextView tv_ms; //0.01s
	private boolean isRst = false;
	private boolean isStart = true;
	private boolean isContinue = false;
	private Timer mTimer;
	private static int hour = 0;
	private static int min = 0;
	private static int sec = 0;
	private static int ms = 0;
	private static int time = 0;
	private Handler mHandler;
	private MyTimer task;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> la;
	private static  int sequences = 0;
	private final String BLANK ="         ";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stopwatch);
		
		list = (ListView)findViewById(R.id.list);
		
		la = new ArrayList<String>();
		tv_seconds = (TextView)findViewById(R.id.tv_seconds);
		tv_ms = (TextView)findViewById(R.id.tv_ms);
		
		mHandler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				
				if(msg.what == 0x000012138){
					updateTime();
				}
				if(msg.what == 0x000012139){
					updateList();
				}
			}
		};
		btn_rstCount =(Button)findViewById(R.id.btn_rstCount);
		btn_startContinue = (Button)findViewById(R.id.btn_startContinue);
		btn_rstCount.setOnClickListener(this);
		btn_rstCount.setEnabled(false);
		btn_startContinue.setOnClickListener(this);
	
		
	}
	private void updateList() {
		//update list
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,la);
		list.setAdapter(adapter);
		
	}
	
	private synchronized void updateTime() {
		//ªÒ»°time
		 ms = time%1000;
		 sec = (time/1000) %60;
		 min = (time/60000)%60;
		 hour = (time/3600000)%24;
		 String strms = "";
		 String strs = "";
		 String strmin = "";
	
		 if(ms < 100)
		 {
			 strms += "0";
		 }
		 if(sec < 10)
		 {
			 strs += "0";
		 }
		 if(min < 10){
			 strmin += "0";
		 }
		 tv_ms.setText(strms+String.valueOf(ms));
		 tv_seconds.setText(String.valueOf(hour)
				 +":"+strmin+String.valueOf(min)+":"+strs+String.valueOf(sec));
	}
	
	/**
	 * count
	 */
	private synchronized void countTime(){
		if(time < Integer.MAX_VALUE)
		{
			time++;
		}
		else
		{
			time = 0;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stopwatch, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_rstCount:
			rstCount();
			break;
			
		case R.id.btn_startContinue:
			startContinue();
			break;
		default:
			break;
		}
		
		
	}

	private void startContinue() {
		if(isStart){
			//start 
			mTimer  = new Timer();
			task = new MyTimer();
			mTimer.schedule(task, 0, 1);
			isStart = false;
			isContinue = false;
			btn_rstCount.setText("Count");
			btn_rstCount.setEnabled(true);
			isRst= false;
			btn_startContinue.setText("Stop");
			btn_rstCount.setBackgroundColor(getResources().getColor(R.color.darkgrey));
		}
		else{
			if(isContinue){
				//continues
				mTimer  = new Timer();
				task = new MyTimer();
				mTimer.schedule(task, 0, 1);
				btn_startContinue.setText("Stop");
				btn_rstCount.setText("Count");
				isRst = false;
				
			}
			else{
				//stop
				mTimer.cancel();
				mTimer.purge();
				btn_startContinue.setText("Continue");
				btn_rstCount.setText("Reset");
				isRst = true;
			}
			isContinue = !isContinue;
		}
		
	}

	private void rstCount() {
		if(!isRst){
			//count
			sequences++;
			la.add("Order:  "+sequences 
					+BLANK
					+tv_seconds.getText().toString()+":"
					+ tv_ms.getText().toString());
			
			mHandler.sendEmptyMessage(0x000012139);//update list
//			System.out.println(tv_seconds.getText().toString()+":"
//			+ tv_ms.getText().toString());	
		}
		else{
			//reset
			System.out.println("reset");
			btn_rstCount.setBackgroundColor(getResources().getColor(R.color.slategray));
			ms = 0;
			sec = 0;
			min = 0;
			hour = 0;
			time = 0;
			 tv_ms.setText("00");
			 tv_seconds.setText("00:00");
			btn_rstCount.setEnabled(false);
			btn_startContinue.setText("Start");
			//clean listview
			la.clear();
			mHandler.sendEmptyMessage(0x000012139);
			
			isStart = true;
			isContinue = false;
			mTimer.cancel();
			mTimer.purge();
			sequences = 0;
		}
	}


	class MyTimer extends TimerTask{

		@Override
		public void run() {
			countTime();
			mHandler.sendEmptyMessage(0x000012138);
		}
		
	}
}
