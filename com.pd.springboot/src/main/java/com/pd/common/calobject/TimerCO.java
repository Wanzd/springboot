package com.pd.common.calobject;

import java.util.Date;

import lombok.Data;

@Data
public class TimerCO {
	private Date start;
	private Date end;
	private String name;

	public TimerCO(String name) {
		this.name = name;
		this.start = new Date();
	}

	public void end() {
		end = new Date();
	}

	public String getUsedTime() {
		long useTime = end.getTime() - start.getTime();
		return String.format("%s end: use time %dms.", name, useTime);
	}
}
