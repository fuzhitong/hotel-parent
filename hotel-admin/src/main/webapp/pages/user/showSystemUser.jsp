<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<base href="<%=basePath %>">
<link href="<%=basePath %>/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/static/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>

<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li>系统用户管理</li>
    <li>用户信息查询</li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="<%=basePath %>/static/images/t01.png" /></span>添加</li>
      <li class="click"><span><img src="<%=basePath %>/static/images/t02.png" /></span>修改</li>
      <li><span><img src="<%=basePath %>/static/images/t03.png" /></span>删除</li>
    </ul>
    
    <div class="toolbar1">
      <table>
        <form method="get" name="serch">
          <tr>
            <td class="zi"><span>选择分类：</span></td>
            <td><select>
                <option>用户名</option>
              </select></td>
            <td class="zi"><span>关键字：</span></td>
            <td><input type="text" placeholder="与分类关联"/></td>
            <td><input type="submit" value="查询" class="button"/></td>
          </tr>
        </form>
      </table>
    </div>
    
  </div>
  <table class="tablelist">
    <thead>
      <tr>
        <th>
        <input name="" type="checkbox" value="" checked="checked"/>
        </th>
        <th>编号</th>
        <th>用户名</th>
        <th>创建时间</th>
        <th>状态</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
		<c:forEach items="${systemUserList }" var="map" varStatus="num">
		      <tr>
		        <td><input name="" type="checkbox" value="" /></td>
		        <td>${num.count }</td>
		        <td>${map.username }</td>
		        <td>${map.create_date }</td>
		        <td>${map.use_status=='1'?'启动':'禁用' }</td>
		        <td>
		        	<c:choose>
		        		<c:when test="${map.is_admin==1 }"><a href="javascript:void(0)" class="tablelink">无操作</a> </c:when>
		        		<c:otherwise>
		        			<a href="<%=basePath %>/updateSystemUserStatus.do?userId=${map.id}&flag=${map.use_status=='1'?'0':'1' }" class="tablelink"> 
		        			${map.use_status=='1'?'禁用':'启用' } 
		        			</a>
		        		</c:otherwise>
		        	</c:choose>
		        	
		        </td>
		      </tr>
		
		</c:forEach>    

    </tbody>
  </table>
  
  <div class="tip">
    <div class="tiptop"><span>提示信息</span><a></a></div>
    <div class="tipinfo"> <span><img src="<%=basePath %>/static/images/ticon.png" /></span>
      <div class="tipright">
        <p>客官别着急，这个页面还没做好呢！！！</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite> </div>
      </div>
    <div class="tipbtn">
      <input name="" type="button"  class="sure" value="确定" />
      &nbsp;
      <input name="" type="button"  class="cancel" value="取消" />
    </div>
  </div>
</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
