package com.ruoyi.lichun.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lichun.mapper.ClientMapper;
import com.ruoyi.lichun.domain.Client;
import com.ruoyi.lichun.service.IClientService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户Service业务层处理
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class ClientServiceImpl implements IClientService 
{
    @Autowired
    private ClientMapper clientMapper;

    /**
     * 查询客户
     * 
     * @param clientId 客户主键
     * @return 客户
     */
    @Override
    public Client selectClientByClientId(Integer clientId)
    {
        return clientMapper.selectClientByClientId(clientId);
    }

    /**
     * 查询客户列表
     * 
     * @param client 客户
     * @return 客户
     */
    @Override
    public List<Client> selectClientList(Client client)
    {
        return clientMapper.selectClientList(client);
    }

    /**
     * 新增客户
     * 
     * @param client 客户
     * @return 结果
     */
    @Override
    public int insertClient(Client client)
    {
        return clientMapper.insertClient(client);
    }

    /**
     * 修改客户
     * 
     * @param client 客户
     * @return 结果
     */
    @Override
    public int updateClient(Client client)
    {
        return clientMapper.updateClient(client);
    }

    /**
     * 批量删除客户
     * 
     * @param clientIds 需要删除的客户主键
     * @return 结果
     */
    @Override
    public int deleteClientByClientIds(String clientIds)
    {
        return clientMapper.deleteClientByClientIds(Convert.toStrArray(clientIds));
    }

    /**
     * 删除客户信息
     * 
     * @param clientId 客户主键
     * @return 结果
     */
    @Override
    public int deleteClientByClientId(Integer clientId)
    {
        return clientMapper.deleteClientByClientId(clientId);
    }
}
