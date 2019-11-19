package net.fuzt.service;

import java.util.List;
import java.util.Map;

import net.fuzt.pojo.InRoomInfo;

public interface InRoomService {

	List<Map<String, Object>> findInRoomInfo(Map<String, Object> paramMap,Integer pageNum,Integer pageSize);
	
	List<Map<String, Object>> findKXRoom();
	
	Boolean saveInRoomInfo(InRoomInfo inRoomInfo);
	
	List<Map<String, Object>> findRoomsByStatus(String status);

    Map<String, Object> findOutRoomInfoByRoomId(Long roomId);
	
    boolean outRoom(Long roomId, Long iriId, Float qita) throws Exception;

    List<Map<String, Object>> findCost(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);
}
