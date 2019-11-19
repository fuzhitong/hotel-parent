package net.fuzt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fuzt.pojo.OneMenu;
import net.fuzt.service.LoginService;
import net.fuzt.service.SystemUserService;

//系统用户管理
@Controller
public class SystemUserController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	SystemUserService systemUserService;
	
	//获取去授权信息
	@RequestMapping("toAddUser.do")
	public String toAddUser(Model model){
		List<OneMenu> sqAuthorityList = loginService.getSQAuthority();
		model.addAttribute("sqAuthorityList", sqAuthorityList);
		return "user/addSystemUser.jsp";
	}
	
	//获取ajax传过来的信息
	@RequestMapping("addSystemUser.do")
	public @ResponseBody Boolean addSystemUser(String username,String pwd,String oneIds,String twoIds) throws Exception{
		//System.out.println(username+","+pwd+","+oneIds+","+twoIds);
		return systemUserService.saveSystemUser(username, pwd, oneIds, twoIds);
	}
	
	@RequestMapping("/getSystemUserByLimit.do")
    public String getSystemUserByLimit(Model model,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<Map<String, Object>> systemUserList = systemUserService.findSystemUserByLimit(pageNum, pageSize);
        model.addAttribute("systemUserList", systemUserList);
        return "user/showSystemUser.jsp";
    }

	@RequestMapping("/updateSystemUserStatus.do")
	public String updateSystemUserStatus(Long userId,String flag) {
		boolean result = systemUserService.updateSystemUserStatus(userId, flag);
		return "redirect:/getSystemUserByLimit.do";
	}
}
