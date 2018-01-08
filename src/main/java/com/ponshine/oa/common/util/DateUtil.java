package com.ponshine.oa.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DateUtil {
	public static final String hour = "HH:mm:ss";//年份
	  public static final String year = "yyyy";//年份
	  public static final String month = "yyyy-MM";//月份
	  public static final String day = "yyyy-MM-dd";//完整日期
	  public static final String min = "yyyy-MM-dd HH:mm";//完整时分
	  public static final String second = "yyyy-MM-dd HH:mm:ss";//完整时分秒
	  public static final String milliseconds = "yyyyMMddHHmmssSSS";//完整时分秒毫秒
	  
	  /**
	  	将时间格式化，以字符串形式返回
	   * */
	  public static String changeDateToString(Date date,String formatStr){
		  DateFormat format = new SimpleDateFormat(formatStr);
		  String reTime = format.format(date);
		  return reTime;
	  }
	  /**
	  	将时间格式化，以字符串形式返回
	   * */
	  public static Date changeStringToDate(String date,String formatStr) throws ParseException{
		  DateFormat format = new SimpleDateFormat(formatStr);
		  Date result = null;
		result =  (Date)format.parse(date);
		return result;
	  }
	  
	  /**当前时间延迟 n  天数
	 * @param day
	 * @return
	 */
	public static Date delayDay(int day){
		  Calendar curr = Calendar.getInstance();
		  curr.set(Calendar.DAY_OF_MONTH,curr.get(Calendar.DAY_OF_MONTH)+day);
		  Date date=curr.getTime();
		  return date;
	 }
	/**当前时间延迟 n  小时
	 * @param day
	 * @return
	 */
	public static Date delayHour(Date d,int hour){
		Calendar curr = Calendar.getInstance();
		curr.setTime(d);
		curr.set(Calendar.HOUR_OF_DAY,curr.get(Calendar.HOUR_OF_DAY)+hour);
		Date date=curr.getTime();
		return date;
	}
	
	/**当前时间延迟 n  分钟
	 * @param day
	 * @return
	 */
	public static Date delayMinute(Date d,int minute){
		Calendar curr = Calendar.getInstance();
		curr.add(Calendar.MINUTE, minute);
		Date date=curr.getTime();
		return date;
	}
	
	/**当前时间延迟 n 月
	 * @param month,延迟月数，负数表示提前
	 * @return
	 */
	public static Date delayMonth(int month){
		  Calendar curr = Calendar.getInstance();
		  curr.set(Calendar.MONTH,curr.get(Calendar.MONTH)+month);
		  Date date=curr.getTime();
		 return date;
	}
	
	/**当前时间延迟 n 年
	 * @param day
	 * @return
	 */
	public static Date delayYear(int year){
		 Calendar curr = Calendar.getInstance();
		  curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)+year);
		  Date date=curr.getTime();
		return date;
	}
	
	/**取前几年的列表    数字-文字
	 * @param date 时间
	 * @param pre  前几年  数字
	 * @return
	 */
	public static Map<Integer,String> getPrevYear(Date date,int pre){
		Map<Integer,String> map = new LinkedHashMap<Integer, String>();
		try {
			String yearStr = changeDateToString(date, DateUtil.year);
			int year = Integer.parseInt(yearStr);
			for(int y=year;y>=(year-pre);y--){
				map.put(y, y+"年");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return map;
	}
	
	/**得到12个月的map   
	 * @return
	 */
	public static Map<String,String> getMonthMap(){
		Map<String,String> map = new LinkedHashMap<String, String>();
		 for(int i=1;i<=12;i++){
			 if(i<10)
				 map.put("0"+i, i+"月");
			 else
				 map.put(""+i, i+"月");
		 }
		 return map;
	}
	
	/**
	 * 得到指定月第一天String 格式MM/dd/yyyy
	 * @return
	 */
	public static String getMonthFirstDay(Date date) {     
	    Calendar calendar = Calendar.getInstance();     
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));     
	    return changeDateToString(calendar.getTime(),"MM/dd/yyyy");     
	}     
	    
	/**   
	 * 得到指定月最后一天String 格式MM/dd/yyyy
	 * @return   
	 */    
	public static String getMonthLastDay(Date date) {     
	    Calendar calendar = Calendar.getInstance();    
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar     
	            .getActualMaximum(Calendar.DAY_OF_MONTH));     
	    return changeDateToString( calendar.getTime(),"MM/dd/yyyy");     
	}     
	
	/**比较两个时间的大小
	 * @param  date1  时间1
	 * @param  date2  时间2
	 * @return  1：date1>date2;-1:date1<date2;0:date1=date2
	 */
	public static int compare_date(String date1,String date2){
		try {               
			Date d1 = changeStringToDate(date1,hour);
			Date d2 = changeStringToDate(date2,hour);
			if (d1.getTime() > d2.getTime()){                                               
				return 1;
			}else if (d1.getTime() < d2.getTime()){
				return -1;
			}else{
				return 0;
			}       
		}catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;	  
	}//end function
	/**比较两个时间的大小,精确到分钟
	 * @param  date1  时间1
	 * @param  date2  时间2
	 * @return  1：date1>date2;-1:date1<date2;0:date1=date2
	 */
	public static int compare_date_min(String date1,String date2){
		  try {               
			  Date d1 = changeStringToDate(date1,min);
			  Date d2 = changeStringToDate(date2,min);
			  if (d1.getTime() > d2.getTime()){                                               
				  return 1;
			  }else if (d1.getTime() < d2.getTime()){
				  return -1;
		      }else{
		    	  return 0;
		      }       
	      }catch (Exception exception) {
	    	  exception.printStackTrace();
	      }
	      return 0;	  
	}//end function
	
	/**两个时间相减,精确到秒
	 * @param  date1  时间1  
	 * @param  date2  时间2
	 * @return  date1-date2的绝对值（毫秒） 异常为-1
	 */
	public static int compare_date_second(String date1,String date2){
		Date d1 = null;
		Date d2 = null;
		try {               
			d1 = changeStringToDate(date1,second);
			d2 = changeStringToDate(date2,second);
			return Math.abs((int) (d1.getTime() - d2.getTime()));
	    }catch (Exception exception) {
	    	exception.printStackTrace();
	    	return -1;
	    }
	}//end function
	
	/**
	 * desc：Date转换为String
	 * 
	 * @param date
	 *            需要转换的date
	 * @param format
	 *            格式字符串
	 * @return 返回按照格式转化后的字符串 DateUtil.toString(new Date(),"yyyy-MM-dd HH:mm:ss SSS")
	 */
	public static String toString(Date date, String format) {
		if (date != null) {
			SimpleDateFormat dateformatter = new SimpleDateFormat(format);
			String dateString = dateformatter.format(date);
			return dateString;
		} else {
			return null;
		}
	}
	
	/** 
     * 判断时间格式 格式必须为“yyyy-MM” 
     * 2004-2 是无效的 
     * 2003-2-29 是无效的 
     * @param sDate 
     * @param dateType 时间格式“yyyy-MM” 、“yyyy-MM-dd”
     * @return 
     */  
	public static boolean isValidDate(String str,String dateType) { 
		 //String str = "2017-01";  
        DateFormat formatter = new SimpleDateFormat(dateType);  
        try{  
            Date date = (Date)formatter.parse(str);  
            return str.equals(formatter.format(date));  
        }catch(Exception e){  
            return false;  
        }  
	}

}
