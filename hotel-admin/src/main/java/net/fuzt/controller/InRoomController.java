package net.fuzt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import net.fuzt.pojo.InRoomInfo;
import net.fuzt.service.InRoomService;
import net.fuzt.utils.DateTool;

@Controller
public class InRoomController {

	@Autowired
	InRoomService inRoomService;
	
	@RequestMapping("getInRoomInfo.do")
	public String getInRoomInfo(Model model,
				@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
	            @RequestParam(value = "pageSize", required = false, defaultValue = "8") Integer pageSize, 	
				@RequestParam(value = "customerName", required = false) String customerName,
	            @RequestParam(value = "roomNum", required = false) String roomNum,
	            @RequestParam(value = "phone", required = false) String phone) {
	        Map<String, Object> paramMap = new HashMap<String, Object>();
	        paramMap.put("customerName", customerName);
	        paramMap.put("roomNum", roomNum);
	        paramMap.put("phone", phone);
	        List<Map<String, Object>> inRoomList = inRoomService.findInRoomInfo(paramMap,pageNum,pageSize);
	        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(inRoomList);
	        model.addAttribute("pageInfo", pageInfo);
	        return "bill/inroominfo.jsp";
		
	}
	
	//获取空闲房间
	@RequestMapping("/getKXRoom.do")
    public @ResponseBody List<Map<String, Object>> getKXRoom() {
        List<Map<String, Object>> roomList = inRoomService.findKXRoom();
        return roomList;
    }
	
	//添加入住信息
	@RequestMapping("addInRoomINfo.do")
	public @ResponseBody Boolean addInRoomINfo(InRoomInfo inRoomInfo) throws Exception{
		Thread.sleep(1000);
		//System.out.println(inRoomInfo);
		return inRoomService.saveInRoomInfo(inRoomInfo);
	}
	
	//根据房间状态获取房间信息
    @RequestMapping("/getRoomsByStatus.do")
    public @ResponseBody List<Map<String, Object>> getRoomsByStatus(
            @RequestParam(value = "status", defaultValue = "1") String status) {
        return inRoomService.findRoomsByStatus(status);
    }

    //根据房间id查看用户的入住信息
    @RequestMapping("/findOutRoomInfoByRoomId.do")
    public @ResponseBody Map<String, Object> findOutRoomInfoByRoomId(Long roomId) throws Exception {
        Map<String, Object> resultMap = inRoomService.findOutRoomInfoByRoomId(roomId);
        // 知道入住天数
        String inTime = (String) resultMap.get("create_date");
        long days = DateTool.diffDays(inTime, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        resultMap.put("days", days);
        // 计算消费金额
        Float cost = 0F;
        String isVip = (String) resultMap.get("is_vip");
        Float roomPrice = (Float) resultMap.get("room_price");
        Float orderMoney = 0F;
        if (resultMap.get("orderMoney") != null) {
            orderMoney = Float.parseFloat(resultMap.get("orderMoney") + "");
        }
        if ("0".equals(isVip)) {// 非vip用户
            cost = roomPrice * days + orderMoney;
        } else {
            Float rate = (Float) resultMap.get("vip_rate");
            cost = roomPrice * days * rate + orderMoney;
        }
        resultMap.put("cost", cost);
        return resultMap;
    }
	
    //最终结账退房
    @RequestMapping("/outRoom.do")
    public @ResponseBody boolean outRoom(Long roomId, Long iriId, Float qita) throws Exception {
        return inRoomService.outRoom(roomId, iriId, qita);
    }

    //查询消费记录
    @RequestMapping("/findCost.do")
    public @ResponseBody List<Map<String, Object>> findCost(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "idcard", required = false) String idcard,
            @RequestParam(value = "phone", required = false) String phone) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("customerName", customerName);
        paramMap.put("idcard", idcard);
        paramMap.put("phone", phone);
        return inRoomService.findCost(paramMap, pageNum, pageSize);
    }
    
}
