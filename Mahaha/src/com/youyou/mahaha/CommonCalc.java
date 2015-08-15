package com.youyou.mahaha;

import java.util.ArrayList;

import com.youyou.Untils.Arithmetics.ExpressionFactory;

import android.os.Bundle;
import android.os.Looper;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CommonCalc extends Activity implements OnClickListener{
	//括号补全标记！
	private boolean isPaired = false;
	
	//按键
	private static Button btn_one;
	private static Button btn_two;
	private static Button btn_three;
	private static Button btn_four;
	private static Button btn_five;
	private static Button btn_six;
	private static Button btn_seven;
	private static Button btn_eight;
	private static Button btn_nine;
	private static Button btn_zero;
	private static Button btn_dot;
	private static Button btn_add;
	private static Button btn_minus;
	private static Button btn_multi;
	private static Button btn_divide;
	private static Button btn_equal;
	private static Button btn_clean;
	private static Button btn_delete;
	private static Button btn_sentific;

	//显示区
	private static TextView tv0;
	private static TextView tv1;

	//显示字符串
	private String strSc0 = "";
	private String strSc1 = "";
	private String strExpression = "";
	
	//结果
	private static double dResult;
	private static long lResult;
	private static String strResult;
	
	private ArrayList<Double> num = new ArrayList<Double>();
	private ArrayList<String> operator = new ArrayList<String>();
	/**
	 * final Button Text
	 */
	private boolean mode = false;
	//CommonMode
	final String[] tbtn1 = new String[]{
		"1","2","3","4","5","6","7","8","9","0"
		,".","···","×","÷","+","-","=","C","DEL"
	};
	
	//SentificMode
	final String[] tbtn2 = new String[]{
		"sinh","cosh","tanh"
		,"sin","cos","tan",
		"√","x√y","y^x","e",
		"e^x","123","x³","x²",
		"log","ln","π","()","1/x"
	};
	
	//键盘设置
	public void setMode()
	{
		if(mode)
		{
			//换为数字键盘
			btn_one.setText(tbtn1[0]);
			btn_two.setText(tbtn1[1]);
			btn_three.setText(tbtn1[2]);
			btn_four.setText(tbtn1[3]);
			btn_five.setText(tbtn1[4]);
			btn_six.setText(tbtn1[5]);
			btn_seven.setText(tbtn1[6]);
			btn_eight.setText(tbtn1[7]);
			btn_nine.setText(tbtn1[8]);
			btn_zero.setText(tbtn1[9]);
			btn_dot.setText(tbtn1[10]);
			btn_sentific.setText(tbtn1[11]);
			btn_multi.setText(tbtn1[12]);
			btn_divide.setText(tbtn1[13]);
			btn_add.setText(tbtn1[14]);
			btn_minus.setText(tbtn1[15]);
			btn_equal.setText(tbtn1[16]);
			btn_clean.setText(tbtn1[17]);
			btn_delete.setText(tbtn1[18]);
			
		}
		else
		{
			//换为科学键盘
			btn_one.setText(tbtn2[0]);
			btn_two.setText(tbtn2[1]);
			btn_three.setText(tbtn2[2]);
			btn_four.setText(tbtn2[3]);
			btn_five.setText(tbtn2[4]);
			btn_six.setText(tbtn2[5]);
			btn_seven.setText(tbtn2[6]);
			btn_eight.setText(tbtn2[7]);
			btn_nine.setText(tbtn2[8]);
			btn_zero.setText(tbtn2[9]);
			btn_dot.setText(tbtn2[10]);
			btn_sentific.setText(tbtn2[11]);
			btn_multi.setText(tbtn2[12]);
			btn_divide.setText(tbtn2[13]);
			btn_add.setText(tbtn2[14]);
			btn_minus.setText(tbtn2[15]);
			btn_equal.setText(tbtn2[16]);
			btn_clean.setText(tbtn2[17]);
			btn_delete.setText(tbtn2[18]);
		}
		mode = !mode;
	}


	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_calc);
		//获取TextView引用
		tv0 = (TextView)findViewById(R.id.screenOne);
		tv1 = (TextView)findViewById(R.id.screenTwo);

		//获取按键引用
		btn_one = (Button)findViewById(R.id.btn_one);
		btn_two = (Button)findViewById(R.id.btn_two);
		btn_three = (Button)findViewById(R.id.btn_three);
		btn_four = (Button)findViewById(R.id.btn_four);
		btn_five = (Button)findViewById(R.id.btn_five);
		btn_six = (Button)findViewById(R.id.btn_six);
		btn_seven = (Button)findViewById(R.id.btn_seven);
		btn_eight = (Button)findViewById(R.id.btn_eight);
		btn_nine = (Button)findViewById(R.id.btn_nine);
		btn_zero = (Button)findViewById(R.id.btn_zero);
		btn_dot = (Button)findViewById(R.id.btn_dot);
		btn_add = (Button)findViewById(R.id.btn_add);
		btn_minus = (Button)findViewById(R.id.btn_minus);
		btn_multi = (Button)findViewById(R.id.btn_Multi);
		btn_divide = (Button)findViewById(R.id.btn_Divide);
		btn_sentific = (Button)findViewById(R.id.btn_sentific);
		btn_equal = (Button)findViewById(R.id.btn_Equals);
		btn_clean = (Button)findViewById(R.id.btn_Clean);
		btn_delete = (Button)findViewById(R.id.btn_Delete);
		//设置监听
		btn_one.setOnClickListener(this);
		btn_two.setOnClickListener(this);
		btn_three.setOnClickListener(this);
		btn_four.setOnClickListener(this);
		btn_five.setOnClickListener(this);
		btn_six.setOnClickListener(this);
		btn_seven.setOnClickListener(this);
		btn_eight.setOnClickListener(this);
		btn_nine.setOnClickListener(this);
		btn_zero.setOnClickListener(this);
		btn_add.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_multi.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_equal.setOnClickListener(this);
		btn_delete.setOnClickListener(this);
		btn_clean.setOnClickListener(this);
		btn_sentific.setOnClickListener(this);
		btn_dot.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if(mode)
		{ //科学模式
			switch (v.getId()) {
			case R.id.btn_one:
				strSc1 += "sinh";
				break;

			case R.id.btn_two:
				strSc1 += "cosh";
				break;

			case R.id.btn_three:
				strSc1 += "tanh";
				break;

			case R.id.btn_four:
				strSc1 += "sin";
				break;

			case R.id.btn_five:
				strSc1 += "cos";
				break;

			case R.id.btn_six:
				strSc1 += "tan";
				break;

			case R.id.btn_seven:
				strSc1 += "√";
				break;

			case R.id.btn_eight:
				strSc1 += "√'";
				break;

			case R.id.btn_nine:
				strSc1 += "^";
				break;

			case R.id.btn_zero:
				strSc1 += "e";
				break;

			case R.id.btn_dot:
				strSc1 += "e^";
				break;

			case R.id.btn_Equals:
				strSc1 += "π";
				break;

			case R.id.btn_add:
				strSc1 += "log";
				break;

			case R.id.btn_minus:
				strSc1 += "ln";
				break;

			case R.id.btn_Multi:
				strSc1 += "³";
				break;

			case R.id.btn_Divide:
				strSc1 += "²";
				break;

			

			case R.id.btn_Delete:
				strSc1 += "~";
				break;

			case R.id.btn_Clean:
				if(isPaired) {
					strSc1 += ")";
				}else {
					strSc1 += "(";
				}
				isPaired = !isPaired;
				break;
				
			case R.id.btn_sentific:
				break;
			default:
				break;
			}
			//不论科学模式下按了何种按钮必须返回普通模式
			setMode();//改换键盘
			//在屏幕显示
			tv1.setText(strSc1);
			Log.d("Button_id Clicked!", String.valueOf(v.getId()));
		}
		else
		{  //普通模式
			switch (v.getId()) {
			case R.id.btn_one:
				strSc1 += "1";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_two:
				strSc1 += "2";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_three:
				strSc1 += "3";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_four:
				strSc1 += "4";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_five:
				strSc1 += "5";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_six:
				strSc1 += "6";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_seven:
				strSc1 += "7";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_eight:
				strSc1 += "8";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_nine:
				strSc1 += "9";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_zero:
				strSc1 += "0";
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_dot:
				//防止出现连续的小数点
				if(!strSc1.endsWith("."))
				{
					strSc1 += ".";
				}
				
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_Equals:
				//获取运算式
				strExpression = strSc1;
				//计算
				if(isPaired){
					if(calc(strExpression))	{
						tv0.setText(strExpression);
					}
					else {
						strSc1 = "error";
					}
				}else{
					strSc1 = "error";
				}
				
					
				//在屏幕显示
				tv1.setText(strSc1);
				//清空
				strSc1 = "";
				
				break;

			case R.id.btn_add:
				if(strSc1.length()>1) //防止 -开头 然后 + 替换
				{
					if(lastIsOperator()) {
						//替换字符
						strSc1 = strSc1.substring(0, strSc1.length()-1); 
					} 
					strSc1 += "+";
				}
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_minus:
				if(strSc1.length()>0) {//防止substring截取时越界
					if(lastIsOperator()) {
						//替换字符
						strSc1 = strSc1.substring(0, strSc1.length()-1); 
					} 				
				}
				strSc1 += "-";
				
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_Multi:
				if(strSc1.length()>1) {//防止substring截取时越界
					if(lastIsOperator()) {
						//替换字符
						strSc1 = strSc1.substring(0, strSc1.length()-1); 
					} 
					strSc1 += "×";
				}
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_Divide:
				if(strSc1.length()>1) //防止substring截取时越界
				{
					if(lastIsOperator()) {
						//替换字符
						strSc1 = strSc1.substring(0, strSc1.length()-1); 
					} 					
					strSc1 += "÷";
				}
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_sentific:
				setMode();//改换键盘
				
				break;

			case R.id.btn_Delete:
				if(strSc1.length()>0)
				{
					strSc1 = strSc1.substring(0, strSc1.length()-1);
					System.out.println(strSc1);
				}
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			case R.id.btn_Clean:
				strSc1 = new String();
				isPaired = false; //括号匹配规则被破坏
				//在屏幕显示
				tv1.setText(strSc1);
				break;

			default:
				break;
			}
			
			Log.d("Button_id Clicked!", String.valueOf(v.getId()));
		
		}
			
	}
	
	/***
	 * 传入运算式，进行计算
	 * @param str
	 * @return
	 */
	public boolean calc( String str){
		if(ExpressionFactory.spliter(str,num,operator)){
			return true;
		}

		return false; //计算失败！
	}
	
	public void setOperator(ArrayList<String> operator) {
		this.operator = operator;
	}
	
	public void setNum(ArrayList<Double> num) {
		this.num = num;
	}
	/**
	 * 将结果转为字符串
	 */
	public void formatResult()
	{
		strResult = "";
	}
	
	/***
	 * 检查当前最后一个字符是否为运算符
	 */
	public boolean lastIsOperator() {
		if(strSc1.endsWith("+")||strSc1.endsWith("-")
				||strSc1.endsWith("×")||strSc1.endsWith("÷")){
			return true;
		}
		return false;
	}
	/***
	 * 创建菜单
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.common_calc, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	/***
	 * 菜单监听
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.action_unit_exchange)
		{
			Toast.makeText(this,"Unit exchange", Toast.LENGTH_SHORT).show();
			Intent ine = new Intent(this,UnitExchange.class);
			startActivity(ine);
		}
		return super.onOptionsItemSelected(item);
	}
		
}
