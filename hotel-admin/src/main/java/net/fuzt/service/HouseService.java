package net.fuzt.service;

import java.util.List;
import java.util.Map;

public interface HouseService {

	List<Map<String, Object>> findRoomType();
	
	List<Map<String, Object>> findRoomInfo();
}
