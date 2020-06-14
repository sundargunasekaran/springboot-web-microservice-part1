package com.example.customer.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
	
	
	private int customerId;
	private String username;
	private String password;
	private String emailId;
	private String role;
	private int roleId;
	private List<PolicyModel> policyModelList = new ArrayList<PolicyModel>();
	private PolicyModel policyModel;
	public CustomerModel(){
		customerId = -1;
		username = "";
		password = "";
		emailId = "";
		role = "";
		roleId = -1;
		policyModelList = null;
		policyModel = null;
	}
	
	
	public List<PolicyModel> getPolicyModelList() {
		return policyModelList;
	}
	public void setPolicyModelList(List<PolicyModel> policyModelList) {
		this.policyModelList = policyModelList;
	}
	
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public PolicyModel getPolicyModel() {
		return policyModel;
	}


	public void setPolicyModel(PolicyModel policyModel) {
		this.policyModel = policyModel;
	}
	
	

}
