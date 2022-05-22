package com.ruoyi.lichun.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 煤气对象 lichun_gas
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public class Gas extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 煤气编号 */
    @Excel(name = "煤气编号")
    private Integer gasId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 库存量 */
    @Excel(name = "库存量")
    private Long inventory;

    /** 进价 */
    @Excel(name = "进价")
    private Double purchasePrice;

    /** 售价 */
    @Excel(name = "售价")
    private Double price;

    public void setGasId(Integer gasId) 
    {
        this.gasId = gasId;
    }

    public Integer getGasId() 
    {
        return gasId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setInventory(Long inventory) 
    {
        this.inventory = inventory;
    }

    public Long getInventory() 
    {
        return inventory;
    }
    public void setPurchasePrice(Double purchasePrice) 
    {
        this.purchasePrice = purchasePrice;
    }

    public Double getPurchasePrice() 
    {
        return purchasePrice;
    }
    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Double getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gasId", getGasId())
            .append("name", getName())
            .append("inventory", getInventory())
            .append("purchasePrice", getPurchasePrice())
            .append("price", getPrice())
            .toString();
    }
}
