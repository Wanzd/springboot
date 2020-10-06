package com.pd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.base.exception.BusinessException;
import com.pd.businessobject.PageVO;
import com.pd.common.util.OperationBridge;

public class ServiceAdapter<FO, VO, Dao> extends ServiceImpl<BaseMapper<VO>, VO> {
    @Autowired
    protected Dao dao;

    public VO queryInfo(FO fo) throws BusinessException {
        return OperationBridge.queryInfo(dao, fo);
    }

    public String queryJson(FO fo) throws BusinessException {
        return OperationBridge.queryJson(dao, fo);
    }

    public VO queryDetailInfo(FO fo) throws BusinessException {
        return OperationBridge.queryDetailInfo(dao, fo);
    }

    public List<VO> queryList(FO fo) throws BusinessException {
        return OperationBridge.queryList(dao, fo);
    }

    public List<VO> queryPagedList(FO fo, PageVO page) throws BusinessException {
        return OperationBridge.queryPagedList(dao, fo, page);
    }

    public int queryCount(FO fo) throws BusinessException {
        return OperationBridge.queryCount(dao, fo);
    }

    public int insertList(List<VO> list) throws BusinessException {
        return OperationBridge.insertList(dao, list);
    }

    public int delete(VO vo) throws BusinessException {
        return OperationBridge.delete(dao, vo);
    }

    public int deleteInfo(VO vo) throws BusinessException {
        return OperationBridge.deleteInfo(dao, vo);
    }

    public int update(VO vo) throws BusinessException {
        return OperationBridge.update(dao, vo);
    }

    public int updateList(List<VO> list) throws BusinessException {
        return OperationBridge.updateList(dao, list);
    }

    public int deleteList(List<VO> list) {
        return OperationBridge.deleteList(dao, list);
    }

}
