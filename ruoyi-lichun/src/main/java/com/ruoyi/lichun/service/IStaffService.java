package com.ruoyi.lichun.service;

import java.util.List;
import com.ruoyi.lichun.domain.Staff;

/**
 * 员工Service接口
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public interface IStaffService 
{
    /**
     * 查询员工
     * 
     * @param staffId 员工主键
     * @return 员工
     */
    public Staff selectStaffByStaffId(Integer staffId);

    /**
     * 查询员工列表
     * 
     * @param staff 员工
     * @return 员工集合
     */
    public List<Staff> selectStaffList(Staff staff);

    /**
     * 新增员工
     * 
     * @param staff 员工
     * @return 结果
     */
    public int insertStaff(Staff staff);

    /**
     * 修改员工
     * 
     * @param staff 员工
     * @return 结果
     */
    public int updateStaff(Staff staff);

    /**
     * 批量删除员工
     * 
     * @param staffIds 需要删除的员工主键集合
     * @return 结果
     */
    public int deleteStaffByStaffIds(String staffIds);

    /**
     * 删除员工信息
     * 
     * @param staffId 员工主键
     * @return 结果
     */
    public int deleteStaffByStaffId(Integer staffId);
}
