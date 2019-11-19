package net.fuzt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface HouseMapper {

	@Select("Select * from room_type")
	List<Map<String, Object>> selectRoomType();
	
	//获取房间信息
	@Select("SELECT rm.id AS roomId,rm.room_num,rm.room_status,rt.room_price,rt.room_type_name \r\n"
            + "FROM rooms rm INNER JOIN room_type rt ON rm.room_type_id=rt.id")
	List<Map<String, Object>> selectRoomsInfo();
}
