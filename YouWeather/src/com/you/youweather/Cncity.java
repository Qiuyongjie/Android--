package com.you.youweather;

public class Cncity {
	private String name;
	private String pinyin;
	
	public synchronized String getName() {
		return name;
	}
	public synchronized void setName(String name) {
		this.name = name;
	}
	public synchronized String getPinyin() {
		return pinyin;
	}
	public synchronized void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
}
