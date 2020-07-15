package com.pd.springboot.task;

import java.util.Date;

import javax.inject.Named;

import com.pd.businessobject.MapVO;
import com.pd.common.calobject.TimerCO;
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
		return timer;
	}
}
