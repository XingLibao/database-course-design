package com.ruoyi.lichun.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lichun.mapper.OutstoreMapper;
import com.ruoyi.lichun.domain.Outstore;
import com.ruoyi.lichun.service.IOutstoreService;
import com.ruoyi.common.core.text.Convert;

/**
 * 出库Service业务层处理
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class OutstoreServiceImpl implements IOutstoreService 
{
    @Autowired
    private OutstoreMapper outstoreMapper;

    /**
     * 查询出库
     * 
     * @param outstoreId 出库主键
     * @return 出库
     */
    @Override
    public Outstore selectOutstoreByOutstoreId(Integer outstoreId)
    {
        return outstoreMapper.selectOutstoreByOutstoreId(outstoreId);
    }

    /**
     * 查询出库列表
     * 
     * @param outstore 出库
     * @return 出库
     */
    @Override
    public List<Outstore> selectOutstoreList(Outstore outstore)
    {
        return outstoreMapper.selectOutstoreList(outstore);
    }

    /**
     * 新增出库
     * 
     * @param outstore 出库
     * @return 结果
     */
    @Override
    public int insertOutstore(Outstore outstore)
    {
        return outstoreMapper.insertOutstore(outstore);
    }

    /**
     * 修改出库
     * 
     * @param outstore 出库
     * @return 结果
     */
    @Override
    public int updateOutstore(Outstore outstore)
    {
        return outstoreMapper.updateOutstore(outstore);
    }

    /**
     * 批量删除出库
     * 
     * @param outstoreIds 需要删除的出库主键
     * @return 结果
     */
    @Override
    public int deleteOutstoreByOutstoreIds(String outstoreIds)
    {
        return outstoreMapper.deleteOutstoreByOutstoreIds(Convert.toStrArray(outstoreIds));
    }

    /**
     * 删除出库信息
     * 
     * @param outstoreId 出库主键
     * @return 结果
     */
    @Override
    public int deleteOutstoreByOutstoreId(Integer outstoreId)
    {
        return outstoreMapper.deleteOutstoreByOutstoreId(outstoreId);
    }
}
