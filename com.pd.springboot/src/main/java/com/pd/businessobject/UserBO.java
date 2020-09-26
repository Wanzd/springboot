package com.pd.businessobject;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.pd.common.util.EnumX;
import com.pd.standard.itf.SexEnum;

import lombok.Data;

@Data
public class UserBO implements Serializable {
	@TableId(type = IdType.INPUT)
	private String id;
	private String name;
	private String fatherId;
	private String sex;
	@TableField(exist = false)
	private String sexLabel;

	public String getSexLabel() {
		String tmpSex = getSex();
		if (StringUtils.isEmpty(tmpSex)) {
			return null;
		}
		SexEnum sexEnum = EnumX.getEnum(SexEnum.class, "code", tmpSex);
		if (sexEnum == null) {
			return null;
		}
		return sexEnum.getValue();
	}
}
