package com.example.customer.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.customer.model.CustomerModel;
import com.example.customer.model.PolicyModel;
import com.example.customer.service.CustomerService;
import com.example.proxy.PolicyProxy;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerServrice;
	
	@Autowired
	private PolicyProxy policyProxy;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<CustomerModel> getAll() {
		List<CustomerModel> customerList =  customerServrice.getAllCustomerDetails();
		Map<Integer, List<PolicyModel>> customerPolicy =  policyProxy.getCustomerPolicyDetails();
		List<CustomerModel> cl = customerServrice.getCustomerPolicyDetails(customerList,customerPolicy);
		return cl;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CustomerModel getById(@PathVariable String id) {	
		CustomerModel c = new CustomerModel();
		c.setCustomerId(Integer.parseInt(id));
		return customerServrice.getCustomerById(c);
	}

}
