package com.coder.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {
	public static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
	private static String datePattern = "dd-MMM-yyyy";
	private static String timePattern = datePattern + " hh:mm:ss";

	/**
	 * Return default datePattern (MM/dd/yyyy)
	 * 
	 * @return a string representing the date pattern on the UI
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static String getDatePattern() {
		return datePattern;
	}

	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static final String getDate(Date aDate) {
		SimpleDateFormat df;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(datePattern);
			returnValue = df.format(aDate);
		}

		return returnValue;
	}// END of getDate

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
		SimpleDateFormat df;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		logger.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			logger.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return date;
	}// END of convertStringToDate

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(timePattern, theTime);
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 * 
	 * @return the current date
	 * @throws ParseException
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static Calendar getToday() throws ParseException {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(datePattern);

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(convertStringToDate(todayAsString));

		return cal;
	}// END of getToday

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df;
		String returnValue = "";

		/**
		 * if (aDate == null) { // logger.info("aDate is null!"); } else { df =
		 * new SimpleDateFormat(aMask); returnValue = df.format(aDate); }
		 * * @version 1.0
		 * 
		 * @author pankajbharti
		 */

		if (aDate != null) {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return returnValue;
	}// END of getDateTime

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static final String convertDateToString(Date aDate) {
		return getDateTime(datePattern, aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate
	 *            the date to convert (in format MM/dd/yyyy)
	 * @return a date object
	 * 
	 * @throws ParseException
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static Date convertStringToDate(String strDate) throws ParseException {
		Date aDate = null;

		try {

			logger.debug("converting date with pattern: " + datePattern);
			aDate = convertStringToDate(datePattern, strDate);
		} catch (ParseException pe) {
			logger.error("Could not convert '" + strDate + "' to a date, throwing exception", pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return aDate;
	}// END of convertStringToDate

	public static java.sql.Date convertStringToSqlDate(String strDate) throws ParseException {
		Date aDate = null;

		try {

			logger.debug("converting date with pattern: " + datePattern);
			aDate = convertStringToDate(datePattern, strDate);
		} catch (ParseException pe) {
			logger.error("Could not convert '" + strDate + "' to a date, throwing exception", pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return new java.sql.Date(aDate.getTime());
	}// END of convertStringToDate

	/**
	 * 
	 * 
	 * 
	 * This method converts a date represented as a long (# of milliseconds
	 * since 1970) to a String date
	 * 
	 * @param ldate
	 *            the date to convert (long)
	 * @param dateFormat
	 *            the format of date in String
	 * @return a date object
	 * 
	 * @throws ParseException
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static String convertLongDateToString(long ldate, String dateStringPattern) throws ParseException {
		String sDateTime = null;

		if (dateStringPattern == null) {
			dateStringPattern = timePattern;
		}

		SimpleDateFormat simpleDateformat = new SimpleDateFormat(dateStringPattern);

		logger.debug("converting date " + ldate + " with pattern: " + dateStringPattern);

		try {
			Date dateTime = new Date(ldate);
			sDateTime = simpleDateformat.format(dateTime);
		} catch (Exception e) {
			logger.error("Could not convertLongDateToString: ", e);
		}

		return sDateTime;
	}// END of convertLongDateToString

	/*
	 * 
	 * This method return today date in DD-MON-YYYY format as string
	 * 
	 * @version 1.0
	 * 
	 * @author pankajbharti
	 */
	public static String getTodayDate() {
		return convertDateToString(new Date());

	}

	/**
	 * Checks whether the first date is after date of second or not.
	 * 
	 * @param first
	 * @param second
	 * @return boolean result
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static boolean isAfter(Date first, Date second) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(first);
		int firstYear = cal.get(Calendar.YEAR);
		int firstMonth = cal.get(Calendar.MONTH);
		int firstDay = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(second);
		int secondYear = cal.get(Calendar.YEAR);
		int secondMonth = cal.get(Calendar.MONTH);
		int secondDay = cal.get(Calendar.DAY_OF_MONTH);
		if (firstYear > secondYear)
			return true;
		else if (firstYear == secondYear) {
			if (firstMonth > secondMonth)
				return true;
			else if (firstMonth == secondMonth) {
				if (firstDay > secondDay) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This Method Convert the Date Object into XMLGregorianCalender Object
	 * 
	 * @param date
	 * @return XMLGregorianCalendar
	 * @throws DatatypeConfigurationException
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static XMLGregorianCalendar getXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {

		XMLGregorianCalendar xmlCal = null;

		try {
			xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar();

			Calendar calendar = Calendar.getInstance();

			calendar.setTime(date);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int year = calendar.get(Calendar.YEAR);

			xmlCal.setDay(day);
			xmlCal.setMonth(month);
			xmlCal.setYear(year);
			xmlCal.setTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),
					calendar.get(Calendar.SECOND));
		} catch (DatatypeConfigurationException e) {
			logger.error("DatatypeConfigurationException : " + e);
		}
		return xmlCal;
	}

	public static Date getDate(XMLGregorianCalendar xmlCal) {
		/** return new Date(xmlCal.getMillisecond()); */
		return xmlCal.toGregorianCalendar().getTime();
	}

	/**
	 * This method is used to calculate the future date
	 * 
	 * @param date
	 * @param noOfDays
	 * @return
	 * @version 1.0
	 * @author pankajbharti
	 */
	public static Date calculateFutureDate(Date date, int noOfDays) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, noOfDays);
		/** eightDBean.setExpectedCompletionDate(c.getTime()); */
		return calendar.getTime();
	}

	public static Date formatDate(Date date) {
		DateFormat formatter = DateFormat.getDateTimeInstance();
		String strDate = DateFormat.getDateTimeInstance().format(date);
		Date formatedDate = null;
		try {
			formatedDate = formatter.parse(strDate);
		} catch (ParseException e) {
			logger.error("error while parsing date " + strDate);
		}
		return formatedDate;
	}

	@SuppressWarnings("deprecation")
	public static boolean compareDate(Date d1, Date d2) {
		Calendar calender1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calender1.set(d1.getYear(), d1.getMonth(), d1.getDate());
		calendar2.set(d2.getYear(), d2.getMonth(), d2.getDate());
		return calender1.after(calendar2);
	}

}
