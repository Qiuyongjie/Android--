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
		//��ȡ������activity��Intent
		Intent ine = getIntent();
		//��ȡ����
		s += "username : "+ine.getStringExtra("username")+"\n";
		s += "password : "+ine.getStringExtra("password")+"\n";
		//��ʾ��ȡ��������
		Toast.makeText(this, s, Toast.LENGTH_LONG).show();
		
//		//��ȡͼƬ
//		int pic = ine.getIntExtra("mypic", 0);
//		//
//		ImageView img = (ImageView)findViewById(R.id.img);
//		if(pic != 0)
//		{
//			img.setBackgroundResource(pic);
//		}
		
		
	}

	

}
