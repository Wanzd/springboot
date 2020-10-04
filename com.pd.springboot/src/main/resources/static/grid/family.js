var colSchema = "";
var columns = [{
			width : 80,
			field : 'ck',
			checkbox : true
		}, {
			field : 'id',
			title : 'Id',
			width : 100
		}, {
			field : 'name',
			title : '姓名',
			width : 100,
			formatter : function(value, row, index) {
				var colorMap = {
					1 : "blue",
					0 : "red"
				};
				var color = colorMap[row.sex];
				if (color == null) {
					color = "black"
				}
				return '<font color="' + color + '">' + value + '</font>';
			},
			editor : {
				type : 'text',
				options : {
					required : true
				}
			}
		}, {
			field : 'age',
			title : '年龄',
			width : 100
		}, {
			field : 'tel',
			title : '电话号码',
			width : 100,
			editor : 'text'
		}, {
			field : 'sex',
			title : '性别',
			width : 100,
			formatter : function(value, row, index) {
				return row.sexLabel;
			},
			editor : {
				type : 'combobox',
				options : {
					valueField : 'id',
					textField : 'text',
					url : '../comboRest/LOOKUP:sex',
					required : true
				}
			}
		}, {
			field : 'sortId',
			title : '家庭排行',
			width : 60,
			editor : 'numberbox'
		}, {
			field : 'fatherId',
			title : '父亲',
			width : 100,
			formatter : function(value, row, index) {
				return row.father ? row.father.name : null;
			},
			editor : {
				type : 'combobox',
				options : {
					valueField : 'id',
					textField : 'text',
					url : '../comboRest/USER:',
					required : false
				}
			}
		}, {
			field : 'motherId',
			title : '母亲',
			width : 100,
			formatter : function(value, row, index) {
				return row.mother ? row.mother.name : null;
			},
			editor : {
				type : 'combobox',
				options : {
					valueField : 'id',
					textField : 'text',
					url : '../comboRest/USER:',
					required : false
				}
			}
		}, {
			field : 'mateId',
			title : '配偶',
			width : 100,
			formatter : function(value, row, index) {
				return row.mate ? row.mate.name : null;
			},
			editor : {
				type : 'combobox',
				options : {
					valueField : 'id',
					textField : 'text',
					url : '../comboRest/USER:',
					required : false
				}
			}
		}];
var $pageAtom = {
	init : function() {
		$('#dg').datagrid($pageCfg.datagrid.cfg)
	},
	action : {
		search : function() {
			$('#tt').datagrid('load', {
						itemid : $('#itemid').val(),
						productid : $('#productid').val()
					});
		},
		update : function(index) {
			$('#dg').datagrid('updateRow', {
						index : index,
						row : {}
					});
		}
	}
};
var $pageCfg = {
	datagrid : {
		cfg : { // 定位到Table标签，Table标签的ID是grid
			border : 1,
			title : "DataSet",
			width : '100%',
			height : '100%',
			singleSelect : false,
			url : "../userRest/queryPagedList/1000/1", // 指向后台的Action来获取当前菜单的信息的Json格式的数据
			iconCls : 'icon-edit',
			nowrap : true,
			autoRowHeight : true,
			striped : true,
			collapsible : true,
			pagination : true,
			pageSize : 20,
			pageList : [50, 100, 200],
			rownumbers : false,
			fit : true,
			// sortName: 'ID', //根据某个字段给easyUI排序
			sortOrder : 'asc',
			remoteSort : false,
			idField : 'id',
			// queryParams : queryData, // 异步查询的参数
			columns : [columns],

			onBeforeEdit : function(index, row) {
				row.editing = true;
				$pageAtom.action.update(index);
			},
			onAfterEdit : function(index, row) {
				row.editing = false;
				$pageAtom.action.update(index);
			},
			onCancelEdit : function(index, row) {
				row.editing = false;
				$pageAtom.action.update(index);
			},
			toolbar : [{
				id : 'btnAdd',
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					$('#dg').datagrid('appendRow', {});
					editIndex = $('#dg').datagrid('getRows').length - 1;
					$('#dg').datagrid('selectRow', editIndex).datagrid(
							'beginEdit', editIndex);
				}
			}, '-', {
				id : 'btnSave',
				text : '修改',
				iconCls : 'icon-save',
				handler : function() {
					$('#dg').datagrid('endEdit', editIndex);
					var url = "../userRest/updateList";
					var data = $("#dg").datagrid("getChanges");
					var rs = common.ajax(url, data);
					if (rs) {
						$("#dg").datagrid("reload");
						$('#dg').datagrid('uncheckAll');
					} else {
						alert("保存失败");
					}

				}
			}, '-', {
				id : 'btnDelete',
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					$.messager.confirm('Confirm',
							'Are you sure you want to delete record?',
							function(r) {
								if (r) {
									var url = "../userRest/deleteList";
									var data = $("#dg")
											.datagrid("getSelections");
									var rs = common.ajax(url, data);
									if (rs) {
										$("#dg").datagrid("reload");
										$('#dg').datagrid('uncheckAll');
									} else {
										alert("删除失败");
									}
								}
							});

				}
			}, '-', {
				id : 'btnExport',
				text : '导出',
				iconCls : 'icon-reload',
				handler : function() {
					window.location.href = "../userRest/export";
				}
			}, '-', {
				id : 'btnReload',
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					// 实现刷新栏目中的数据
					var id = curParams.module.cap();
					var param = $("#form" + id, parent.document)
							.serializeJson();
					$("#dg").datagrid("load", param);
					$('#dg').datagrid('uncheckAll');
				}
			}],
			onClickRow : function(rowIndex, rowData) {
				$('#dg').datagrid('uncheckAll');
				$('#dg').datagrid('checkRow', rowIndex);
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = rowIndex;
				$("#dg").datagrid("beginEdit", rowIndex); // 这句如果注释掉下一行的ed就获取不到值
				// $build("db.u$open");
			}
		}
	}
};
$('#dg').datagrid($pageCfg.datagrid.cfg)