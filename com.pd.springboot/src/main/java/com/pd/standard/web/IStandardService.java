package com.pd.standard.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.PageVO;
import com.pd.common.util.OperationBridge;
import com.pd.common.util.ExportUtil;
import com.pd.common.util.ReflectUtil;
import com.pd.standard.itf.IDeleteInfoOperation;
import com.pd.standard.itf.IExportConfigEnum;
import com.pd.standard.itf.IExportOperation;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IQueryListOperation;
import com.pd.standard.itf.IQueryPagedListOperation;
import com.pd.standard.itf.IUpdateInfoOperation;

public interface IStandardService<FO, VO> extends IQueryInfoOperation<FO, VO>, IQueryListOperation<FO, VO>,
        IQueryPagedListOperation<FO, VO>, IUpdateInfoOperation<VO>, IDeleteInfoOperation<VO>, IExportOperation<FO> {
    default Object getDefaultField() throws BusinessException {
        return ReflectUtil.firstExistField(this, "dao,service,business");
    }

    @Override
    default VO queryInfo(FO fo) throws BusinessException {
        return OperationBridge.queryInfo(getDefaultField(), fo);
    }

    @Override
    default VO queryDetailInfo(FO fo) throws BusinessException {
        return OperationBridge.queryDetailInfo(getDefaultField(), fo);
    }

    @Override
    default String queryJson(FO fo) throws BusinessException {
        return OperationBridge.queryJson(getDefaultField(), fo);
    }

    @Override
    default List<VO> queryList(FO fo) throws BusinessException {
        return OperationBridge.queryList(getDefaultField(), fo);
    }

    @Override
    default List<VO> queryPagedList(FO fo, PageVO page) throws BusinessException {
        return OperationBridge.queryPagedList(getDefaultField(), fo, page);
    }

    @Override
    default int queryCount(FO fo) throws BusinessException {
        return OperationBridge.queryCount(getDefaultField(), fo);
    }

    default int insertList(List<VO> list) throws BusinessException {
        return OperationBridge.insertList(getDefaultField(), list);
    }

    default int delete(VO vo) throws BusinessException {
        return OperationBridge.delete(getDefaultField(), vo);
    }

    @Override
    default int deleteInfo(VO vo) throws BusinessException {
        return OperationBridge.deleteInfo(getDefaultField(), vo);
    }

    @Override
    default int updateInfo(VO vo) throws BusinessException {
        return OperationBridge.update(getDefaultField(), vo);
    }

    @Override
    default void export(@RequestBody(required = false) FO fo) throws BusinessException {
        List<VO> data = queryList(fo);
        ExportUtil.export(data, getExportConfig());
    }

    @Override
    default <T extends IExportConfigEnum> Class<T> getExportConfig() {
        return null;
    }

}
