package com.example.androidhandler_sendto2childthread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static Handler handler1;
	private static Handler handler2;
	private TextView tv_1;
	private TextView tv_2;
	private EditText et;
	private Button btn;
	private static String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_1 = (TextView)findViewById(R.id.tv_1);
        tv_2 = (TextView)findViewById(R.id.tv_2);
        et = (EditText)findViewById(R.id.et);
        btn =  (Button)findViewById(R.id.btn);
        
      
        
        (new Thread(){
        	@Override
        	public void run() {
        	
        		super.run();
        		Looper.prepare();
        		handler1 = new Handler(){
        			@Override
        			public void handleMessage(Message msg) {
        				
        				super.handleMessage(msg);
        				
        				if(msg.what == 1)
        				{
        					System.out.println(msg.obj + "1");
        				}
        			}
        		};
        		Looper.loop();	
        	}
        }).start();
        
        (new Thread(){
        	@Override
        	public void run() {
        	
        		super.run();
        		Looper.prepare();
        		handler2 = new Handler(){
        			@Override
        			public void handleMessage(Message msg) {
        				
        				super.handleMessage(msg);
        				
        				if(msg.what == 1)
        				{
        					System.out.println(msg.obj+"okay");
        				}
        			}
        		};
        		Looper.loop();
        		
        		
        	}
        }).start();
        
        
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!(str = et.getText().toString()).equals("")){
					Message msg = new Message();
					msg.what = 1;
					msg.obj = str;
					
					
					Message msg1 = new Message();
					msg1.what = 1;
					msg1.obj = str;
					handler1.sendMessage(msg);
					handler2.sendMessage(msg1);
				
				}
			}
		});
    }
    
}
