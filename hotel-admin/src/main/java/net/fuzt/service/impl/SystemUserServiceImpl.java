package net.fuzt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.fuzt.mapper.SystemUserMapper;
import net.fuzt.service.SystemUserService;
import net.fuzt.utils.MD5Tool;

@Service
public class SystemUserServiceImpl implements SystemUserService {

	@Autowired
	SystemUserMapper systemUserMapper;
	
	@Transactional(readOnly = false)
	@Override
	public Boolean saveSystemUser(String username, String pwd, String oneIds, String twoIds) throws Exception {
		//彺system_user表中添加，获取生成的主键值
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("username", username);
		paramMap.put("pwd", MD5Tool.md5(pwd));
		int flag1 = systemUserMapper.insertSystemUser(paramMap);
		//将userId和权限Id都添加到user_authority表中
		if (flag1 <= 0)
            return false;
		Long userId = Long.parseLong(paramMap.get("userId")+"");
		String idStr = oneIds + twoIds;// "1,1,1,4,4,10,12,14"
			//正则表达式，去重和切割
	        String[] idAttr = idStr.replaceAll("(.,)\\1+", "$1").split("\\,");
	        for (String authorityId : idAttr) {
	            int flag2 = systemUserMapper.insertAuthority(userId, Long.parseLong(authorityId));
	            if (flag2 <= 0)
	                return false;
	        }
		return true;
	}

	@Override
	public List<Map<String, Object>> findSystemUserByLimit(Integer pageNum, Integer pageSize) {
		
		return systemUserMapper.selectAllSystemUser();
	}

	@Override
	public boolean updateSystemUserStatus(Long userId, String flag) {
		
		return systemUserMapper.updateSystemUserStatus(userId, flag)>=1;
	}

}
