package net.fuzt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.fuzt.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login.do")
	public String login(String username,String pwd,HttpSession session) throws Exception{
		boolean flag = loginService.login(username,pwd,session);
		return flag? "index.jsp" : "login.jsp";
	}
}
