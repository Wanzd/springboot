package com.pd.businessobject;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysMenuBO implements Serializable{
	private String pid;
	private String id;
	private String cn;
	private String en;
	private String url;
	private String detail;
}
