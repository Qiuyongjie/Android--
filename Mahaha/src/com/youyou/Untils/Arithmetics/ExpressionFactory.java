package com.youyou.Untils.Arithmetics;

import java.util.ArrayList;

public class ExpressionFactory {
		
	private static ArrayList<String> factors;
	private static String editString;
	/***
	 * Split expression factors .
	 * @param args
	 * @return String[]
	 */
	public static boolean spliter(String str,ArrayList<Double> al,
			ArrayList<String> op) {
		
		//�滻�С�e��
		int flags = 0;
		if((flags = str.indexOf("e"))>= 0){
			while(flags < str.length())
			{
				if(str.charAt(flags) == 'e')
				{
					//saddddddddddddddddddd
					str.replace("e","2.71828");
				}
				flags++;
			}
		}
		
		flags = 0;
		
		if((flags = str.indexOf("��"))>= 0){
			while(flags < str.length())
			{
				if(str.charAt(flags) == '��')
				{
					//saddddddddddddddddddd
					str.replace("��","3.14159265743");
				}
				flags++;
			}
		}
		
		
		
		
		
		
		int i = 0;
		String tmp= "";
		while(i < str.length())
		{
			char ch = str.charAt(i);
			if((ch >= 0&& ch <= 9)|| ch == '.' )
			{
				tmp += ch;
			}
			else
			{
				if(!tmp.isEmpty()){
					al.add(Double.valueOf(tmp));
					tmp = "";
				}
			}
			i++;
		}
		if(!tmp.isEmpty())
			al.add(Double.valueOf(tmp));
		
		tmp = "";
		int j = 0;
		
		return true;
	}
	
	
}
