package com.pd.standard.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pd.base.exception.BusinessException;
import com.pd.businessobject.PageVO;
import com.pd.common.util.OperationBridge;
import com.pd.common.util.ReflectUtil;
import com.pd.standard.itf.IDeleteInfoOperation;
import com.pd.standard.itf.IExportOperation;
import com.pd.standard.itf.IUpdateInfoOperation;

public interface IStandardRest<FO, VO> {
    default Object getDefaultField() throws BusinessException {
        return ReflectUtil.firstExistField(this, "business,service,dao");
    }

    @RequestMapping("/queryInfo")
    default Object queryInfo(@RequestBody(required = false) FO fo) throws BusinessException {
        return OperationBridge.queryInfo(getDefaultField(), fo);
    }

    @RequestMapping("/queryDetailInfo")
    default Object queryDetailInfo(@RequestBody(required = false) FO fo) throws BusinessException {
        return OperationBridge.queryDetailInfo(getDefaultField(), fo);
    }

    @RequestMapping(value = "/queryList", method = { RequestMethod.POST, RequestMethod.GET })
    @ResponseBody
    default List queryList(@RequestBody(required = false) FO fo) throws BusinessException {
        return OperationBridge.queryList(getDefaultField(), fo);
    }

    @RequestMapping(value = "/queryPagedList/{pageSize}/{curPage}", method = { RequestMethod.POST })
    @ResponseBody
    default Object queryPagedList(@RequestParam(required = false) FO fo, @PathParam(value = "") PageVO page)
            throws BusinessException {
        return OperationBridge.queryPagedList(getDefaultField(), fo, page);
    }

    @RequestMapping("/updateInfo")
    default int updateInfo(@RequestBody(required = false) VO fo) throws BusinessException {
        IUpdateInfoOperation service = ReflectUtil.firstExistField(this, IUpdateInfoOperation.class,
                "business,service,dao");
        return service.updateInfo(fo);
    }

    @RequestMapping("/updateList")
    default int updateList(@RequestBody(required = false) List<VO> list) throws BusinessException {
        return OperationBridge.updateList(getDefaultField(), list);
    }

    @RequestMapping("/deleteList")
    default int deleteList(@RequestBody(required = false) List<VO> list) throws BusinessException {
        return OperationBridge.deleteList(getDefaultField(), list);
    }

    @RequestMapping("/deleteInfo")
    default int deleteInfo(@RequestBody(required = false) VO fo) throws BusinessException {
        IDeleteInfoOperation op = ReflectUtil.firstExistField(this, IDeleteInfoOperation.class, "business,service,dao");
        return op.deleteInfo(fo);
    }

    @RequestMapping(value = "/export", method = { RequestMethod.POST, RequestMethod.GET })
    default void export(@RequestBody(required = false) FO fo) throws BusinessException {
        Object field = ReflectUtil.firstExistField(this, "service");
        if (field instanceof IExportOperation) {
            IExportOperation op = (IExportOperation) field;
            op.export(fo);
        }
        return;
    }
}
