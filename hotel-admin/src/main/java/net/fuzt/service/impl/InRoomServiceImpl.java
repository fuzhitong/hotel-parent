package net.fuzt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import net.fuzt.mapper.InRoomMapper;
import net.fuzt.pojo.InRoomInfo;
import net.fuzt.service.InRoomService;

@Service
public class InRoomServiceImpl implements InRoomService {

	@Autowired
	InRoomMapper inRoomMapper;
	
	@Override
	public List<Map<String, Object>> findInRoomInfo(Map<String, Object> paramMap,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return inRoomMapper.selectInRoomInfo(paramMap);
	}

	//空闲房间
	@Override
	public List<Map<String, Object>> findKXRoom() {
		
		return inRoomMapper.selectKXRoom();
	}

	@Transactional(readOnly = false)
	@Override
	public Boolean saveInRoomInfo(InRoomInfo inRoomInfo) {
		int flag1 = inRoomMapper.insertInRoomInfo(inRoomInfo);
		int flag2 = inRoomMapper.updateRoomStatus(inRoomInfo.getRoomId(),"1");
		return flag1 >= 1 && flag2 >= 1;
	}

	@Override
    public List<Map<String, Object>> findRoomsByStatus(String status) {
        return inRoomMapper.getRoomsByStatus(status);
    }

    @Override
    public Map<String, Object> findOutRoomInfoByRoomId(Long roomId) {
        return inRoomMapper.selectOutRoomInfoByRoomId(roomId);
    }
	
    @Override
    @Transactional(readOnly = false)
    public boolean outRoom(Long roomId, Long iriId, Float qita) throws Exception {
        // 修改入住信息状态
        int flag1 = inRoomMapper.updateIRIStatus(iriId);
        // 修改订单状态
        int flag2 = 1;
        if (qita > 0) {
            flag2 = inRoomMapper.updateOrderStatus(iriId);
        }
        // 修改房间状态
        int flag3 = inRoomMapper.updateRoomStatus(roomId, "2");
        if (flag1 <= 0 || flag2 <= 0 || flag3 <= 0) {
            throw new Exception();
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> findCost(Map<String, Object> paramMap, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return inRoomMapper.selectCost(paramMap);
    }
    
}
