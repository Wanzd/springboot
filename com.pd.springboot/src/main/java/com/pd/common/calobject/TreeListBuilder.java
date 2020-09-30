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

	private Calculator cal = new Calculator();

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
				});
			}
		}
		for (MapVO eachVO : list) {
			String curPid = eachVO.str(pidStr);
			if (curPid.length() == 0 && eachVO.get("children") != null) {
				rsList.add(eachVO);
			}
		}
		for (MapVO eachVO : rsList) {
			init(eachVO);
		}
		return rsList;
	}

	public void init(MapVO vo) {

		cal.initChildrenCnt(vo);
		cal.initFulChildrenCnt(vo);
		cal.initLeafChildrenCnt(vo);
		cal.initValidLeafChildrenCnt(vo);
		cal.initSortChildren(vo);
	}

	public static class Calculator {
		public void initSortChildren(MapVO vo) {
			if (vo.get("children") == null) {
				vo.put("childrenCnt", 0);
				return;
			}
			List<MapVO> childrenList = vo.list("children");
			Collections.sort(childrenList, new Comparator<MapVO>() {
				@Override
				public int compare(MapVO o1, MapVO o2) {
					int rs = (int) o1.num("sortId") > (int) o2.num("sortId") ? 1 : -1;
					return rs;
				}
			});
			for (MapVO eachChild : childrenList) {
				initSortChildren(eachChild);
			}
		}

		public void initChildrenCnt(MapVO vo) {
			if (vo.get("children") == null) {
				vo.put("childrenCnt", 0);
				return;
			}
			List<MapVO> childrenList = vo.list("children");
			for (MapVO eachChild : childrenList) {
				initChildrenCnt(eachChild);
			}
			vo.put("childrenCnt", childrenList.size());
		}

		public void initFulChildrenCnt(MapVO vo) {
			if (vo.get("children") == null) {
				vo.put("fulChildrenCnt", 0);
				return;
			}
			List<MapVO> childrenList = vo.list("children");
			for (MapVO eachChild : childrenList) {
				initFulChildrenCnt(eachChild);
			}
			vo.put("fulChildrenCnt",
					childrenList.stream().mapToInt(eachChild -> (int) eachChild.num("fulChildrenCnt") + 1).sum());
		}

		public void initLeafChildrenCnt(MapVO vo) {
			if (vo.get("children") == null) {
				vo.put("leafChildrenCnt", 1);
				return;
			}
			List<MapVO> childrenList = vo.list("children");
			for (MapVO eachChild : childrenList) {
				initLeafChildrenCnt(eachChild);
			}
			vo.put("leafChildrenCnt",
					childrenList.stream().mapToInt(eachChild -> (int) eachChild.num("leafChildrenCnt")).sum());
		}

		public void initValidLeafChildrenCnt(MapVO vo) {
			if (vo.get("children") == null) {
				vo.put("validLeafChildrenCnt", isValidLeaf(vo) ? 1 : 0);
				return;
			}
			List<MapVO> childrenList = vo.list("children");
			for (MapVO eachChild : childrenList) {
				initValidLeafChildrenCnt(eachChild);
			}
			vo.put("validLeafChildrenCnt",
					childrenList.stream().mapToInt(eachChild -> (int) eachChild.num("validLeafChildrenCnt")).sum());
		}

		public boolean isValidLeaf(MapVO vo) {
			if (vo.str("sex").equals("男")) {
				return vo.num("age") > 0 && vo.num("age") < 32;
			}
			if (vo.str("sex").equals("女")) {
				return vo.num("age") > 0 && vo.num("age") < 30;
			}
			return true;
		}
	}
}
