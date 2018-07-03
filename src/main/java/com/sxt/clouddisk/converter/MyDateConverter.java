package com.sxt.clouddisk.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyDateConverter implements Converter<String,Date> {


	public Date convert(String source) {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sm.parse(source);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
