package com.pd.common.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pd.base.exception.BusinessException;
import com.pd.businessobject.PageVO;
import com.pd.springboot.service.ServiceAdapter;
import com.pd.standard.itf.IDeleteListOperation;
import com.pd.standard.itf.IDeleteOperation;
import com.pd.standard.itf.IIdentity;
import com.pd.standard.itf.IInsertListOperation;
import com.pd.standard.itf.IQueryInfoOperation;
import com.pd.standard.itf.IQueryListOperation;
import com.pd.standard.itf.IQueryPagedListOperation;
import com.pd.standard.itf.IUpdateInfoOperation;
import com.pd.standard.itf.IUpdateListOperation;

public class OperationBridge {

    public static <FO, VO> VO queryInfo(Object field, FO fo) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return (VO) op.queryInfo(fo);
        }
        if (field instanceof BaseMapper) {
            BaseMapper op = (BaseMapper) field;
            String jsonStr = StringX.from(fo);
            return (VO) op.selectById(JSON.parseObject(jsonStr, HashMap.class));
        }
        if (field instanceof IQueryInfoOperation) {
            IQueryInfoOperation op = (IQueryInfoOperation) field;
            String jsonStr = StringX.from(fo);
            return (VO) op.queryInfo(fo);
        }
        return null;
    }

    public static <FO, VO> String queryJson(Object field, FO fo) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return op.queryJson(fo);
        }
        if (field instanceof IQueryInfoOperation) {
            IQueryInfoOperation op = (IQueryInfoOperation) field;
            String jsonStr = StringX.from(fo);
            return op.queryJson(fo);
        }
        return null;
    }

    public static <FO, VO> VO queryDetailInfo(Object field, FO fo) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return (VO) op.queryDetailInfo(fo);
        }
        if (field instanceof IQueryInfoOperation) {
            IQueryInfoOperation<FO, VO> op = (IQueryInfoOperation) field;
            return op.queryDetailInfo(fo);
        }
        return null;
    }

    public static <FO, VO> List<VO> queryList(Object field, FO fo) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return op.queryList(fo);
        }
        if (field instanceof IQueryListOperation) {
            IQueryListOperation op = (IQueryListOperation) field;
            return op.queryList(fo);
        }
        if (field instanceof BaseMapper) {
            BaseMapper op = (BaseMapper) field;
            return op.selectList(null);
        }
        return null;
    }

    public static <FO, VO> List<VO> queryPagedList(Object field, FO fo, PageVO page) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return op.queryPagedList(fo, page);
        }
        if (field instanceof IQueryPagedListOperation) {
            IQueryPagedListOperation op = (IQueryPagedListOperation) field;
            return op.queryPagedList(fo, page);
        }
        if (field instanceof BaseMapper) {
            BaseMapper op = (BaseMapper) field;
            return op.selectList(null);
        }
        return null;
    }

    public static <FO> int queryCount(Object field, FO fo) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return op.queryCount(fo);
        }
        if (field instanceof IQueryPagedListOperation) {
            IQueryPagedListOperation op = (IQueryPagedListOperation) field;
            return op.queryCount(fo);
        }
        if (field instanceof BaseMapper) {
            BaseMapper op = (BaseMapper) field;
            return op.selectCount(null);
        }
        return 0;
    }

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

    public static <VO> int delete(Object field, VO vo) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return op.delete(vo);
        }
        if (field instanceof IDeleteOperation) {
            IDeleteOperation op = (IDeleteOperation) field;
            return op.delete(vo);
        }
        return -1;
    }

    public static <VO> int deleteInfo(Object field, VO vo) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return op.deleteInfo(vo);
        }
        if (field instanceof BaseMapper) {
            BaseMapper op = (BaseMapper) field;
            return op.deleteById((Serializable) vo);
        }
        if (field instanceof IDeleteOperation) {
            IDeleteOperation op = (IDeleteOperation) field;
            return op.deleteById(vo);
        }
        return 0;
    }

    public static <VO> int update(Object field, VO vo) throws BusinessException {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return op.update(vo);
        }
        if (field instanceof BaseMapper) {
            BaseMapper op = (BaseMapper) field;
            return op.updateById(vo);
        }
        if (field instanceof IUpdateInfoOperation) {
            IUpdateInfoOperation op = (IUpdateInfoOperation) field;
            return op.updateInfo(vo);
        }
        return 0;
    }

    public static <VO> int updateList(Object field, List<VO> list) throws BusinessException {
        if (field instanceof ServiceImpl) {
            ServiceImpl<BaseMapper<VO>, VO> op = (ServiceImpl) field;
            op.saveOrUpdateBatch(list);
            return list.size();
        }
        if (field instanceof IUpdateListOperation) {
            IUpdateListOperation op = (IUpdateListOperation) field;
            return op.updateList(list);
        }
        return -1;
    }

    public static <VO> int deleteList(Object field, List<VO> list) {
        if (field instanceof ServiceAdapter) {
            ServiceAdapter op = (ServiceAdapter) field;
            return op.deleteList(list);
        }
        if (field instanceof IUpdateListOperation) {
            IDeleteListOperation op = (IDeleteListOperation) field;
            return op.deleteList(list);
        }
        if (field instanceof BaseMapper) {
            BaseMapper<VO> op = (BaseMapper<VO>) field;
            List<Serializable> idList = list.stream().map(vo -> {
                if (vo instanceof IIdentity) {
                    IIdentity<Serializable> identity = (IIdentity) vo;
                    return identity.getId();
                }
                return null;
            }).collect(Collectors.toList());
            return op.deleteBatchIds(idList);
        }
        return -1;
    }

}
