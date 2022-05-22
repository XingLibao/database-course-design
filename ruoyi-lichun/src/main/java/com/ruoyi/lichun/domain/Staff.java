package com.ruoyi.lichun.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工对象 lichun_staff
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public class Staff extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private Integer staffId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private Integer sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer age;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    public void setStaffId(Integer staffId) 
    {
        this.staffId = staffId;
    }

    public Integer getStaffId() 
    {
        return staffId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(Integer sex) 
    {
        this.sex = sex;
    }

    public Integer getSex() 
    {
        return sex;
    }
    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
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
            .append("staffId", getStaffId())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("phoneNumber", getPhoneNumber())
            .append("address", getAddress())
            .toString();
    }
}
