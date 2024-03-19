package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: OrderController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author
 * @Create 2024/2/28 16:38
 * @Version 1.0
 */
@RestController
@Slf4j
@Tag(name="客户支付微服务模块",description = "支付CRUD")
public class OrderController {
    /**
     * 使用RestTemplate将URL先写死
     */
    //public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码
    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的未服务名称
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value="/consumer/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法，json串做参数")
    public ResultData addOrder(PayDTO payDTO){
      return   restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }

    @GetMapping(value="/consumer/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData updateOrder(PayDTO payDTO){
           restTemplate.put(PaymentSrv_URL+"/pay/update",payDTO, new Object[]{});
           return ResultData.success("修改成功");
    }

    @GetMapping(value="/consumer/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法，id做参数")
    public ResultData delOrder(@PathVariable("id") Integer id){
           restTemplate.delete(PaymentSrv_URL+"/pay/del/"+id,id);
           return ResultData.success("删除成功");
    }


    @GetMapping("/consumer/pay/get/{id}")
    @Operation(summary = "根据id查询",description = "根据id查询流水，id做参数")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/"+id, ResultData.class, id);
    }

    @GetMapping("/consumer/pay/allList")
    @Operation(summary = "查询全部",description = "根查询全部流水")
    public ResultData getAll(){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/allList", ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }
}
