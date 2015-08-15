package com.youyou.mylistview;

import android.os.Bundle;
import android.app.Activity;

import android.widget.ArrayAdapter;

import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv = (ListView)findViewById(R.id.lv);
        
        Integer[] i = new Integer[] {
        	1,2,3,4,5,6,7,8,9	
        };
        
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
				MainActivity.this, 
				R.layout.list, i);
		lv.setAdapter(adapter);
    }


  
    
}
