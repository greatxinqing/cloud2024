package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: PayCircuitController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author
 * @Create 2024/3/8 10:19
 * @Version 1.0
 */
@RestController
public class PayCircuitController {

    //=========Resilience4j CircuitBreaker 的例子
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id) {
        if (id == -4) {
            throw new RuntimeException("----circuit id 不能负数");
        }
        if(id == 9999){
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "Hello, circuit! inputId:  "+id+" \t " + IdUtil.simpleUUID();
    }



}
