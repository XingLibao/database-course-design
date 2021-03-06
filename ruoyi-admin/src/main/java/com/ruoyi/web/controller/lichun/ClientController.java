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
import com.ruoyi.lichun.domain.Client;
import com.ruoyi.lichun.service.IClientService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户Controller
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Controller
@RequestMapping("/lichun/client")
public class ClientController extends BaseController
{
    private String prefix = "lichun/client";

    @Autowired
    private IClientService clientService;

    @RequiresPermissions("lichun:client:view")
    @GetMapping()
    public String client()
    {
        return prefix + "/client";
    }

    /**
     * 查询客户列表
     */
    @RequiresPermissions("lichun:client:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Client client)
    {
        startPage();
        List<Client> list = clientService.selectClientList(client);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @RequiresPermissions("lichun:client:export")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Client client)
    {
        List<Client> list = clientService.selectClientList(client);
        ExcelUtil<Client> util = new ExcelUtil<Client>(Client.class);
        return util.exportExcel(list, "客户数据");
    }

    /**
     * 新增客户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户
     */
    @RequiresPermissions("lichun:client:add")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Client client)
    {
        return toAjax(clientService.insertClient(client));
    }

    /**
     * 修改客户
     */
    @GetMapping("/edit/{clientId}")
    public String edit(@PathVariable("clientId") Integer clientId, ModelMap mmap)
    {
        Client client = clientService.selectClientByClientId(clientId);
        mmap.put("client", client);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户
     */
    @RequiresPermissions("lichun:client:edit")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Client client)
    {
        return toAjax(clientService.updateClient(client));
    }

    /**
     * 删除客户
     */
    @RequiresPermissions("lichun:client:remove")
    @Log(title = "客户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(clientService.deleteClientByClientIds(ids));
    }
}
