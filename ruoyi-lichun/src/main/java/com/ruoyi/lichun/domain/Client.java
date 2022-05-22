package com.ruoyi.lichun.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户对象 lichun_client
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public class Client extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private Integer clientId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    public void setClientId(Integer clientId) 
    {
        this.clientId = clientId;
    }

    public Integer getClientId() 
    {
        return clientId;
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
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clientId", getClientId())
            .append("name", getName())
            .append("phoneNumber", getPhoneNumber())
            .append("address", getAddress())
            .toString();
    }
}
