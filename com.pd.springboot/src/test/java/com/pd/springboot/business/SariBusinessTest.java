package com.pd.springboot.business;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.pd.businessobject.MapVO;
import com.pd.common.util.FileUtil;
import com.pd.common.util.StringX;
import com.pd.common.util.WebUtil;

public class SariBusinessTest {

	@Test
	public void test() {
		String httpStr = WebUtil.post("https://www.zhihu.com/special/19681091/trends", null);
		MapVO vo = new MapVO();
		vo.put("type", "sari");
		vo.put("creationDate", new Date());
		vo.put("parseBean", "html");
		vo.put("value", httpStr);
		FileUtil.writeOrOverwrite(httpStr, "E:/bigdata/saridaily/",
				StringX.date(new Date(), "yyyyMMddHHmmss") + ".txt");
	}

}
