package com.ruoyi.lichun.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lichun.mapper.StaffMapper;
import com.ruoyi.lichun.domain.Staff;
import com.ruoyi.lichun.service.IStaffService;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工Service业务层处理
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class StaffServiceImpl implements IStaffService 
{
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 查询员工
     * 
     * @param staffId 员工主键
     * @return 员工
     */
    @Override
    public Staff selectStaffByStaffId(Integer staffId)
    {
        return staffMapper.selectStaffByStaffId(staffId);
    }

    /**
     * 查询员工列表
     * 
     * @param staff 员工
     * @return 员工
     */
    @Override
    public List<Staff> selectStaffList(Staff staff)
    {
        return staffMapper.selectStaffList(staff);
    }

    /**
     * 新增员工
     * 
     * @param staff 员工
     * @return 结果
     */
    @Override
    public int insertStaff(Staff staff)
    {
        return staffMapper.insertStaff(staff);
    }

    /**
     * 修改员工
     * 
     * @param staff 员工
     * @return 结果
     */
    @Override
    public int updateStaff(Staff staff)
    {
        return staffMapper.updateStaff(staff);
    }

    /**
     * 批量删除员工
     * 
     * @param staffIds 需要删除的员工主键
     * @return 结果
     */
    @Override
    public int deleteStaffByStaffIds(String staffIds)
    {
        return staffMapper.deleteStaffByStaffIds(Convert.toStrArray(staffIds));
    }

    /**
     * 删除员工信息
     * 
     * @param staffId 员工主键
     * @return 结果
     */
    @Override
    public int deleteStaffByStaffId(Integer staffId)
    {
        return staffMapper.deleteStaffByStaffId(staffId);
    }
}
