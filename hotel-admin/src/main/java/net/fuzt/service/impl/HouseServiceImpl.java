package net.fuzt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fuzt.mapper.HouseMapper;
import net.fuzt.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	HouseMapper houseMapper;
	
	@Override
	public List<Map<String, Object>> findRoomType() {
		
		return houseMapper.selectRoomType();
	}

	@Override
	public List<Map<String, Object>> findRoomInfo() {
		
		return houseMapper.selectRoomsInfo();
	}

}
