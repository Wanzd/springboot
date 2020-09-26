package com.pd.common.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pd.standard.itf.SexEnum;

public class EnumXTest {

	@Test
	public void testGetLable() {
		assertEquals("男", EnumX.getEnum(SexEnum.class, "code", "1").getValue());
		assertEquals("女", EnumX.getEnum(SexEnum.class, "code", "0").getValue());
	}

}
