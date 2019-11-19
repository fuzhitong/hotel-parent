package net.fuzt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SystemUserMapper {

	//添加系统用户，返回用户主键值
	int insertSystemUser(Map<String, Object> paramMap);
	
	//添加权限信息
	int insertAuthority(Long UserId,Long Authority);
	
	//查询用户
	@Select("SELECT * FROM SYSTEM_USER")
	List<Map<String, Object>> selectAllSystemUser();
	
	//修改状态
	@Update("UPDATE `system_user` SET use_status=#{1} WHERE id=#{0}")
	int updateSystemUserStatus(Long userId,String flag);
}
