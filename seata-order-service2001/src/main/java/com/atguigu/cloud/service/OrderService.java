package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * ClassName: OrderService
 * Package: com.atguigu.cloud.service
 * Description:
 *
 * @Author
 * @Create 2024/3/18 16:46
 * @Version 1.0
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
