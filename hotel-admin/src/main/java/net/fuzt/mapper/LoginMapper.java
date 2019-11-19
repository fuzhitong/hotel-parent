package net.fuzt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import net.fuzt.pojo.OneMenu;

public interface LoginMapper {

	@Select("select count(*) from system_user where username=#{0} and pwd=#{1} and use_status=1")
	int login(String username,String password);
//	根据用户id获取权限
	List<OneMenu> getAuthorityByUsername(String username);
	
	List<OneMenu> getSQAuthority();
	
	
}
