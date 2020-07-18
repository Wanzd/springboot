package com.pd.standard.itf;

import com.pd.businessobject.MapVO;

public interface IBuilder<IN, OUT> {
	OUT build(IN in);

	default void init(MapVO rs) {
	};
}
