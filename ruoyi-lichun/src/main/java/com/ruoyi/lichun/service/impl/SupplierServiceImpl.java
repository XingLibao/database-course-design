package com.ruoyi.lichun.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lichun.mapper.SupplierMapper;
import com.ruoyi.lichun.domain.Supplier;
import com.ruoyi.lichun.service.ISupplierService;
import com.ruoyi.common.core.text.Convert;

/**
 * 供应商Service业务层处理
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class SupplierServiceImpl implements ISupplierService 
{
    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 查询供应商
     * 
     * @param supplierId 供应商主键
     * @return 供应商
     */
    @Override
    public Supplier selectSupplierBySupplierId(Integer supplierId)
    {
        return supplierMapper.selectSupplierBySupplierId(supplierId);
    }

    /**
     * 查询供应商列表
     * 
     * @param supplier 供应商
     * @return 供应商
     */
    @Override
    public List<Supplier> selectSupplierList(Supplier supplier)
    {
        return supplierMapper.selectSupplierList(supplier);
    }

    /**
     * 新增供应商
     * 
     * @param supplier 供应商
     * @return 结果
     */
    @Override
    public int insertSupplier(Supplier supplier)
    {
        return supplierMapper.insertSupplier(supplier);
    }

    /**
     * 修改供应商
     * 
     * @param supplier 供应商
     * @return 结果
     */
    @Override
    public int updateSupplier(Supplier supplier)
    {
        return supplierMapper.updateSupplier(supplier);
    }

    /**
     * 批量删除供应商
     * 
     * @param supplierIds 需要删除的供应商主键
     * @return 结果
     */
    @Override
    public int deleteSupplierBySupplierIds(String supplierIds)
    {
        return supplierMapper.deleteSupplierBySupplierIds(Convert.toStrArray(supplierIds));
    }

    /**
     * 删除供应商信息
     * 
     * @param supplierId 供应商主键
     * @return 结果
     */
    @Override
    public int deleteSupplierBySupplierId(Integer supplierId)
    {
        return supplierMapper.deleteSupplierBySupplierId(supplierId);
    }
}
