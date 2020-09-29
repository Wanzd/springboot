var treeGridImpl = {
	text : {
		formater : function(value, vo, index) {
			var colorMap = {
				'男' : "blue",
				1 : "blue",
				'女' : "red",
				0 : "red"
			};
			var color = colorMap[vo.sex];
			if (color == null) {
				color = "black";
			}
			if (vo.mate != null) {
				value = value + "(" + vo.mate.name + ")";
			}
			return '<font color="' + color + '">' + value + '</font>';
		}
	}
}
var treeGridCols = [[{
			title : '姓名',
			field : 'text',
			width : 200,
			rowspan : 1,
			formatter : treeGridImpl.text.formater
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