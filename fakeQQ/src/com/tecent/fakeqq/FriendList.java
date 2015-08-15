package com.tecent.fakeqq;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

public class FriendList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend_list);
		
		String s = "";
		//获取启动该activity的Intent
		Intent ine = getIntent();
		//获取数据
		s += "username : "+ine.getStringExtra("username")+"\n";
		s += "password : "+ine.getStringExtra("password")+"\n";
		//显示获取到的数据
		Toast.makeText(this, s, Toast.LENGTH_LONG).show();
		
//		//获取图片
//		int pic = ine.getIntExtra("mypic", 0);
//		//
//		ImageView img = (ImageView)findViewById(R.id.img);
//		if(pic != 0)
//		{
//			img.setBackgroundResource(pic);
//		}
		
		
	}

	

}
