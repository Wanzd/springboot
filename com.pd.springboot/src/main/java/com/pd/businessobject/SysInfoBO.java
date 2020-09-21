package com.pd.businessobject;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("sys_info_t")
public class SysInfoBO {
	private String key;
	private String value;
}
