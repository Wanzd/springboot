require.config({
			urlArgs : "r=" + (new Date()).getTime(),
			paths : {
				jquery : "jquery.min",
				easyui : "jquery.easyui.min"
			},
			shim : {
				"easyui" : {
					deps : ["jquery"]
				}
			}
		});
require(['jquery', 'easyui', 'common', 'tree', 'db'], function(jquery, easyui,
		common, tree, db) {
	main = {
		init : function() {
			main.init$menu();
		},
		init$menu : function() {
			console.log("init$menu");
			$("#menu").tree({
				id : "id",
				parentField : "pid",
				url : "menuRest/root",
				onClick : main.tabMenu,
				formatter : function(node) {
					var s = node.cn;
					if (node.children) {
						s += ' <span style=\'color:blue\'>('
								+ node.children.length + ')</span>';
					}
					return s;
				},
				onSelect : function(node) {
					console.log('选中的树的节点信息');
					console.log(node);
				}
			});
		},
		tabMenu : function() {
			main.tabMenu$subNode();
			main.openModule();
		},
		tabMenu$subNode : function() {
			console.debug("main.tabMenu$subNode");
			var treeItem = tree.selected("menu");
			if (!treeItem) {
				return;
			}
			var subNode = $("#menu").tree("getNode", treeItem);
			if (subNode) {
				return;
			}
			$.ajax({
				type : "post",
				contentType : "application/json",
				url : "menuRest/queryList",
				data : JSON.stringify({
							pid : treeItem.id
						}),
				dataType : "json",
				success : function(data) {
					var selected = $('#menu').tree('getSelected');
					var children = selected.children;
					if (children != null && children.length > 0) {
						for (var i = 0, total = selected.children.length; i < total; i++) {
							var item = selected.children[total - i - 1];
							var node = $('#menu').tree('find', item.id);
							$("#menu").tree("remove", node.target);
						}
					}
					$("#menu").tree("append", {
								parent : selected.target,
								data : data
							});
				}
			});
		},
		tabMenu$refreshTab : function() {
			var treeItem = $("#menu").tree("getSelected");
			if (!treeItem) {
				return;
			}
			if (treeItem.url == null || treeItem.url == "") {
				return;
			}
			if (!$("#tt").tabs("exists", treeItem.cn)) {
				$('#tt').tabs('add', {
							title : treeItem.cn,
							href : treeItem.url,
							selected : true,
							closable : true
						});
			}
			$("#tt").tabs("select", treeItem.cn);
			setTimeout('$build("db.addEvent")', 500);
		},
		openModule : function() {
			console.debug("main.openModule");
			var treeItem = tree.selected("menu");
			if (!treeItem) {
				return;
			}
			if (treeItem.url == null || treeItem.url == "") {
				return;
			}
			$('#moduleFrame')[0].src = treeItem.url;
		}
	}
	main.init();
});