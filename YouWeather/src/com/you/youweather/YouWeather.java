package com.you.youweather;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.you.youweather.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class YouWeather extends Activity {

	private static Spinner spinCity;
	private static TextView tv_tmp;
	private static TextView tv_ltmp;
	private static TextView tv_htmp;
	private static TextView tv_weather;
	private static TextView tv_ws;
	private static TextView tv_wd;
	private static TextView tv_ss;
	private static TextView tv_sr;
	private static TextView tv_time;

	private static TextView tv_currentCity;
	public static String currentCity = "beijing"; // Spinner中选中的城市
	public static WData data;
	private static Handler uhandler;
	private static String Cityname_py[];//中国城市 拼音
	private static String Cityname_cn[]; //中国城市 汉字
	
	// http请求参数
	public final String httpUrl = "http://apis.baidu.com/apistore/weatherservice/weather";
	private String jsonResult;

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_you_weather);	
		
        //data 初始化
		data = new WData();
		spinCity = (Spinner) findViewById(R.id.spinCity);
		tv_tmp = (TextView) findViewById(R.id.tv_tmp);
		tv_ltmp = (TextView) findViewById(R.id.tv_ltmp);
		tv_htmp = (TextView) findViewById(R.id.tv_htmp);
		tv_weather = (TextView) findViewById(R.id.tv_wether);
		tv_ws = (TextView) findViewById(R.id.tv_ws);
		tv_wd = (TextView) findViewById(R.id.tv_wd);
		tv_ss = (TextView) findViewById(R.id.tv_ss);
		tv_sr = (TextView) findViewById(R.id.tv_sr);
		tv_time = (TextView) findViewById(R.id.tv_time);
		tv_currentCity = (TextView) findViewById(R.id.tv_currentCity);

		// 数据更新的handler
		uhandler = new UpdateWData();
		
		//json
		
		String json = getResources().getString(R.string.cityCn);
		try {
			JSONObject j = new JSONObject(json);
			JSONArray jsa =j.getJSONArray("city");
			Cityname_cn = new String[jsa.length()];
			Cityname_py = new String[jsa.length()];
			for (int i = 0; i < jsa.length(); i++) {
				JSONObject objtmp = jsa.getJSONObject(i);
				Cityname_cn[i] = objtmp.getString("name");
				Cityname_py[i] = objtmp.getString("pinyin");
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// 下拉列表
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item,Cityname_cn);

		spinCity.setAdapter(adapter);

		spinCity.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Toast.makeText(YouWeather.this,
						arg0.getItemAtPosition(arg2).toString(),
						Toast.LENGTH_SHORT).show();

				currentCity = Cityname_py[arg2];
				System.out.println(currentCity);
				
				new Thread() {
					public void run() {
						jsonResult = myHttpGet.request(httpUrl, "citypinyin="
								+ currentCity);
						System.out.println(jsonResult);
						if (!jsonResult.isEmpty()) {

							try {
								// JSON 解析
								JSONObject obj = new JSONObject(jsonResult);
								String errMsg = obj.getString("errMsg");
								Log.d("JSON_getdata", errMsg);
								if (errMsg.contains("success")) {

									// JSON retData
									String strWeather = obj
											.getString("retData");
									Log.d("JSON_strWeather", strWeather);
									
									JSONObject ob = new JSONObject(strWeather);
									Log.d("JSON_ob", ob.toString());
									
									
									data.setCity(ob.getString("city"));
									data.setAltitude(ob.getString("altitude"));
									data.setLatitude((ob.getString("latitude")));
									data.setCitycode(ob.getString("citycode"));
									data.setWS(ob.getString("WS"));
									data.setWD(ob.getString("WD"));
									data.setWeather(ob.getString("weather"));
									data.setTime(ob.getString("time"));
									data.setDate(ob.getString("date"));

									data.setTemp(ob.getString("temp"));
									data.setH_tmp(ob.getString("h_tmp"));
									data.setL_tmp(ob.getString("l_tmp"));
									data.setLongitude(ob.getString("longitude"));
									data.setSunset(ob.getString("sunset"));
									data.setSunrise(ob.getString("sunrise"));
									data.setPostCode(ob.getString("postCode"));
									data.setPinyin(ob.getString("pinyin"));
									data.setCitycode(ob.getString("citycode"));

									Log.d("data", data.toString());

									// 发送消息
									uhandler.sendEmptyMessage(0x12138);

								} else {
									Toast.makeText(YouWeather.this,
											"Failed to get data from server!",
											Toast.LENGTH_SHORT).show();
								}
							} catch (JSONException e) {
								Log.d("JSON", e.getMessage());

							}
						}
					}
				}.start();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				Toast.makeText(YouWeather.this, "Select a city for detials!",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	 class UpdateWData extends Handler {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			if (msg.what == 0x12138) {
				update(data);
			}
		}
	}

	/***
	 * 更新数据
	 * 
	 * @param dt
	 */
	private  synchronized void update(WData dt) {
		try {
			tv_currentCity.setText("city" + ":"
					+ dt.getCity());
			tv_time.setText("Update time" + ":" + dt.getDate() + " "
					+ dt.getTime());
			tv_tmp.setText("Temperature" + ":" + data.getTemp() + "℃");
			tv_ltmp.setText("Lowest" + ":" + dt.getL_tmp()+"℃");
			tv_htmp.setText("Highest" + ":" + dt.getH_tmp()+"℃");
			tv_weather.setText("Weather" + ":" + dt.getWeather());
			tv_ws.setText("Wind speed" + ":" + dt.getWS());
			tv_wd.setText("Wind direction" + ":" + dt.getWD());
			tv_sr.setText("Sunrise time" + ":" + dt.getSunrise());
			tv_ss.setText("Sunset time" + ":" + dt.getSunset());
			
		} catch (Exception e) {
			Log.d("exception", e.getMessage());
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			   System.out.println("setting");
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
}
