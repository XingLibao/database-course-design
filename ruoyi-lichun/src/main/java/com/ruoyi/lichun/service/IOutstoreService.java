package com.ruoyi.lichun.service;

import java.util.List;
import com.ruoyi.lichun.domain.Outstore;

/**
 * 出库Service接口
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public interface IOutstoreService 
{
    /**
     * 查询出库
     * 
     * @param outstoreId 出库主键
     * @return 出库
     */
    public Outstore selectOutstoreByOutstoreId(Integer outstoreId);

    /**
     * 查询出库列表
     * 
     * @param outstore 出库
     * @return 出库集合
     */
    public List<Outstore> selectOutstoreList(Outstore outstore);

    /**
     * 新增出库
     * 
     * @param outstore 出库
     * @return 结果
     */
    public int insertOutstore(Outstore outstore);

    /**
     * 修改出库
     * 
     * @param outstore 出库
     * @return 结果
     */
    public int updateOutstore(Outstore outstore);

    /**
     * 批量删除出库
     * 
     * @param outstoreIds 需要删除的出库主键集合
     * @return 结果
     */
    public int deleteOutstoreByOutstoreIds(String outstoreIds);

    /**
     * 删除出库信息
     * 
     * @param outstoreId 出库主键
     * @return 结果
     */
    public int deleteOutstoreByOutstoreId(Integer outstoreId);
}
