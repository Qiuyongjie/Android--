package com.youyou.nenolights;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Contacts.Intents.UI;
import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.Toast;

public class NenoLight extends Activity {
	private int sequence;
	
	final int[] view = new int[]{
		R.id.frame_1,	
		R.id.frame_2,	
		R.id.frame_3,	
		R.id.frame_4,	
		R.id.frame_5,	
		R.id.frame_6,	
		R.id.frame_7,	
	};
	
	final int[] colors = new int[]{
		R.color.red,
		R.color.orange,
		R.color.yellow,
		R.color.green,
		R.color.indigo,
		R.color.blue,
		R.color.purple,
	};
	
	FrameLayout[] Frame = new FrameLayout[view.length];
	
	final Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			if(msg.what == 0x12138) { //判断是否为来自本程序的消息
				changeColor();
			}
			super.handleMessage(msg);
		}
	};
	
	private void changeColor() {
		for (int i = 0; i < view.length; i++) {
			Frame[i].setBackgroundResource
			(colors[(i+sequence)%view.length]);
		}
		if(sequence++ > 7) //确保不会越界
		{
			sequence = 0;
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_neno_light);
		System.out.println("init ok");
		
		for (int i = 0; i < view.length; i++) {
			Frame[i] = (FrameLayout)findViewById(view[i]);
		}
		
		new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				handler.sendEmptyMessage(0x12138); //发送消息
			}
			
		}, 0,100);
		
		Toast.makeText(this, "Wow,How genius you are!", Toast.LENGTH_LONG).show();
	}
	
	
	

}
