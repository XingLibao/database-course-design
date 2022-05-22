package com.ruoyi.lichun.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 供应商对象 lichun_supplier
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public class Supplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商编号 */
    @Excel(name = "供应商编号")
    private Integer supplierId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    public void setSupplierId(Integer supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Integer getSupplierId() 
    {
        return supplierId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("supplierId", getSupplierId())
            .append("name", getName())
            .append("phoneNumber", getPhoneNumber())
            .append("city", getCity())
            .toString();
    }
}
