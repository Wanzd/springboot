package com.pd.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class StaticTool {

    public final static String BLANK = "";

    public static boolean isEmpty(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            return str.trim().length() == 0;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            return list.size() == 0;
        }
        return obj == null;
    }

    public static String objToJsonStr(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static String clobToStr(Clob clob) {
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

    public static String objToStr(Object in) {
        if (in == null) {
            return null;
        }
        return in.toString();
    }

    public static String strCap(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String strDecap(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String dateToStr(Date date, String formatter) {// fitrew3rf4
        DateFormat df = new SimpleDateFormat(formatter);
        return df.format(date);
    }

    public static <T> T nvl(T in, T defaultValue) {
        return in != null ? in : defaultValue;
    }

    public static <T> List<T> strToList(String str, Class<T> outClass) {
        try {
            return JSON.parseArray(str, outClass);
        } catch (Exception e) {
            System.out.println("StringX.toList start:" + str);
            System.out.println("StringX.toList failed:" + e.getMessage());
        }
        return null;
    }
}
