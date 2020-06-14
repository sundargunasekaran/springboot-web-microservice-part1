package com.example.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.config.FeignSimpleEncoderConfig;
import com.example.dto.CustomerModel;



@FeignClient(name = "customer-service", url = "${test.mcs1.customer.url}",configuration = FeignSimpleEncoderConfig.class)
public interface CustomerProxy {
	
	@GetMapping(value = "/customer/list")
	public List<CustomerModel> getCustomerList();

}
