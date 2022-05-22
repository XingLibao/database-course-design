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
import com.ruoyi.lichun.domain.Instore;
import com.ruoyi.lichun.service.IInstoreService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 入库Controller
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Controller
@RequestMapping("/lichun/instore")
public class InstoreController extends BaseController
{
    private String prefix = "lichun/instore";

    @Autowired
    private IInstoreService instoreService;

    @RequiresPermissions("lichun:instore:view")
    @GetMapping()
    public String instore()
    {
        return prefix + "/instore";
    }

    /**
     * 查询入库列表
     */
    @RequiresPermissions("lichun:instore:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Instore instore)
    {
        startPage();
        List<Instore> list = instoreService.selectInstoreList(instore);
        return getDataTable(list);
    }

    /**
     * 导出入库列表
     */
    @RequiresPermissions("lichun:instore:export")
    @Log(title = "入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Instore instore)
    {
        List<Instore> list = instoreService.selectInstoreList(instore);
        ExcelUtil<Instore> util = new ExcelUtil<Instore>(Instore.class);
        return util.exportExcel(list, "入库数据");
    }

    /**
     * 新增入库
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存入库
     */
    @RequiresPermissions("lichun:instore:add")
    @Log(title = "入库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Instore instore)
    {
        return toAjax(instoreService.insertInstore(instore));
    }

    /**
     * 修改入库
     */
    @GetMapping("/edit/{instoreId}")
    public String edit(@PathVariable("instoreId") Integer instoreId, ModelMap mmap)
    {
        Instore instore = instoreService.selectInstoreByInstoreId(instoreId);
        mmap.put("instore", instore);
        return prefix + "/edit";
    }

    /**
     * 修改保存入库
     */
    @RequiresPermissions("lichun:instore:edit")
    @Log(title = "入库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Instore instore)
    {
        return toAjax(instoreService.updateInstore(instore));
    }

    /**
     * 删除入库
     */
    @RequiresPermissions("lichun:instore:remove")
    @Log(title = "入库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(instoreService.deleteInstoreByInstoreIds(ids));
    }
}
