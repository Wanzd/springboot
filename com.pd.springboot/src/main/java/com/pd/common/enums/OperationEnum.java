package com.pd.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperationEnum {
	QUERY_INFO("queryInfo"), QUERY_LIST("queryList");
	private String code;
}
