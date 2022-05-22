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
import com.ruoyi.lichun.domain.Outstore;
import com.ruoyi.lichun.service.IOutstoreService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出库Controller
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Controller
@RequestMapping("/lichun/outstore")
public class OutstoreController extends BaseController
{
    private String prefix = "lichun/outstore";

    @Autowired
    private IOutstoreService outstoreService;

    @RequiresPermissions("lichun:outstore:view")
    @GetMapping()
    public String outstore()
    {
        return prefix + "/outstore";
    }

    /**
     * 查询出库列表
     */
    @RequiresPermissions("lichun:outstore:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Outstore outstore)
    {
        startPage();
        List<Outstore> list = outstoreService.selectOutstoreList(outstore);
        return getDataTable(list);
    }

    /**
     * 导出出库列表
     */
    @RequiresPermissions("lichun:outstore:export")
    @Log(title = "出库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Outstore outstore)
    {
        List<Outstore> list = outstoreService.selectOutstoreList(outstore);
        ExcelUtil<Outstore> util = new ExcelUtil<Outstore>(Outstore.class);
        return util.exportExcel(list, "出库数据");
    }

    /**
     * 新增出库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存出库
     */
    @RequiresPermissions("lichun:outstore:add")
    @Log(title = "出库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Outstore outstore)
    {
        return toAjax(outstoreService.insertOutstore(outstore));
    }

    /**
     * 修改出库
     */
    @GetMapping("/edit/{outstoreId}")
    public String edit(@PathVariable("outstoreId") Integer outstoreId, ModelMap mmap)
    {
        Outstore outstore = outstoreService.selectOutstoreByOutstoreId(outstoreId);
        mmap.put("outstore", outstore);
        return prefix + "/edit";
    }

    /**
     * 修改保存出库
     */
    @RequiresPermissions("lichun:outstore:edit")
    @Log(title = "出库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Outstore outstore)
    {
        return toAjax(outstoreService.updateOutstore(outstore));
    }

    /**
     * 删除出库
     */
    @RequiresPermissions("lichun:outstore:remove")
    @Log(title = "出库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(outstoreService.deleteOutstoreByOutstoreIds(ids));
    }
}
