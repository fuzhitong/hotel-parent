<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>结账退房</title>
<link href="<%=basePath %>/static/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/static/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>/static/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/select-ui.min.js"></script>
<script type="text/javascript" src="../../editor/kindeditor.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/laydate/laydate.js"></script>
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
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li>客房管理</li>
    <li>添加客房</li>
  </ul>
</div>
<div class="formbody">
  <div class="formtitle"><span>添加客房</span></div>
<div id="usual1" class="usual">
  <div id="tab1" class="tabson">
    <ul class="forminfo">
   	  <li> 
       <label for="name" >房间号<b>*</b></label>
       <div class="vocation">
         <input name="room_num" type="text" class="dfinput" style="width:344px;"/>
       </div>
      </li><br/><br/><br/>
      <li>
        <label>房间类型<b>*</b></label>
        <div class="vocation"> 
          <select id="roomType" class="select1" name="roomType">
          	<option>--请选择房间类型--</option>
          </select>
        </div>
      </li><br/>
      <li id="rt">
        <label>房间单价<b>*</b></label>
        <div class="vocation"> 
        	 <input name="room_price" type="text" class="dfinput" style="width:344px;" readonly="readonly"/>
        </div>
      </li><br/>
      <li>
        <label>房间状态<b>*</b></label>
        <div class="vocation"> 
          <select class="select1" name="roomStatus">
            <option value="0">空闲</option>
            <option value="1">已入住</option>
            <option value="2">打扫</option>
          </select>
        </div>
      </li>
      <li>
		<label>&nbsp;</label>
		<input type="submit" class="btn" value="添加"/>
	  </li>
    </ul>
  </div>
</div>
<script type="text/javascript">
	jQuery(function(){
		//当鼠标进入到房间类型下拉框触发
		jQuery("#roomType").mouseenter(function(){
			jQuery.ajax({
				url:"<%=basePath %>/getAllRoomType.do",
				type:"POST",
				dataType:"json",
				success:function(rs){
					var content = "";
					for(var i in rs){
						content+="<option price='"+rs[i].room_price+"' value='"+rs[i].id+"'>"+rs[i].room_type_name+"</option>";
					}
					jQuery("#roomType").html(content);
				},
				error:function(){
					
				}
			});
		});
		//给房间类型下拉框添加change事件
		jQuery("#roomType").change(function(){
			var price = jQuery(this).find("option:selected").attr("price");
			jQuery("input[name=room_price]").val(price);
			jQuery("#rt").show('3000');
			//jQuery(".forminfo").append("<li><label>房间单价<b>*</b></label><div class='vocation'><input name='room_price' type='text' class='dfinput' style='width:344px;' readonly='readonly'/></div></li>");
		});
	});
</script>

<script type="text/javascript"> 
  
      $("#usual1 ul").idTabs(); 
    </script> 
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	
	!function(){
laydate.skin('qianhuang');
laydate({elem: '#Calendar'});
laydate.skin('qianhuang');
laydate({elem: '#Calendar2'});
}();
$(function dd(){
		var d=new Date(),str="";
		str+=(d.getFullYear()+"-");
		str+="0";
		str+=(d.getMonth()+1+"-");
		str+=d.getDate();
		$("#Calendar").attr("value",str);
		$("#Calendar2").attr("value",str);
	});

	</script>
</div>
</body>
</html>
