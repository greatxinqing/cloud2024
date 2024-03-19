package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entities.Storage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * ClassName: StorageMapper
 * Package: com.atguigu.cloud.mapper
 * Description:
 *
 * @Author
 * @Create 2024/3/18 17:07
 * @Version 1.0
 */
public interface StorageMapper extends Mapper<Storage>
{
    /**
     * 扣减库存
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);



}



