package com.pd.businessobject;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pd.standard.itf.IIdentity;

import lombok.Data;

@Data
public class LookupBO implements Serializable, IIdentity<String> {
	@TableId(type = IdType.INPUT)
	private String lookupType;
	private String lookupCode;
	private String lookupText;

	@Override
	public String getId() {
		return lookupType + ":" + lookupCode;
	}

}
