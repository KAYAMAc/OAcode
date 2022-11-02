/*
oa代码2
题目描述:
将JST标准的日期转换为UTC日期后,找到过去最近的weekday和未来最近的weekday
输入：第一行整数n,后面n行每行一个日期 yyyy-MM-dd HH:mm:ss
输出：一共n行,每行包括一两个日期,以斜线隔开
例:
1
2010-10-10 10:10:10
2010-10-05/2010-10-15
*/
package Solutions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
public class Solution_problem2 {
	
	private static String get_nearest_weekday(Date utc_date) {
		SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c_future = Calendar.getInstance();
		Calendar c_past = Calendar.getInstance();
		c_future.setTime(utc_date);
		c_past.setTime(utc_date);
		c_past.add(Calendar.DATE, -5);
		c_future.add(Calendar.DATE, 5);
		while ((c_future.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) 
	            || (c_future.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
			c_future.add(Calendar.DATE, 1);
		}
		while ((c_past.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) 
	            || (c_past.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
			c_past.add(Calendar.DATE, -1);
		}
		Date date_future = c_future.getTime();
		Date date_past = c_past.getTime();
		return utcFormat.format(date_past)+"/"+utcFormat.format(date_future);
	}
	
	private static Date jst_to_utc(String jst_date) throws ParseException {
		SimpleDateFormat jstFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jstFormat.setTimeZone(TimeZone.getTimeZone("JST"));
		Date date = jstFormat.parse(jst_date);
		SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd");
		utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date utc_date = utcFormat.parse(utcFormat.format(date));
		return utc_date;
	}
	
	public static void main(String []args) throws ParseException {
		Scanner input=new Scanner(System.in);
        String number=input.nextLine();
        int input_number=Integer.parseInt(number);
        ArrayList<String> ans=new ArrayList<String>();
        for(int x=0;x<input_number;x++) {
        	String input_date=input.nextLine();
			if(input_date==""){
				System.out.println("晩原を秘薦してください。: yyyy-MM-dd HH:mm:ss");
				input_number++;
			}
			else {
				try {
					Date utc_date=jst_to_utc(input_date);
		    		ans.add(get_nearest_weekday(utc_date));
				}
				catch (Exception e) {
					input_number++;
					System.out.println("屎しい晩原を秘薦してください。: yyyy-MM-dd HH:mm:ss");
				}
			}
        }
        input.close();
        for(String a:ans.toArray(new String[0])) {
        	System.out.println(a);
        }
	}
}
