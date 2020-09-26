package com.pd.businessobject;

import lombok.Data;

@Data
public class UserVO extends UserBO {
	private UserVO father;
	private UserVO mother;
	private UserExtendBO extend;
}
