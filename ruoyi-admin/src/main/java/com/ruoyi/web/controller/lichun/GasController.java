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
import com.ruoyi.lichun.domain.Gas;
import com.ruoyi.lichun.service.IGasService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 煤气Controller
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Controller
@RequestMapping("/lichun/gas")
public class GasController extends BaseController
{
    private String prefix = "lichun/gas";

    @Autowired
    private IGasService gasService;

    @RequiresPermissions("lichun:gas:view")
    @GetMapping()
    public String gas()
    {
        return prefix + "/gas";
    }

    /**
     * 查询煤气列表
     */
    @RequiresPermissions("lichun:gas:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Gas gas)
    {
        startPage();
        List<Gas> list = gasService.selectGasList(gas);
        return getDataTable(list);
    }

    /**
     * 导出煤气列表
     */
    @RequiresPermissions("lichun:gas:export")
    @Log(title = "煤气", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Gas gas)
    {
        List<Gas> list = gasService.selectGasList(gas);
        ExcelUtil<Gas> util = new ExcelUtil<Gas>(Gas.class);
        return util.exportExcel(list, "煤气数据");
    }

    /**
     * 新增煤气
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存煤气
     */
    @RequiresPermissions("lichun:gas:add")
    @Log(title = "煤气", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Gas gas)
    {
        return toAjax(gasService.insertGas(gas));
    }

    /**
     * 修改煤气
     */
    @GetMapping("/edit/{gasId}")
    public String edit(@PathVariable("gasId") Integer gasId, ModelMap mmap)
    {
        Gas gas = gasService.selectGasByGasId(gasId);
        mmap.put("gas", gas);
        return prefix + "/edit";
    }

    /**
     * 修改保存煤气
     */
    @RequiresPermissions("lichun:gas:edit")
    @Log(title = "煤气", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Gas gas)
    {
        return toAjax(gasService.updateGas(gas));
    }

    /**
     * 删除煤气
     */
    @RequiresPermissions("lichun:gas:remove")
    @Log(title = "煤气", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(gasService.deleteGasByGasIds(ids));
    }
}
