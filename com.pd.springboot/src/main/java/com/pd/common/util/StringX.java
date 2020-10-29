package com.pd.common.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

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

    public static String file(File file) {
        return FileUtil.readAll(file);
    }

    public static String between(String target, String fromStr, String toStr) {
        int startIdx = target.indexOf(fromStr);
        if (startIdx < 0) {
            return null;
        }
        String tmpStr = target.substring(startIdx + fromStr.length());
        int endIdx = tmpStr.indexOf(toStr);
        if (endIdx < 0) {
            return null;
        }
        tmpStr = tmpStr.substring(0, endIdx);
        return tmpStr;
    }

}
