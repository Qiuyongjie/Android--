package com.you.youweather;

class WData{
	//ret data
	private String city;
	private String pinyin; //城市拼音
	private String citycode;  //城市编码	
	private String date; //日期
	private String time;//发布时间
	private String postCode;//邮编
	private String longitude; //经度
	private String latitude; //维度
	private String altitude; //海拔	
	private String weather;  //天气情况
	private String temp; //气温
	private String l_tmp; //最低气温
	private String h_tmp; //最高气温
	private String WD;	 //风向
	private String WS;// "微风(<10m/h)", //风力
	private String sunrise;// "07:12", //日出时间
	private String sunset;// "17:44" //日落时间
	private String errmsg = "";
	private String errno = "";
	public synchronized String getCity() {
		return city;
	}
	public synchronized void setCity(String city) {
		this.city = city;
	}
	public synchronized String getPinyin() {
		return pinyin;
	}
	public synchronized void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public synchronized String getCitycode() {
		return citycode;
	}
	public synchronized void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public synchronized String getDate() {
		return date;
	}
	public synchronized void setDate(String date) {
		this.date = date;
	}
	public synchronized String getTime() {
		return time;
	}
	public synchronized void setTime(String time) {
		this.time = time;
	}
	public synchronized String getPostCode() {
		return postCode;
	}
	public synchronized void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public synchronized String getLongitude() {
		return longitude;
	}
	public synchronized void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public synchronized String getLatitude() {
		return latitude;
	}
	public synchronized void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public synchronized String getAltitude() {
		return altitude;
	}
	public synchronized void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public synchronized String getWeather() {
		return weather;
	}
	public synchronized void setWeather(String weather) {
		this.weather = weather;
	}
	public synchronized String getTemp() {
		return temp;
	}
	public synchronized void setTemp(String temp) {
		this.temp = temp;
	}
	public synchronized String getL_tmp() {
		return l_tmp;
	}
	public synchronized void setL_tmp(String l_tmp) {
		this.l_tmp = l_tmp;
	}
	public synchronized String getH_tmp() {
		return h_tmp;
	}
	public synchronized void setH_tmp(String h_tmp) {
		this.h_tmp = h_tmp;
	}
	public synchronized String getWD() {
		return WD;
	}
	public synchronized void setWD(String wD) {
		WD = wD;
	}
	public synchronized String getWS() {
		return WS;
	}
	public synchronized void setWS(String wS) {
		WS = wS;
	}
	public synchronized String getSunrise() {
		return sunrise;
	}
	public synchronized void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public synchronized String getSunset() {
		return sunset;
	}
	public synchronized void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public synchronized String getErrmsg() {
		return errmsg;
	}
	public synchronized void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public synchronized String getErrno() {
		return errno;
	}
	public synchronized void setErrno(String errno) {
		this.errno = errno;
	}
	
	
	
}