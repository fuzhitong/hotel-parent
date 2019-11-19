package net.fuzt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fuzt.service.HouseService;

@Controller
public class HouseController {

	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/getHouseManage.do")
	public String getHouseManage(Model model) {
		List<Map<String, Object>> roomTypeList = houseService.findRoomType();
		model.addAttribute("roomTypeList", roomTypeList);
		return "room/showRoomType.jsp";
	}
	
	//ajax触发获取所有的房间类型
	@RequestMapping("/getAllRoomType.do")
    public @ResponseBody List<Map<String, Object>> getAllRoomType() {
        return houseService.findRoomType();
    }
	
	@RequestMapping("/getRoomInfo.do")
	public @ResponseBody List<Map<String, Object>> getRoomInfo() {
		return houseService.findRoomInfo();
	}
}
