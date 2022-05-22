package com.ruoyi.web.controller.lichun;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.lichun.domain.Staff;
import com.ruoyi.lichun.service.IStaffService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工Controller
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Controller
@RequestMapping("/lichun/staff")
public class StaffController extends BaseController
{
    private String prefix = "lichun/staff";

    @Autowired
    private IStaffService staffService;

    @RequiresPermissions("lichun:staff:view")
    @GetMapping()
    public String staff()
    {
        return prefix + "/staff";
    }

    /**
     * 查询员工列表
     */
    @RequiresPermissions("lichun:staff:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Staff staff)
    {
        startPage();
        List<Staff> list = staffService.selectStaffList(staff);
        return getDataTable(list);
    }

    /**
     * 导出员工列表
     */
    @RequiresPermissions("lichun:staff:export")
    @Log(title = "员工", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Staff staff)
    {
        List<Staff> list = staffService.selectStaffList(staff);
        ExcelUtil<Staff> util = new ExcelUtil<Staff>(Staff.class);
        return util.exportExcel(list, "员工数据");
    }

    /**
     * 新增员工
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工
     */
    @RequiresPermissions("lichun:staff:add")
    @Log(title = "员工", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Staff staff)
    {
        return toAjax(staffService.insertStaff(staff));
    }

    /**
     * 修改员工
     */
    @GetMapping("/edit/{staffId}")
    public String edit(@PathVariable("staffId") Integer staffId, ModelMap mmap)
    {
        Staff staff = staffService.selectStaffByStaffId(staffId);
        mmap.put("staff", staff);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工
     */
    @RequiresPermissions("lichun:staff:edit")
    @Log(title = "员工", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Staff staff)
    {
        return toAjax(staffService.updateStaff(staff));
    }

    /**
     * 删除员工
     */
    @RequiresPermissions("lichun:staff:remove")
    @Log(title = "员工", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(staffService.deleteStaffByStaffIds(ids));
    }
}
