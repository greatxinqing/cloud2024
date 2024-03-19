package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entities.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * ClassName: AccountMapper
 * Package: com.atguigu.cloud.mapper
 * Description:
 *
 * @Author
 * @Create 2024/3/18 17:15
 * @Version 1.0
 */
public interface AccountMapper extends Mapper<Account>
{

    /**
     * @param userId
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}

