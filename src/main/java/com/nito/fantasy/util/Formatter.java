package com.nito.fantasy.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Formatter {

	public static String formatNumber(Integer value) {
		DecimalFormat formatter = new DecimalFormat("#,###,###,###");
		String aux = null;
		try {
			if (value != null && !"".equals(value)) {
				aux = formatter.format(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;
	}

	public static Double formatNumber2dec(Double value) {
		Double aux = null;
		try {
			if (value != null) {
				aux = Math.round(value * 100.0) / 100.0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;
	}

	public static Double formatNumber4dec(Double value) {
		Double aux = null;
		try {
			if (value != null) {
				aux = Math.round(value * 10000.0) / 10000.0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;
	}

	public static Date parseDate(String value) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault());
		Date aux = null;
		try {
			if (value != null && !"".equals(value)) {
				aux = df.parse(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;
	}

	public static String formatDateFromString(String value) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault());
		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
		String aux = null;
		try {
			if (value != null && !"".equals(value)) {
				aux = df2.format(df.parse(value));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;
	}

	public static String formatDate(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String aux = null;
		try {
			if (date != null && !"".equals(date)) {
				aux = formatter.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;
	}

	public static String formatDateToId(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String aux = null;
		try {
			if (date != null && !"".equals(date)) {
				aux = formatter.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;
	}

	public static String parseNull(String s) {
		String aux = s;
		try {
			if (s == null || "".equals(s)) {
				aux = "-";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aux;
	}
}
