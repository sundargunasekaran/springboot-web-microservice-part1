package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.CustomerModel;
import com.example.dto.UserModel;
import com.example.proxy.CustomerProxy;

@Controller
@RequestMapping("/op")
public class Demo1Controller {
	
	@Autowired
	private CustomerProxy customerProxy;
	
	/*
	 * @Autowired private WebUIProperty property;
	 */
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView userLogin() {
		return new ModelAndView("welcome");
	}

	
	@RequestMapping(value = "/details/{customerId}", method = RequestMethod.GET)
	public ModelAndView getDetails(@ModelAttribute("customer") CustomerModel customer) {
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAll(@ModelAttribute("customer") CustomerModel customer) {
		ModelAndView model = new ModelAndView("home");
		List<CustomerModel> customerList = customerProxy.getCustomerList();
		model.addObject("customers",  customerList);
		return model;
	}
}
