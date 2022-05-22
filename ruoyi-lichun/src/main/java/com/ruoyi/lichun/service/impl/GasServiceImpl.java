package com.ruoyi.lichun.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lichun.mapper.GasMapper;
import com.ruoyi.lichun.domain.Gas;
import com.ruoyi.lichun.service.IGasService;
import com.ruoyi.common.core.text.Convert;

/**
 * 煤气Service业务层处理
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class GasServiceImpl implements IGasService 
{
    @Autowired
    private GasMapper gasMapper;

    /**
     * 查询煤气
     * 
     * @param gasId 煤气主键
     * @return 煤气
     */
    @Override
    public Gas selectGasByGasId(Integer gasId)
    {
        return gasMapper.selectGasByGasId(gasId);
    }

    /**
     * 查询煤气列表
     * 
     * @param gas 煤气
     * @return 煤气
     */
    @Override
    public List<Gas> selectGasList(Gas gas)
    {
        return gasMapper.selectGasList(gas);
    }

    /**
     * 新增煤气
     * 
     * @param gas 煤气
     * @return 结果
     */
    @Override
    public int insertGas(Gas gas)
    {
        return gasMapper.insertGas(gas);
    }

    /**
     * 修改煤气
     * 
     * @param gas 煤气
     * @return 结果
     */
    @Override
    public int updateGas(Gas gas)
    {
        return gasMapper.updateGas(gas);
    }

    /**
     * 批量删除煤气
     * 
     * @param gasIds 需要删除的煤气主键
     * @return 结果
     */
    @Override
    public int deleteGasByGasIds(String gasIds)
    {
        return gasMapper.deleteGasByGasIds(Convert.toStrArray(gasIds));
    }

    /**
     * 删除煤气信息
     * 
     * @param gasId 煤气主键
     * @return 结果
     */
    @Override
    public int deleteGasByGasId(Integer gasId)
    {
        return gasMapper.deleteGasByGasId(gasId);
    }
}
