package com.fs.exam;

public class MyThread{
	
	
	public static void main(String[] args) {
		new Thread(){
			public void run() {
				System.out.println("nil");
			};
		}.start();
		
		TH th = new TH();
		th.run();
	}
}
	class TH implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			System.out.print("0000");		
			}
		
	
}
