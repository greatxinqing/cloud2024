package com.atguigu.cloud.service;

/**
 * ClassName: StorageService
 * Package: com.atguigu.cloud.service
 * Description:
 *
 * @Author
 * @Create 2024/3/18 17:10
 * @Version 1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
