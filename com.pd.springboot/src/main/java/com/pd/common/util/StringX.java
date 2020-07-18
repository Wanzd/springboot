package com.pd.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.pd.businessobject.MapVO;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class StringX {

	public static String from(Object in) {
		if (in == null) {
			return null;
		}
		return JSON.toJSONString(in);
	}

	public static String obj2json(Object obj) {
		return JSON.toJSONString(obj);
	}

	public final static String BLANK = "";

	public static <IN> String attr(IN in, String attrName) {
		if (in instanceof Map) {
			return str(((Map) in).get(attrName));
		}
		return str(Reflects.field(in, attrName));
	}

	public static <IN> String str(IN in) {
		if (in == null) {
			return null;
		}
		return in.toString();
	}

	public static String cap(String dimension) {
		if (dimension == null || dimension.length() == 0) {
			return dimension;
		}
		return dimension.substring(0, 1).toUpperCase() + dimension.substring(1);
	}

	public static String decap(String dimension) {
		if (dimension == null || dimension.length() == 0) {
			return dimension;
		}
		return dimension.substring(0, 1).toLowerCase() + dimension.substring(1);
	}

	public static String freeMarker(String ftlName, MapVO vo) {
		Writer out = new StringWriter();
		Configuration cfg = new Configuration(Configuration.getVersion());
		try {
			Template tmp = cfg.getTemplate(ftlName);
			tmp.process(vo, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String date(Date date, String formatter) {
		DateFormat df = new SimpleDateFormat(formatter);
		return df.format(date);
	}

	public static String file(File file) {
		return FileUtil.readAll(file);
	}

	public static String clob(Clob clob) {
		String reString = "";
		Reader is;
		try {
			is = clob.getCharacterStream();
			// 得到流
			BufferedReader br = new BufferedReader(is);
			String tmp = null;
			StringBuffer sb = new StringBuffer();
			while ((tmp = br.readLine()) != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
				sb.append(tmp);
			}
			reString = sb.toString();
			return reString;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return BLANK;
	}

	public static String nvl(String str, String defaultValue) {
		if (str == null || str.length() == 0) {
			return defaultValue;
		}
		return str;
	}
}
