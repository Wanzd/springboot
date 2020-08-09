package com.pd.businessobject;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class AppMyFollowBO extends BaseResourceBO {
	private String name;
	private String remark;
}
