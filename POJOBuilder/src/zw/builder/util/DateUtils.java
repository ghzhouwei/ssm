package zw.builder.util;

import java.util.Date;

/**
 * @ClassName: DateUtils
 * @Description: 时间工具类
 * @author 周威
 * @date 2020年6月4日 - 下午1:23:57
 */
@SuppressWarnings("all")
public class DateUtils
{
	private Date date = new Date();
	
	public String getYear()
	{
		return date.getYear() + 1900 + "";
	}
	
	public String getMonth()
	{
		int month = date.getMonth() + 1;
		if(month<10)
			return "0" + month;
		return month + "";
	}
	
	public String getDay()
	{
		int day = date.getDay();
		if(day<10)
			return "0" + day;
		return day + "";
	}
	
	public String getHours()
	{
		int hours = date.getHours();
		if(hours<12)
		{
			if(hours<10)
				return "上午" + "0" + hours;
			return "上午" + hours;
		}
		else
		{
			hours = hours - 12;
			if(hours<10)
				return "下午" + "0" + hours;
			return "下午" + hours;
		}
	}
	
	public String getMinutes()
	{
		int minutes = date.getMinutes();
		if(minutes<10)
			return "0" + minutes;
		return "" + minutes;
	}
	
	public String getSeconds()
	{
		int seconds = date.getSeconds();
		if(seconds<10)
			return "0" + seconds;
		return "" + seconds;
	}
	
	public String getDateTime()
	{
		return getYear() +"年" + getMonth() + "月" + getDay() + "日 - " + getHours() + ":" + getMinutes() + ":" + getSeconds();
	}
	
}
