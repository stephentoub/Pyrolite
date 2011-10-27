package net.razorvine.pickle.objects;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Helper class to mimic the datetime.timedelta Python object (holds a days/seconds/microsec time difference).
 * 
 * @author Irmen de Jong (irmen@razorvine.net)
 */
public class TimeDelta implements Serializable {
	private static final long serialVersionUID = 5793744158850914421L;
	public int days;
	public int seconds;
	public int microseconds;
	public double total_seconds;

	public TimeDelta(int days, int seconds, int microseconds) {
		this.days = days;
		this.seconds = seconds;
		this.microseconds = microseconds;
		this.total_seconds = days*86400+seconds+microseconds/1000000.0;
	}
	
	public String toString() {
		NumberFormat nf=NumberFormat.getInstance(Locale.UK);
		nf.setGroupingUsed(false);
		nf.setMaximumFractionDigits(6);
		String floatsecs=nf.format(total_seconds);
		return String.format("Timedelta: %d days, %d seconds, %d microseconds (total: %s seconds)", days, seconds, microseconds, floatsecs);
	}
}