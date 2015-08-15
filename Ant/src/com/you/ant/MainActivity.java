package com.you.ant;


import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity  implements OnClickListener{
	//hardware
	private Camera mCamera;
	private Parameters mParameters;
	//imageButtons
	private ImageButton img_btn_light;
	private ImageButton img_btn_compass;
	private ImageButton img_btn_stopwatch;
	
	//light status
	private boolean isLightOn = false;
	private boolean isLightSupported = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        
        //Get reference
        img_btn_light = (ImageButton)findViewById(R.id.img_btn_light);
        img_btn_stopwatch = (ImageButton)findViewById(R.id.img_btn_stopwatch);
        img_btn_compass = (ImageButton)findViewById(R.id.img_btn_compass);
       
        
        //setOnClickListener
        img_btn_light.setOnClickListener(this);
        img_btn_stopwatch.setOnClickListener(this);
        img_btn_compass.setOnClickListener(this);
        
        //Check if  this app has the rigth authority to access hardware!
        
        try{
        	mCamera = Camera.open(); //open camera
            mParameters = mCamera.getParameters();
            isLightSupported = true;
        }catch(Exception e){
//        	img_btn_light.setEnabled(false);
        }
        
       
        
    }
    
    

  



	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_btn_light:
			lightSwitch();
			break;
			
		case R.id.img_btn_stopwatch:
			Intent inew = new Intent(MainActivity.this,Stopwatch.class);
			startActivity(inew);
			break;
			
		case R.id.img_btn_compass:
			Intent ine = new Intent(MainActivity.this,Compass.class);
			startActivity(ine);
			break;
		default:
			break;
		}
		
	}
    
	public void lightSwitch() {
		 if(!isLightSupported){
//	        	Toast.makeText(MainActivity.this, "not support!", 
//	        			Toast.LENGTH_LONG).show();
			 AlertDialog.Builder mBuilder = new AlertDialog.Builder(this)
			 	.setTitle(getResources().getText(R.string.err_Title))
			 	.setIcon(getResources().getDrawable(R.drawable.ic_warn))
			 	.setMessage(getResources().getText(R.string.err_LightNotSupport));
			 	
//			 mBuilder.setPositiveButton(getResources().getText(R.string.txtOk),
//					 new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface arg0, int arg1) {
//					System.out.println("ok");
//				}
//			} );
			 //show AlertDialog
			 	mBuilder.create().show();
		  }
		 else { 
			 //hardware and permission allowed!
			 if(!isLightOn){
					//turn light on£¡
					mParameters .setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
					mCamera.setParameters(mParameters);
				}else {
					//turn light off
					mParameters .setFlashMode(Camera.Parameters.FLASH_MODE_ON);
					mCamera.setParameters(mParameters);
				}
				//set light status
				isLightOn = !isLightOn;
		 }
	}







	public boolean isQualified(){
		
		boolean hasLightAcc = false;
		
		
		return hasLightAcc ;
	}
	
	
	
	  @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        
	        
	        return true;
	    }
}
