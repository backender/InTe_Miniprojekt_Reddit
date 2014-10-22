package reddit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer {

	public String getTimeDiff(Date createdAt) throws ParseException{
		//SimpleDateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy"); //"Wed Oct 22 11:12:42 CEST 2014"
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); //"01/15/2012 10:31:48"
		Date d1 = format.parse(createdAt.getMonth() + "/" + createdAt.getDay() + "/" + createdAt.getYear() + " " + createdAt.getHours() + ":" + createdAt.getMinutes() + ":" + createdAt.getSeconds());
		Date d2 = format.parse(new Date().getMonth() + "/" + new Date().getDay() + "/" + new Date().getYear() + " " + new Date().getHours() + ":" + new Date().getMinutes() + ":" + new Date().getSeconds());
		long diff = d2.getTime() - d1.getTime();
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		
		String text;
		if(diffHours < 1){
			if(diffMinutes < 1){
				text = diffSeconds + " seconds";
			} else {
				text = diffMinutes + " minutes";	
			}
		} else {
			text = diffHours + " hours";
		}
		return text;	
	}
}
