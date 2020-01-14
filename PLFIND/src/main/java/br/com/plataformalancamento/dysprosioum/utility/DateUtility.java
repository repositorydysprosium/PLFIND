package br.com.plataformalancamento.dysprosioum.utility;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jboss.logging.Logger;


public class DateUtility implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(DateUtility.class);
	
	private static final String DATE_FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
	
	public static Date converterDataStringEmDate(String dataParameter) {
		if(dataParameter != null) {
			try {
				return new SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY).parse(dataParameter);
			} catch (ParseException e) {
				LOGGER.info(e.getMessage());
			}
		}
		return null;
	}
	
	/***
	 * Responsavel por acrescentar numero de dias a uma determinada data
	 * @param dataParameter
	 * @param numeroDias
	 * @return
	 */
	public static Date acrescentarDiasDate(Date dataParameter, Integer numeroDias) {
		Calendar calendar = converterDateCalendar(dataParameter);
			calendar.add(Calendar.DAY_OF_MONTH, numeroDias);
		return calendar.getTime();
	}
	
	private static Calendar converterDateCalendar(Date dataParameter) {
		Calendar calendar = Calendar.getInstance();
			calendar.setTime(dataParameter);
		return calendar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static String getDateFormatDdMmYyyy() {
		return DATE_FORMAT_DD_MM_YYYY;
	}
	
}
