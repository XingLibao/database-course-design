package com.ruoyi.lichun.mapper;

import java.util.List;
import com.ruoyi.lichun.domain.Gas;

/**
 * 煤气Mapper接口
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public interface GasMapper 
{
    /**
     * 查询煤气
     * 
     * @param gasId 煤气主键
     * @return 煤气
     */
    public Gas selectGasByGasId(Integer gasId);

    /**
     * 查询煤气列表
     * 
     * @param gas 煤气
     * @return 煤气集合
     */
    public List<Gas> selectGasList(Gas gas);

    /**
     * 新增煤气
     * 
     * @param gas 煤气
     * @return 结果
     */
    public int insertGas(Gas gas);

    /**
     * 修改煤气
     * 
     * @param gas 煤气
     * @return 结果
     */
    public int updateGas(Gas gas);

    /**
     * 删除煤气
     * 
     * @param gasId 煤气主键
     * @return 结果
     */
    public int deleteGasByGasId(Integer gasId);

    /**
     * 批量删除煤气
     * 
     * @param gasIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGasByGasIds(String[] gasIds);
}
