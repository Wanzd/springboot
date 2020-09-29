package com.pd.common.calobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		List<MapVO> rsList = new ArrayList<MapVO>();
		Map<String, MapVO> idMap = new HashMap<>();
		list.stream().forEach(vo -> idMap.put(vo.str(pidStr) + "|" + vo.str(idStr), vo));
		System.out.println(list);
		for (String eachKey : idMap.keySet()) {
			MapVO eachVO = idMap.get(eachKey);
			String curPid = eachVO.str(pidStr);
			if (curPid.length() > 0) {
				list.stream().filter(vo -> vo.str(idStr).equals(curPid)).forEach(vo -> {
					List<MapVO> childrenList = vo.list("children");
					childrenList.add(eachVO);
					Collections.sort(childrenList, new Comparator<MapVO>() {
						@Override
						public int compare(MapVO o1, MapVO o2) {
							return o1.num("sortId") > o2.num("sortId") ? 1 : -1;
						}
					});
				});
			}
		}
		for (MapVO eachVO : list) {
			String curPid = eachVO.str(pidStr);
			if (curPid.length() == 0&&eachVO.get("children")!=null) {
				rsList.add(eachVO);
			}
		}
		return rsList;
	}

}
