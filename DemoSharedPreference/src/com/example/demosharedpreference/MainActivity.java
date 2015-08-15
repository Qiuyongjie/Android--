package com.example.demosharedpreference;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn = (Button)findViewById(R.id.btn);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				SharedPreferences sharep = getSharedPreferences("record", MODE_PRIVATE);
				int count = sharep.getInt("count", 0);
				String str = sharep.getString("date", "nil");
				
				Toast.makeText(MainActivity.this, 
						"count: "+count+" "+str , 
						Toast.LENGTH_SHORT).show();
				sharep.edit().putString("date", new 
						SimpleDateFormat("yyyy:MM:dd"+"hh:mm:ss")
						.format(new Date())).commit();
				sharep.edit().putInt("count", count + 1).commit();
				
			}
		});
    }



    
}
