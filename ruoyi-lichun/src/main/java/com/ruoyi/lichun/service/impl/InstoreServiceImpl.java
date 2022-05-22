package com.ruoyi.lichun.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lichun.mapper.InstoreMapper;
import com.ruoyi.lichun.domain.Instore;
import com.ruoyi.lichun.service.IInstoreService;
import com.ruoyi.common.core.text.Convert;

/**
 * 入库Service业务层处理
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class InstoreServiceImpl implements IInstoreService 
{
    @Autowired
    private InstoreMapper instoreMapper;

    /**
     * 查询入库
     * 
     * @param instoreId 入库主键
     * @return 入库
     */
    @Override
    public Instore selectInstoreByInstoreId(Integer instoreId)
    {
        return instoreMapper.selectInstoreByInstoreId(instoreId);
    }

    /**
     * 查询入库列表
     * 
     * @param instore 入库
     * @return 入库
     */
    @Override
    public List<Instore> selectInstoreList(Instore instore)
    {
        return instoreMapper.selectInstoreList(instore);
    }

    /**
     * 新增入库
     * 
     * @param instore 入库
     * @return 结果
     */
    @Override
    public int insertInstore(Instore instore)
    {
        return instoreMapper.insertInstore(instore);
    }

    /**
     * 修改入库
     * 
     * @param instore 入库
     * @return 结果
     */
    @Override
    public int updateInstore(Instore instore)
    {
        return instoreMapper.updateInstore(instore);
    }

    /**
     * 批量删除入库
     * 
     * @param instoreIds 需要删除的入库主键
     * @return 结果
     */
    @Override
    public int deleteInstoreByInstoreIds(String instoreIds)
    {
        return instoreMapper.deleteInstoreByInstoreIds(Convert.toStrArray(instoreIds));
    }

    /**
     * 删除入库信息
     * 
     * @param instoreId 入库主键
     * @return 结果
     */
    @Override
    public int deleteInstoreByInstoreId(Integer instoreId)
    {
        return instoreMapper.deleteInstoreByInstoreId(instoreId);
    }
}
