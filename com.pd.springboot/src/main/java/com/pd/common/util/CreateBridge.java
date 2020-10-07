package com.pd.common.util;

import java.util.List;

import com.pd.base.exception.BusinessException;
import com.pd.springboot.service.ServiceAdapter;
import com.pd.standard.itf.IInsertListOperation;

public class CreateBridge {

    public static <VO> int insertList(Object field, List<VO> list) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return op.insertList(list);
        }
        if (field instanceof IInsertListOperation) {
            IInsertListOperation op = (IInsertListOperation) field;
            return op.insertList(list);
        }
        return 0;
    }

}
