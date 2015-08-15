package com.example.demorg;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static RadioGroup rg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        rg = (RadioGroup)findViewById(R.id.rg);
        
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch(checkedId){
				case R.id.rb_female:
					Toast.makeText(MainActivity.this, "female",Toast.LENGTH_SHORT).show();
					break;
				case R.id.rb_male:
					Toast.makeText(MainActivity.this, "male",Toast.LENGTH_SHORT).show();
					break;
				case R.id.rb_none:
					Toast.makeText(MainActivity.this, "unknown",Toast.LENGTH_SHORT).show();
					
					break;
				}
				
			}
		});
    }


  
}
