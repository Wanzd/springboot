package com.pd.businessobject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SysInfoVO extends SysInfoBO {
	private String source;

	public SysInfoVO(String source, String key, String value) {
		this.source = source;
		setKey(key);
		setValue(value);
	}
}
