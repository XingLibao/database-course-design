package com.ruoyi.lichun.service;

import java.util.List;
import com.ruoyi.lichun.domain.Instore;

/**
 * 入库Service接口
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public interface IInstoreService 
{
    /**
     * 查询入库
     * 
     * @param instoreId 入库主键
     * @return 入库
     */
    public Instore selectInstoreByInstoreId(Integer instoreId);

    /**
     * 查询入库列表
     * 
     * @param instore 入库
     * @return 入库集合
     */
    public List<Instore> selectInstoreList(Instore instore);

    /**
     * 新增入库
     * 
     * @param instore 入库
     * @return 结果
     */
    public int insertInstore(Instore instore);

    /**
     * 修改入库
     * 
     * @param instore 入库
     * @return 结果
     */
    public int updateInstore(Instore instore);

    /**
     * 批量删除入库
     * 
     * @param instoreIds 需要删除的入库主键集合
     * @return 结果
     */
    public int deleteInstoreByInstoreIds(String instoreIds);

    /**
     * 删除入库信息
     * 
     * @param instoreId 入库主键
     * @return 结果
     */
    public int deleteInstoreByInstoreId(Integer instoreId);
}
