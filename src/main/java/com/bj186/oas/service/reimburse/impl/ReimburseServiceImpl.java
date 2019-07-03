package com.bj186.oas.service.reimburse.impl;

import com.bj186.oas.mapper.ReimburseMapper;
import com.bj186.oas.pojo.Reimburse;
import com.bj186.oas.service.reimburse.ReimburseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service("reimburseServiceImpl")
public class ReimburseServiceImpl implements ReimburseService {
    @Resource
    private ReimburseMapper reimburseMapper;
    @Override
    public Reimburse selectByPrimaryKey(Integer reimId) {
        return null;
    }

    @Override
    public List<Reimburse> selectAll() {
        return reimburseMapper.selectAll();
    }
}
