var treeGridImpl = {
	sick : {
		style : function(value, vo, index) {
			var color = vo.sick > vo.sick1 ? "red" : (vo.sick == vo.sick1
					? "black"
					: "green");
			var percent = 0;
			if (vo.sick > 0 && vo.sick1 == 0) {
				percent = 1;
			} else if (vo.sick == 0 && vo.sick1 != 0) {
				percent = -1;
			} else if (vo.sick == 0 && vo.sick1 != 0) {
				percent = 0;
			} else {
				percent = (vo.sick - vo.sick1) / vo.sick1;
			}
			if (percent > 1) {
				percent = 1;
			}
			if (percent == 0) {
				color = "#FFFFFF";
			} else if (percent >= 0) {
				var colorG = Number((255 * (1 - percent)).toFixed())
						.toString(16);
				if (colorG == "0") {
					colorG = "00";
				}
				color = "#FF" + colorG + colorG;
			} else {
				var colorR = Number((255 * (percent + 1)).toFixed())
						.toString(16);
				if (colorR == "0") {
					colorR = "00";
				}
				color = "#" + colorR + 'FF' + colorR;
			}
			return 'background-color:' + color + ';color:black;'
		}
	},
	cnt : {
		style : function(value, vo, index) {
			var percent = 0;
			if (vo.cnt > 0 && vo.cnt1 == 0) {
				percent = 1;
			} else {
				percent = (vo.cnt - vo.cnt1) / vo.cnt1;
			}
			if (percent > 1) {
				percent = 1;
			}
			if (percent == 0) {
				color = "#FFFFFF";
			} else if (percent >= 0) {
				var colorG = Number((255 * (1 - percent)).toFixed())
						.toString(16);
				if (colorG == "0") {
					colorG = "00";
				}
				color = "#FF" + colorG + colorG;
			}
			return 'background-color:' + color + ';color:black;'
		}
	},
	heal : {
		style : function(value, vo, index) {
			var percent = 0;
			if (vo.heal > 0 && vo.heal1 == 0) {
				percent = 1;
			} else {
				percent = (vo.heal - vo.heal1) / vo.heal1;
			}
			if (percent > 1) {
				percent = 1;
			}
			if (percent >= 0) {
				var colorG = Number((255 * (1 - percent)).toFixed())
						.toString(16);
				if (colorG == "0") {
					colorG = "00";
				}
				color = "#" + colorG + "FF" + colorG;
			}
			return 'background-color:' + color + ';color:black;'
		}
	},
	healIncr : {
		formatter : function(value, vo) {
			if (vo.heal == 0) {
				return '0.0%';
			}
			if (vo.heal1 == 0) {
				return '100.0%';
			}
			var percent = Number((vo.heal - vo.heal1) / vo.heal1 * 100)
					.toFixed(1)
					+ "%";
			return percent;
		}
	},
	death : {
		style : function(value, vo, index) {
			var color = vo.death > vo.death1 ? "red" : (vo.death == vo.death1
					? "black"
					: "green");
			if (vo.death == 0) {
				return '-100.0%';
			}
			var percent = 0;
			if (vo.death != 0 && vo.death1 == 0) {
				percent = 1;
			} else if (vo.death == 0) {
				percent = 1;
			} else {
				percent = (vo.death - vo.death1) / vo.death1;
			}
			if (percent > 1) {
				percent = 1;
			}
			var colorG = Number((255 * (1 - percent)).toFixed()).toString(16);
			if (colorG == "0") {
				colorG = "00";
			}
			color = '#FF' + colorG + colorG;
			return 'background-color:' + color + ';color:black;'
		}
	},
	deathIncr : {
		formatter : function(value, vo) {
			if (vo.death == 0) {
				return '0.0%';
			}
			if (vo.death1 == 0) {
				return '100.0%';
			}
			var percent = Number((vo.death - vo.death1) / vo.death1 * 100)
					.toFixed(1)
					+ "%";
			return percent;
		}
	}
}
var treeGridCols = [[{
			title : '姓名',
			field : 'text',
			width : 200,
			rowspan : 1
		}, {
			title : '性别',
			field : 'sex',
			width : 60,
			rowspan : 1
		}, {
			title : '年龄',
			field : 'age',
			width : 60,
			align : 'right',
			rowspan : 1
		}, {
			title : '生日',
			field : 'birthday',
			width : 180,
			align : 'left',
			rowspan : 1
		}, {
			title : '电话号码',
			field : 'tel',
			width : 180,
			align : 'left',
			rowspan : 1
		}]];