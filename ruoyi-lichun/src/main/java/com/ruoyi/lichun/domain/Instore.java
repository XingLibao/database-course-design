package com.ruoyi.lichun.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 入库对象 lichun_instore
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public class Instore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库编号 */
    @Excel(name = "入库编号")
    private Integer instoreId;

    /** 入库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date instoreDate;

    /** 煤气编号 */
    @Excel(name = "煤气编号")
    private Integer gasId;

    /** 供应商编号 */
    @Excel(name = "供应商编号")
    private Integer supplierId;

    /** 进价 */
    @Excel(name = "进价")
    private Double purchasePrice;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Integer instoreQuantity;

    /** 入库支出 */
    @Excel(name = "入库支出")
    private Double instoreExpenditure;

    public void setInstoreId(Integer instoreId) 
    {
        this.instoreId = instoreId;
    }

    public Integer getInstoreId() 
    {
        return instoreId;
    }
    public void setInstoreDate(Date instoreDate) 
    {
        this.instoreDate = instoreDate;
    }

    public Date getInstoreDate() 
    {
        return instoreDate;
    }
    public void setGasId(Integer gasId) 
    {
        this.gasId = gasId;
    }

    public Integer getGasId() 
    {
        return gasId;
    }
    public void setSupplierId(Integer supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Integer getSupplierId() 
    {
        return supplierId;
    }
    public void setPurchasePrice(Double purchasePrice) 
    {
        this.purchasePrice = purchasePrice;
    }

    public Double getPurchasePrice() 
    {
        return purchasePrice;
    }
    public void setInstoreQuantity(Integer instoreQuantity) 
    {
        this.instoreQuantity = instoreQuantity;
    }

    public Integer getInstoreQuantity() 
    {
        return instoreQuantity;
    }
    public void setInstoreExpenditure(Double instoreExpenditure) 
    {
        this.instoreExpenditure = instoreExpenditure;
    }

    public Double getInstoreExpenditure() 
    {
        return instoreExpenditure;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("instoreId", getInstoreId())
            .append("instoreDate", getInstoreDate())
            .append("gasId", getGasId())
            .append("supplierId", getSupplierId())
            .append("purchasePrice", getPurchasePrice())
            .append("instoreQuantity", getInstoreQuantity())
            .append("instoreExpenditure", getInstoreExpenditure())
            .toString();
    }
}
