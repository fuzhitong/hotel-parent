package net.fuzt.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.fuzt.mapper.LoginMapper;
import net.fuzt.pojo.OneMenu;
import net.fuzt.service.LoginService;
import net.fuzt.utils.MD5Tool;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	/* (non-Javadoc)
	 * @see net.fuzt.service.impl.LoginService#login(java.lang.String, java.lang.String, org.springframework.ui.Model, javax.servlet.http.HttpSession)
	 */
	@Override
	@Transactional(readOnly = false)
	public boolean login(String username,String pwd, HttpSession session) throws Exception{
		//对明文密码加密后调用mapper层
		pwd = MD5Tool.md5(pwd);
		int flag = loginMapper.login(username, pwd);
		if(flag >= 1){
			List<OneMenu> OneMenuList = loginMapper.getAuthorityByUsername(username);
			session.setAttribute("OneMenuList",OneMenuList);
			session.setAttribute("username", username);
			//System.out.println(OneMenuList.toString());
			return true;
		}
		return false;
	}

	@Override
	public List<OneMenu> getSQAuthority() {
		
		return loginMapper.getSQAuthority();
	}
}
