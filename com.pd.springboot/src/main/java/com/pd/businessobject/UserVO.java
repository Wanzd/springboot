package com.pd.businessobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@TableName("user_t")
@JsonInclude(Include.NON_NULL)
public class UserVO extends UserBO {
	
	@TableField(exist = false)
	private UserVO father;
	@TableField(exist = false)
	private UserVO mother;
	@TableField(exist = false)
	private UserExtendBO extend;

}
