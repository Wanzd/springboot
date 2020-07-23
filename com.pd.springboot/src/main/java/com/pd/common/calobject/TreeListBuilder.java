package com.pd.common.calobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pd.businessobject.MapVO;
import com.pd.standard.itf.IBuilder;

public class TreeListBuilder implements IBuilder<MapVO, List<MapVO>> {

	/**
	 * 对入参中的list按照pid和id的父子关系进行结构化处理
	 */
	@Override
	public List<MapVO> build(MapVO in) {
		// String pidStr = StringX.nvl(in.str("pid"), "pid");
		String pidStr = "pid";
		// String idStr = StringX.nvl(in.str("id"), "id");
		String idStr = "id";
		List<MapVO> list = in.list("list");
		System.out.println(list);

		List<MapVO> rsList = new ArrayList<MapVO>();
		Map<String, MapVO> idMap = list.stream().collect(Collectors.toMap(vo -> vo.str(idStr), vo -> vo));
		System.out.println(list);
		for (MapVO eachVO : list) {
			String curPid = eachVO.str(pidStr);
			if (curPid.length() == 0) {
				rsList.add(eachVO);
			} else {
				MapVO mapVO = idMap.get(curPid);
				if (mapVO == null) {
					continue;
				}
				List<MapVO> childrenList = mapVO.list("children");
				childrenList.add(eachVO);
			}
		}
		return rsList;
	}

}
