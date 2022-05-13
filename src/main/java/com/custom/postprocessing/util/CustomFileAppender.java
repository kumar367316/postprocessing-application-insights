package com.custom.postprocessing.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import ch.qos.logback.core.FileAppender;

@SuppressWarnings("rawtypes")
public class CustomFileAppender extends FileAppender {

	@Override
	public void setFile(String fileName) {
		if (fileName.indexOf("%timestamp") >= 0) {
			Date d = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSS");
			fileName = fileName.replaceAll("%timestamp", format.format(d));
		}
		super.setFile(fileName);
	}
}