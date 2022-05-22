package com.ruoyi.lichun.mapper;

import java.util.List;
import com.ruoyi.lichun.domain.Supplier;

/**
 * 供应商Mapper接口
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public interface SupplierMapper 
{
    /**
     * 查询供应商
     * 
     * @param supplierId 供应商主键
     * @return 供应商
     */
    public Supplier selectSupplierBySupplierId(Integer supplierId);

    /**
     * 查询供应商列表
     * 
     * @param supplier 供应商
     * @return 供应商集合
     */
    public List<Supplier> selectSupplierList(Supplier supplier);

    /**
     * 新增供应商
     * 
     * @param supplier 供应商
     * @return 结果
     */
    public int insertSupplier(Supplier supplier);

    /**
     * 修改供应商
     * 
     * @param supplier 供应商
     * @return 结果
     */
    public int updateSupplier(Supplier supplier);

    /**
     * 删除供应商
     * 
     * @param supplierId 供应商主键
     * @return 结果
     */
    public int deleteSupplierBySupplierId(Integer supplierId);

    /**
     * 批量删除供应商
     * 
     * @param supplierIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSupplierBySupplierIds(String[] supplierIds);
}
