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
    <li>客房管理</li>
    <li>客房类型管理</li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="<%=basePath %>/static/images/t01.png" /></span>添加</li>
      <li class="click"><span><img src="<%=basePath %>/static/images/t02.png" /></span>修改</li>
      <li><span><img src="<%=basePath %>/static/images/t03.png" /></span>删除</li>
    </ul>
    
    
    
  </div>
  <table class="tablelist">
    <thead>
      <tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号</th>
        <th>房间类型</th>
        <th>房间单价</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${roomTypeList }" var="map" varStatus="num">
	      <tr>
	        <td><input name="" type="checkbox" value="" /></td>
	        <td>${num.count }</td>
	        <td>${map.room_type_name }</td>
	        <td>${map.room_price }</td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
  <!-- <div class="pagin">
    <div class="message">共<i class="blue">1234</i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>
    <ul class="paginList">
      <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
      <li class="paginItem current"><a href="javascript:;">1</a></li>
      <li class="paginItem"><a href="javascript:;">2</a></li>
      <li class="paginItem"><a href="javascript:;">3</a></li>
      <li class="paginItem"><a href="javascript:;">4</a></li>
      <li class="paginItem"><a href="javascript:;">5</a></li>
      <li class="paginItem more"><a href="javascript:;">...</a></li>
      <li class="paginItem"><a href="javascript:;">10</a></li>
      <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
    </ul>
  </div> -->
  
  <div class="tip">
    <div class="tiptop"><span>提示信息</span><a></a></div>
    <div class="tipinfo"> <span><img src="<%=basePath %>/static/images/ticon.png" /></span>
      <!-- <div class="tipright">
        <form>
        	<table>
        		<tr>
        			<td>房间类型名：</td>
        			<td><input type="text" name="room_type_name" /></td>
        		</tr>
        		<tr>
        			<td>房间单间：</td>
        			<td><input type="text" name="room_price" /></td>
        		</tr>
        	</table>
        </form>
    </div> -->
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
