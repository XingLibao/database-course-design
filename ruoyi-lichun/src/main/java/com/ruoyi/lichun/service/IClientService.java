package com.ruoyi.lichun.service;

import java.util.List;
import com.ruoyi.lichun.domain.Client;

/**
 * 客户Service接口
 * 
 * @author xinglibao
 * @date 2021-10-17
 */
public interface IClientService 
{
    /**
     * 查询客户
     * 
     * @param clientId 客户主键
     * @return 客户
     */
    public Client selectClientByClientId(Integer clientId);

    /**
     * 查询客户列表
     * 
     * @param client 客户
     * @return 客户集合
     */
    public List<Client> selectClientList(Client client);

    /**
     * 新增客户
     * 
     * @param client 客户
     * @return 结果
     */
    public int insertClient(Client client);

    /**
     * 修改客户
     * 
     * @param client 客户
     * @return 结果
     */
    public int updateClient(Client client);

    /**
     * 批量删除客户
     * 
     * @param clientIds 需要删除的客户主键集合
     * @return 结果
     */
    public int deleteClientByClientIds(String clientIds);

    /**
     * 删除客户信息
     * 
     * @param clientId 客户主键
     * @return 结果
     */
    public int deleteClientByClientId(Integer clientId);
}
