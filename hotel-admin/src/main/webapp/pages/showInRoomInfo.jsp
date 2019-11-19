<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入住信息查询</title>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<script src="https://cdn.jsdelivr.net/npm/vue-resource@1.5.1"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<div id="cacheIcon" style="opacity:0.6;display:none;position:relative;left:600px;top:100px;z-index:9999"><img src="<%=basePath %>/static/images/big-circle.gif"/></div>
	<button @click="batDel">批量删除</button>
	<table style="position:relative;z-index:-1" class="tablelist" id="tb" border="1px" width="1000px">
		<thead>
			<tr>
				<th><input name="" type="checkbox" value="" checked="checked" /></th>
				<th>编号</th>
				<th>房间号</th>
				<th>房间类型</th>
				<th>客人姓名</th>
				<th>是否是vip</th>
				<th>折扣率</th>
				<th>性别</th>
				<th>身份证号码</th>
				<th>手机号码</th>
				<th>押金</th>
				<th>入住时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<tr v-for="(map,index) in roomList">
				<td>
					<input type="checkbox" value="" v-model="ids" />
				</td>
				<td>{{index+1}}</td>
				<td>{{map.room_num }}</td>
				<td>{{map.room_type_name }}</td>
				<td>{{map.customer_name }}</td>
				<td>{{map.is_vip=='1'?'是':'否' }}</td>
				<td>{{map.is_vip=='1'?map.vip_rate:'无折扣' }}</td>
				<td>{{map.gender=='1'?'男':'女' }}</td>
				<td>{{map.idcard }}</td>
				<td>{{map.phone }}</td>
				<td>{{map.money }}</td>
				<td>{{fmtDate }}</td>
				<td>操作</td>
			</tr>
	</table>
	
	<script type="text/javascript">
	 	const vue1 = new Vue({
	 		el:"#tb",
	 		data:{
	 			roomList:[],
	 			ids:[]
	 		},
	 		methods:{
	 			batchDel(){
	 				var idStr = ids.join(",");
	 				this.$http.post();
	 			}
	 		}
	 		computed:{
	 			fmtDate(){
	 				
	 				var date = new Date(1540224000000);
	 				var year = date.getFullYear();
	 				return year+"年";
	 			}
	 		},
	 		beforeCreate(){
	 			jQuery("#cacheIcon").show();
	 		},
	 		mounted(){
	 			//this.$http.post('请求路径',['JSON数据'],['格式类型']).then(成功函数,失败函数);
	 			this.$http.post('<%=basePath %>/getInRoomInfoByVue.do').then(
	 					function(rs){
	 						console.log(rs);
	 						this.roomList=rs.body;
	 					},
	 					function(err){
	 						console.log("请求失败了...");
	 					}
	 			);
	 		},
	 		updated(){
	 			jQuery("#cacheIcon").hide();
	 		}
	 	});
	</script>
</body>
</html>