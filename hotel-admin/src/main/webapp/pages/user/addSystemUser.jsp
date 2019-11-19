<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>结账退房</title>
<base href="<%=basePath %>">
<link href="<%=basePath %>/static/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath %>/static/css/select.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<%=basePath %>/static/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath %>/static/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>/static/js/select-ui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>/static/editor/kindeditor.js"></script>
<script type="text/javascript"
	src="<%=basePath %>/static/js/laydate/laydate.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
<script type="text/javascript">



$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
	
	
	
});


</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>首页</li>
			<li>系统用户管理</li>
			<li>用户添加</li>
		</ul>
	</div>
	<div class="formbody">
		<div class="formtitle">
			<span>系统用户信息</span>
		</div>
		<div id="usual1" class="usual">
			<div id="tab1" class="tabson">
				<ul class="forminfo">
					<li style="margin-top: 20px;"><label for="name">系统账号<b>*</b></label>
						<div class="vocation" style="margin-bottom:15px">
							<input name="username" type="text" class="dfinput" value=""
								style="width: 344px;" />
						</div></li>
					<br/>
					<br/>
					<li><label for="price" style="cursor: pointer">密码<b>*</b></label>
						<div class="vocation" style="margin-bottom:15px">
							<input name="pwd" id="price" type="text" class="dfinput" value=""
								style="width: 344px;" />
						</div></li>
					<br />
					<li>
					<label for="yajin" style="cursor: pointer">权限<b>*</b></label>
						<div class="vocation" style="margin-bottom:15px">
							<table boder="1px" width="800px">
								<c:forEach items="${sqAuthorityList }" var="oneMenu">
									<tr style="margin:5px">
										<!-- 一级 -->
										<td>${oneMenu.oneName }</td>
										<!-- 二级 -->
										<td>
											<c:forEach items="${oneMenu.twoMenuList }"
												var="twoMenu">
												<input oneId="${oneMenu.oneId }" type="checkbox"
													name="twoId" value="${twoMenu.twoId }">${twoMenu.twoName }
											</c:forEach>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						</li>
						<li>
					        <label>&nbsp;</label>
					        <input type="submit" class="btn" value="添加"/>
					    </li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	jQuery(function(){
		jQuery(".btn").click(function(){
			/* 防止重复提交 */
			$(this).attr("disabled","disabled");
			$(this).css({
				"background":'#ccc'
			});
			var $cks = jQuery(".vocation input[type=checkbox]:checked");
			//定义一个变量记录一级菜单
			//定义一个变量记录所有二级
			var oneIds = "";
			var twoIds = "";
			$cks.each(function(index,dom){
				var $c = jQuery(dom);
				oneIds+=$c.attr("oneId")+",";
				twoIds+=$c.val()+",";
			});
			//提交数据
			jQuery.ajax({
				/* 触发控制器和传值过去 */
				url:"<%=basePath %>/addSystemUser.do",
				type:"post",
				dataType:"json",
				data:{
					"username":jQuery("input[name=username]").val(),
					"pwd":jQuery("input[name=pwd]").val(),
					"oneIds":oneIds,
					"twoIds":twoIds
				},
				success:function(rs){
					if(rs){//添加成功
						 window.location.href="<%=basePath %>/getSystemUserByLimit.do";
					}
				},
				error:function(){
					window.location.href="<%=basePath %>/pages/error/error.jsp";
				}
			});
		});
	});
</script>
</html>
