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

		// ͨ���������list
		list = (ListView)findViewById(R.id.vlist);
		//����listLength
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
		public int getCount() {// �������ListView������
			
			return listLength;
		}

		@Override
		public Object getItem(int position) {
			
			return position;
		}

		@Override
		public long getItemId(int position) { 
			// ��������б����б����λ��
			
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LinearLayout layout = new LinearLayout(ProfileList.this);
			
			layout.setOrientation(0);
			// 0��ʾ���LinearLayout�е������ˮƽ���еģ�1��ʾ��ֱ����
			
			//ͷ���
			ImageView icon = new ImageView(ProfileList.this);
			
			//�˴����ͨ��int���鸳ֵ�������鱣��ͼƬ��Դ��id��R.drawable.xxx��
			icon.setBackground(getResources().getDrawable(R.drawable.ic_launcher));
			
			layout.addView(icon);
			
			LinearLayout ly = new LinearLayout(ProfileList.this);
			ly.setOrientation(1);
			TextView tx_name = new TextView(ProfileList.this);
			tx_name.setText("xiao ming"); //�˴����ͨ���ַ������鸳ֵ
			ly.addView(tx_name);
			TextView tx_vocal = new TextView(ProfileList.this);
			tx_vocal.setText("Never mind!");//�˴����ͨ���ַ������鸳ֵ
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
