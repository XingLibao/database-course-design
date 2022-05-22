package com.ruoyi.lichun.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出库对象 lichun_outstore
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public class Outstore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库编号 */
    @Excel(name = "出库编号")
    private Integer outstoreId;

    /** 出库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date outstoreDate;

    /** 煤气编号 */
    @Excel(name = "煤气编号")
    private Integer gasId;

    /** 出库数量 */
    @Excel(name = "出库数量")
    private Integer outstoreQuantity;

    /** 出库收入 */
    @Excel(name = "出库收入")
    private Double outstoreIncome;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private Integer staffId;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private Integer clientId;

    public void setOutstoreId(Integer outstoreId) 
    {
        this.outstoreId = outstoreId;
    }

    public Integer getOutstoreId() 
    {
        return outstoreId;
    }
    public void setOutstoreDate(Date outstoreDate) 
    {
        this.outstoreDate = outstoreDate;
    }

    public Date getOutstoreDate() 
    {
        return outstoreDate;
    }
    public void setGasId(Integer gasId) 
    {
        this.gasId = gasId;
    }

    public Integer getGasId() 
    {
        return gasId;
    }
    public void setOutstoreQuantity(Integer outstoreQuantity) 
    {
        this.outstoreQuantity = outstoreQuantity;
    }

    public Integer getOutstoreQuantity() 
    {
        return outstoreQuantity;
    }
    public void setOutstoreIncome(Double outstoreIncome) 
    {
        this.outstoreIncome = outstoreIncome;
    }

    public Double getOutstoreIncome() 
    {
        return outstoreIncome;
    }
    public void setStaffId(Integer staffId) 
    {
        this.staffId = staffId;
    }

    public Integer getStaffId() 
    {
        return staffId;
    }
    public void setClientId(Integer clientId) 
    {
        this.clientId = clientId;
    }

    public Integer getClientId() 
    {
        return clientId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("outstoreId", getOutstoreId())
            .append("outstoreDate", getOutstoreDate())
            .append("gasId", getGasId())
            .append("outstoreQuantity", getOutstoreQuantity())
            .append("outstoreIncome", getOutstoreIncome())
            .append("staffId", getStaffId())
            .append("clientId", getClientId())
            .toString();
    }
}
