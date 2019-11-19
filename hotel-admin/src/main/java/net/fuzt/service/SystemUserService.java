package net.fuzt.service;

import java.util.List;
import java.util.Map;

public interface SystemUserService {

	Boolean saveSystemUser(String username,String pwd,String oneIds,String twoIds) throws Exception;
	
	List<Map<String, Object>> findSystemUserByLimit(Integer pageNum,Integer pageSize);
	
	boolean updateSystemUserStatus(Long userId,String flag);
}
