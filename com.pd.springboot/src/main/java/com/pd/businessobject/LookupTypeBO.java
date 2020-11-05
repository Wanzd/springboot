package com.pd.businessobject;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pd.standard.itf.IIdentity;
import com.pd.valid.annotations.MailValid;

import lombok.Data;

@Data
public class LookupTypeBO extends BaseBO implements IIdentity<String> {
    @TableId(type = IdType.INPUT)
    @MailValid
    private String id;
    private String name;
    private String language;
}
