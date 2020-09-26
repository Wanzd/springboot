package com.pd.businessobject;

import org.apache.commons.lang.enums.Enum;
import org.apache.commons.lang.enums.EnumUtils;

import com.pd.standard.itf.SexEnum;

import lombok.Data;

@Data
public class UserVO extends UserBO {
	private UserVO father;
	private UserVO mother;
	private UserExtendBO extend;
	private String sexLable;

	public String getSexLabel() {
		Enum sexEnum = EnumUtils.getEnum(SexEnum.class, this.getSex());
		if (sexEnum == null) {
			return null;
		}
		return sexEnum.getName();
	}

}
