require.config({
	urlArgs : "r=" + (new Date()).getTime(),
	paths : {
		jquery : "jquery.min",
		easyui : "jquery.easyui.min",
		echarts : "echarts.min"
	},
	shim : {
		"easyui" : {
			deps : [ "jquery" ]
		}
	}
});

require(
		[ 'jquery', 'easyui', 'common', 'tree', 'db', 'echarts' ],
		function(jquery, easyui, common, tree, db, ec) {

			test1 = function() {
				debugger;
				var resultJson = [ {
					x : 11,
					y : 11
				}, {
					x : 11,
					y : 22
				}, {
					x : 22,
					y : 22
				} ];
				if (resultJson != "") {
					// 添加需要实现热力分布的图片
					$('#graphic')
							.html(
									"<img id='baidu-img' src='./images/10086mall.png'><div id='main' style='width:1130px;height:2500px;'></div>");
					var heatData = new Array();// 定义数组存取后台数据
					// 封装成所需要的数据 x：距右边距的像素，y：距上边距的像素，h：热度
					for (var i = 0; i < resultJson.length; i++) {
						heatData[i] = [ resultJson[i].x, resultJson[i].y,
								resultJson[i].h ];
					}
					var myChart = ec.init(document.getElementById('main'));
					var option = {
						title : {
							text : '热力图自定义样式'
						},
						series : [ {
							type : 'heatmap',
							data : heatData,
							hoverable : false,
							gradientColors : [ {
								offset : 0.4,
								color : 'green'
							}, {
								offset : 0.5,
								color : 'yellow'
							}, {
								offset : 0.8,
								color : 'orange'
							}, {
								offset : 1,
								color : 'red'
							} ],
							minAlpha : 0.2,
							valueScale : 2,
							opacity : 0.6
						} ]
					};

					// 为echarts对象加载数据
					myChart.setOption(option);
				}

			};
			test1();

		});