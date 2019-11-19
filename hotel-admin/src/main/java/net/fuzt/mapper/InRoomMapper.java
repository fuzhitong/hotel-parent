package net.fuzt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.fuzt.pojo.InRoomInfo;

public interface InRoomMapper {

	List<Map<String, Object>> selectInRoomInfo(Map<String, Object> paramMap);
	
	//获取空闲房间
	@Select("SELECT * FROM rooms WHERE room_status='0'")
	List<Map<String, Object>> selectKXRoom();
	
	@Insert("INSERT INTO in_room_info VALUES(NULL,#{customerName},#{gender},#{isVip},#{idcard},#{phone},#{money},#{createDate},#{roomId},1,0)\r\n"+"")
	int insertInRoomInfo(InRoomInfo inRoomInfo);
	
	@Update("UPDATE `rooms` SET room_status=#{1} WHERE id=#{0}")
	int updateRoomStatus(Long roomId,String status);
	
	//Description: 根据房间状态获取房间信息
    @Select("SELECT * FROM rooms WHERE room_status=#{0}")
    List<Map<String, Object>> getRoomsByStatus(String status);

    //Description: 根据房间主键获取退房客人的信息
    Map<String, Object> selectOutRoomInfoByRoomId(Long roomId);
    
    //修改入住信息表中的状态:未退房
    @Update("UPDATE in_room_info SET out_room_status='1' WHERE id=#{0}")
    int updateIRIStatus(Long iriId);

    //修改订单结算状态
    @Update("UPDATE orders SET order_status='1' WHERE iri_id=#{0}")
    int updateOrderStatus(Long iriId);
    
    //查询消费记录，同时包括条件查询
    List<Map<String, Object>> selectCost(Map<String, Object> paramMap);
}
