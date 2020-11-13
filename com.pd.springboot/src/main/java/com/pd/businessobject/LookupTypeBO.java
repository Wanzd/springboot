package com.pd.businessobject;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pd.standard.itf.IIdentity;

import lombok.Data;

@Data
public class LookupTypeBO extends BaseBO implements IIdentity<String> {
    @TableId(type = IdType.INPUT)
    @NotNull
    private String id;
    @NotNull
    private String name;
    private String language;
}
