package com.pd.businessobject;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@TableName("lookup_t")
@JsonInclude(Include.NON_NULL)
public class LookupVO extends LookupBO {
}
