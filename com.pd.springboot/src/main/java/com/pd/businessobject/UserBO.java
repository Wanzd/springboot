package com.pd.businessobject;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.pd.common.util.EnumX;
import com.pd.standard.itf.IIdentity;
import com.pd.standard.itf.SexEnum;

import lombok.Data;

@Data
public class UserBO implements Serializable, IIdentity<Long> {
	@TableId(type = IdType.INPUT)
	private Long id;
	private String name;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birthday;

	private String fatherId;
	private String sex;
	
}
