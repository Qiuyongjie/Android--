package com.youyou.youme.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import cn.bmob.im.bean.BmobChatUser;

import com.baidu.location.am;
import com.youyou.youme.R;
import com.youyou.youme.view.vxlist.XListView.IXListViewListener;


/**
 *  快速匹配陌生人
 * @author youyou
 *
 */
public class FastPairActivity extends ActivityBase  {
	BmobChatUser targetUser;
	Button btn_start; //开始配对
	Button btn_cancel;//取消配对
	MyHandler mHandler;
	Thread thread;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fast_pair);
		
		btn_start = (Button)findViewById(R.id.btn_start);
		btn_cancel = (Button)findViewById(R.id.btn_cancel);
		mHandler = new MyHandler();
		thread = new Thread(){
			@Override
			public void run() {
				super.run();
				//TO DO
			}
			
			
		};
		btn_start.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
			     startAnimation();
			}

			private void startAnimation() {
				//转动、缩放图片
			}
		});
		
		btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			}
		});
		
		
	}


	//匹配对象


    //匹配成功，选择跳转？
	public void onSuccess(){
		
	}
	
	//handler 通知匹配到用户，更新图片
    class MyHandler extends Handler{
    	@Override
    	public void handleMessage(Message msg) {
    		super.handleMessage(msg);
    		if(msg.what == 0x314A018)
    		{
    			onSuccess();
    		}
    	}
    }
}
