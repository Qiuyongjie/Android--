package com.youyou.utillist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileList extends Activity {
	
	private Integer[] i = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private String[] str = new String[] { "a", "b", "c" };
	private static ListView list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_list);

		// 通过代码绘制list
		list = (ListView)findViewById(R.id.vlist);
		//给定listLength
		list.setAdapter(new MyAdapter(100));
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				System.out.println(parent.getItemAtPosition(position)
						.toString());
			}

		});
	}

	

	class MyAdapter extends BaseAdapter {
		private int listLength  = 0; 
		
		public MyAdapter(int i) {
			// TODO Auto-generated constructor stub
			if(i > 0)
			{
				this.listLength = i;
			}
		}
		
		@Override
		public int getCount() {// 返回这个ListView的行数
			
			return listLength;
		}

		@Override
		public Object getItem(int position) {
			
			return position;
		}

		@Override
		public long getItemId(int position) { 
			// 返回这个列表中列表项的位置
			
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LinearLayout layout = new LinearLayout(ProfileList.this);
			
			layout.setOrientation(0);
			// 0表示这个LinearLayout中的组件是水平排列的，1表示垂直排列
			
			//头像框
			ImageView icon = new ImageView(ProfileList.this);
			
			//此处亦可通过int数组赋值，该数组保存图片资源的id（R.drawable.xxx）
			icon.setBackground(getResources().getDrawable(R.drawable.ic_launcher));
			
			layout.addView(icon);
			
			LinearLayout ly = new LinearLayout(ProfileList.this);
			ly.setOrientation(1);
			TextView tx_name = new TextView(ProfileList.this);
			tx_name.setText("xiao ming"); //此处亦可通过字符串数组赋值
			ly.addView(tx_name);
			TextView tx_vocal = new TextView(ProfileList.this);
			tx_vocal.setText("Never mind!");//此处亦可通过字符串数组赋值
			ly.addView(tx_vocal);
			
			layout.addView(ly);
			return layout;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile_list, menu);
		return true;
	}
}
