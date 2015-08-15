package com.tecent.fakeqq;

import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Intent;
import android.widget.*;

public class FakeQQLogin extends Activity {
	private static Button btn_login = null;
	private static CheckBox chb_autoLogin = null;
	private static CheckBox chb_remember = null;
	private static TextView txtUsername = null;
	private static TextView txtPassword = null;
	
	
	//�û����������ֶ�
	private String username = null;
	private String password = null;
 	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_qqlogin);
        
        
        //���widget������
        btn_login = (Button)findViewById(R.id.btnLogin);
        chb_autoLogin = (CheckBox)findViewById(R.id.chb_autoLogin);
        chb_remember = (CheckBox)findViewById(R.id.chb_remember);
        txtUsername = (EditText)findViewById(R.id.txtUsername);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        
        btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				username = txtUsername.getText().toString().trim();
				password = txtPassword.getText().toString().trim();
				if(!username.equals("") && !password.equals("")) //��ʱֻ����û����������Ƿ�Ϊ�գ�
				{   
					/**
					�û�������������Ϲ���
					*/
					Bundle data = new Bundle();
					data.putString("username", username);
					data.putString("password", password);
					
					checkAdditiveLoginParas();
					Toast.makeText(FakeQQLogin.this,getResources().getText(
							R.string.Toast_Login_Successfully),
							Toast.LENGTH_SHORT).show();
					Intent ine = new Intent(FakeQQLogin.this,FriendList.class);
					ine.putExtras(data);
					ine.putExtra("mypic", R.drawable.ic_launcher);
					startActivity(ine);
				}
				else
				{
					Toast.makeText(FakeQQLogin.this,getResources().getText(R.string.Toast_Login_failed),
							Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
    
    /**
     * ���chb_remember��chb_autoLogin��ѡ���Ƿ�ѡ��
     */
    private void checkAdditiveLoginParas() {
    	System.out.println("Remember: " + chb_remember.isChecked());
    	System.out.println("Auto login: "+ chb_autoLogin.isChecked());
    }
    
    
}
