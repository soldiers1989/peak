$(function(){
    $('#table').bootstrapTable({
		// url: 'data1.json',   // 获取表格数据的url
		// cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
		// striped: true,  //表格显示条纹，默认为false
		pagination: true, // 在表格底部显示分页组件，默认false
		pageList: [5, 10], // 设置页面可以显示的数据条数
		pageSize: 5, // 页面数据条数
		pageNumber: 1, // 首页页码
		paginationPreText: '上一页',    //指定分页条中上一页按钮的图标或文字
		paginationNextText: '下一页',   //指定分页条中下一页按钮的图标或文字
		paginationHAlign: '',

		//sidePagination: 'server', // 设置为服务器端分页
		// queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求

		// 		return {
		// 				pageSize: params.limit, // 每页要显示的数据条数
		// 				offset: params.offset, // 每页显示数据的开始行号
		// 				sort: params.sort, // 要排序的字段
		// 				sortOrder: params.order, // 排序规则
		// 				dataId: $("#dataId").val() // 额外添加的参数
		// 		}
		// },
		// sortName: 'id', // 要排序的字段
		// sortOrder: 'desc', // 排序规则
		columns: [
			{
				field: 'id', // 返回json数据中的name
				title: 'Item ID', // 表格表头显示文字
				align: 'center', // 左右居中
				valign: 'middle' // 上下居中
			},
			{
				field: 'name', // 返回json数据中的name
				title: 'Item Name', // 表格表头显示文字
				align: 'center', // 左右居中
				valign: 'middle' // 上下居中
			},
			{
				field: 'price', // 返回json数据中的name
				title: 'Item Price', // 表格表头显示文字
				align: 'center', // 左右居中
				valign: 'middle' // 上下居中
			}
		],
		data: [
			{
				id: 1,
				name: 'Item 1',
				price: '$1'
			},
			{
				id: 2,
				name: 'Item 2',
				price: '$2'
			},
			{
				id: 3,
				name: 'Item 1',
				price: '$1'
			},
			{
				id: 4,
				name: 'Item 2',
				price: '$2'
			},
			{
				id: 5,
				name: 'Item 1',
				price: '$1'
			},
			{
				id: 6,
				name: 'Item 2',
				price: '$2'
			}
		],

		onLoadSuccess: function () {  //加载成功时执行
			console.info("加载成功");
		},
		onLoadError: function () {  //加载失败时执行
			console.info("加载数据失败");
		}
	});
});