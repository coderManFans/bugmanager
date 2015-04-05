package cn.com.bugmanager.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期操作的工具类
 * @author Administrator
 * 2013-5-2
 * @version 1.0
 */
public class CalendarUtils {
	  /**
	    * 格式化输出当前日期
	    * @return
	    */
	    public static String FormatDate(){       
	    	Date date = new Date();
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	String time = sdf.format(date);
	    	return time;
	    }
		
		/**
		 * calendar获得当前日期
		 */
		public  static String getDateTime(){
	    	Calendar calendar=Calendar.getInstance();
	    	int month=calendar.get(Calendar.MONTH)+1;
	    	int date=calendar.get(Calendar.DATE);
	    	int hour=calendar.get(Calendar.HOUR_OF_DAY);
	    	int minute=calendar.get(Calendar.MINUTE);
	    	int second=calendar.get(Calendar.SECOND);
	    	return calendar.get(Calendar.YEAR)+"-"+( month>=10?month:"0"+month)+"-"+(date>=10?date:"0"+date)+" "+(hour>=10?hour:"0"+hour)+":"+(minute>=10?minute:"0"+minute)+":"+(second>=10?second:"0"+second);
	    }
		/**
		 * calendar获得当前日期
		 */
		public  static String getDate(){
	    	Calendar calendar=Calendar.getInstance();
	    	return calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
	    }
		 
	    /**
	     * 日期增、减X天后的日期(注意date*24*3600*1000前加“L”，转成Long类型，否则加减月份过大会出现越加越小的情况)
	     */
		public  static String dateDiffAddDays(int date){
	    	Calendar calendar=Calendar.getInstance();
	    	calendar.setTimeInMillis(calendar.getTimeInMillis()+date*24*3600*1000L);
	    	
	    	return calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE)+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
	    }
	  
		/**
		 * 月份增减X天后的日期
		 */
	    public static String dateAddDiffDAY_OF_MONTH(int date){
	    	Calendar calendar=Calendar.getInstance();
	    	calendar.add(Calendar.DAY_OF_MONTH, date);
	    	return calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
	    }
	    
	    /**
	     * 计算今天与传入日期相差的天数
	     */
	    public static int dateDiffDays(int year,int month,int date){
	    	Calendar calendar=Calendar.getInstance();
	    	Calendar calendar2=Calendar.getInstance();
	    	calendar.set(year, month-1, date);
	    	return (int)((calendar2.getTimeInMillis()-calendar.getTimeInMillis())/1000/3600/24L);
	    }
	    /**
	     *  计算指定日期与传入日期相差的天数
	     * @param year1
	     * @param month1
	     * @param date1
	     * @param year
	     * @param month
	     * @param date
	     * @return
	     */
	    public static int dateDiffDay(int year1,int month1,int date1,int year,int month,int date){
	    	Calendar calendar=Calendar.getInstance();
	    	Calendar calendar2=Calendar.getInstance();
	    	calendar2.set(year1, month1-1, date1);
	    	calendar.set(year, month-1, date);
	    	return (int)((calendar2.getTimeInMillis()-calendar.getTimeInMillis())/1000/3600/24L);
	    }
	    /**
	     * 计算今天与传入日期相差的时间 
	     * 
	     * 1场:2013-6-14 19:30-----2013-6-14 20:30
	     * 
	     * 2：  2013-6-14 20:00-----2013-6-14 21:00     （ 2开始-1场电影开始）-1场片长> 30min 
	     * 
	     */
	    public static int dateDiffTimes(int year,int month,int date,int hour,int minute,int second){
	    	Calendar calendar=Calendar.getInstance();
	    	Calendar calendar2=Calendar.getInstance();
	    	calendar.set(year, month-1, date,hour,minute,second);
	    	return (int)((calendar2.getTimeInMillis()-calendar.getTimeInMillis())/1000/3600/24L);
	    }
	    
	    /**
	     * 计算今天与传入日期相差的时间
	     */
	    public static int dateDiffTime(int year,int month,int date,int hour,int minute,int second){
	    	Calendar calendar=Calendar.getInstance();
	    	Calendar calendar2=Calendar.getInstance();
	    	calendar.set(year, month-1, date,hour,minute,second);
	    	return (int)((calendar2.getTimeInMillis()-calendar.getTimeInMillis())/1000/3600/24L);
	    }
	    
	    
	    /**
	     * 计算今天与传入日期相差的时间 2012-05-18 12:22:10
	     */
	    public  int dateDiffTimeToSecond(String dateTime){
	        System.out.println("传过来的时间"+dateTime);
	    	String timeString=dateTime;
	    	String dayString=timeString.substring(0,10);
	    	String hourString=timeString.substring(11,18);
	    	String[]  daytime=dayString.split("/");
	    	String[]  hourtime=hourString.split(":");
	    	Calendar calendar=Calendar.getInstance();
	    	Calendar calendar2=Calendar.getInstance();
	    	calendar.set(Integer.valueOf(daytime[0]), Integer.valueOf(daytime[1])-1, Integer.valueOf(daytime[2])+1,Integer.valueOf(hourtime[0]),Integer.valueOf(hourtime[1]),Integer.valueOf(hourtime[2]));
	    	return (int)(((calendar2.getTimeInMillis()-calendar.getTimeInMillis())/1000/3600/24l));
	    }
	    
	    /**
	     * 计算从原来时间基础上增加续借的若干天之后的应还时间
	     */
	    public static String dateDiffTimeToSecond(String dateTime,int days){
	    	System.out.println("传过来的时间"+dateTime);
	    	String timeString=dateTime;
	    	String dayString=timeString.substring(0,10);
	    	String hourString=timeString.substring(11,19);
	    	String[]  daytime=dayString.split("-");
	    	String[]  hourtime=hourString.split(":");
	    	Calendar calendar=Calendar.getInstance();
	     	calendar.set(Integer.valueOf(daytime[0]), Integer.valueOf(daytime[1])-1, Integer.valueOf(daytime[2])+days,Integer.valueOf(hourtime[0]),Integer.valueOf(hourtime[1]),Integer.valueOf(hourtime[2]));
	     	return calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE)+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
	    }
	    
	    /**
	     * 计算从原来时间基础上增加续借的若干天之后的应还时间
	     */
	    public static String dateDiffTimeToSecond2(String dateTime,int days){
	    	System.out.println("传过来的时间"+dateTime);
	    	String timeString=dateTime;
	    	String dayString=timeString.substring(0,10);
	    	String hourString=timeString.substring(11,19);
	    	String[]  daytime=dayString.split("-");
	    	String[]  hourtime=hourString.split(":");
	    	Calendar calendar=Calendar.getInstance();
	     	calendar.set(Integer.valueOf(daytime[0]), Integer.valueOf(daytime[1])-1, Integer.valueOf(daytime[2])+days,Integer.valueOf(hourtime[0]),Integer.valueOf(hourtime[1]),Integer.valueOf(hourtime[2]));
	    	//return (int)(((calendar2.getTimeInMillis()-calendar.getTimeInMillis())/1000/3600/24l));
	     	return calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE)+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
	    }
	    
	    public static void splitDemo(){
	    	String timeString="2012-05-18 12:22:10.0";
	    	String dayString=timeString.substring(0,10);
	    	String hourString=timeString.substring(11,19);
	    	String[]  time1=dayString.split("-");
	    	String[]  time2=hourString.split(":");
	    	for (int i = 0; i < time1.length; i++) {
	    		System.out.println(time1[i]);
			}
	    	for (int i = 0; i < time2.length; i++) {
	    		System.out.println(time2[i]);
			}
	    	
	    }
	    
	    public static  void mathRandomDemo(){
	    	for (int i = 0; i < 10; i++) {
	    		System.out.println((int)(Math.random()*10000));
			}
	    }
	    
	    /**
	     * 
	     * @param args
	     */
	    public static void main(String[] args) {
//	    	CalendarUtils calendar=new CalendarUtils();
//	    	 System.out.println(dateDiffTimes(2012,4,9,12,3,5));
//	    	System.out.println( getDateTime() );
//	        	splitDemo();
//	    	 System.out.println(dateDiffTimeToSecond2("2012-05-11 11:36:10",31));
//	    	mathRandomDemo();//2012-05-11 11:55:04
//	  //  	System.out.println(dateDiffTimeToSecond("2012-05-13 16:03:11"));
//	    	System.out.println(getDate());
	    	System.out.println(getDate());
	    	System.out.println(" getDateTime()    "+ getDateTime());
	    	
		}
}
