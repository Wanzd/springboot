package com.pd.springboot.task;

import java.util.Date;

import javax.inject.Named;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.businessobject.MapVO;
import com.pd.common.calobject.TimerCO;
import com.pd.common.util.StringX;
import com.pd.standard.itf.ITask;

@Named
public class SariParseTodayTask implements ITask {
	public static final String TITLE = "sariParseTodayTask";
	// @Autowired
	// private SariBusiness business;

	@Override
	public Object process() {
		TimerCO timer = new TimerCO(TITLE);
		MapVO fo = new MapVO();
		fo.put("creationDate", new Date());
		// business.init(fo);
		// business.process(fo);
		// return timer.end();
		timer.end();
		String preStr = StringX.obj2json(timer);
		return preStr;
	}
}
