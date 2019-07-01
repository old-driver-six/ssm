package com.bj186.oas.service.system.systemImpl;

import com.bj186.oas.mapper.DepartmentMapper;
import com.bj186.oas.mapper.PositionMapper;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Position;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.system.DepService;
import com.bj186.oas.service.system.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionMapper positionMapper;
    @Override
    public List<Position> selectPosition() {
        List<Position> positions = positionMapper.selectPosition();
        return positions;
    }
}
