package com.wsh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsh.bean.CustomerCondition;
import com.wsh.bean.CustomerInfo;
import com.wsh.bean.CustomerSource;
import com.wsh.bean.CustomerSourceBing;
import com.wsh.bean.CustomerType;
import com.wsh.bean.PageBean;
import com.wsh.service.UserService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private UserService userService;

	// 分页展示客户信息
	@RequestMapping("/customerAction_listByPageBean")
	public String getPageDetils(Integer currentPage, String queryType, String queryContent, Model model) {
			PageBean pb = userService.getPageDetils(currentPage, queryType, queryContent);
			model.addAttribute("pb", pb);
			return "customer/customer_list";
		
	}
	// 添加界面回显
	@RequestMapping("/customerAction_add")
	public String getXiaLa(Model model) {
		CustomerInfo ci = userService.getXiaLa();
		model.addAttribute("ci",ci);
		return "customer/customer_add";
	}

	// 添加用户
	@RequestMapping("/customerAdd")
	public String addCustomer(CustomerInfo customerInfo) {
		System.out.println(customerInfo);
		Integer line = userService.addCustomer(customerInfo);
		if (line == 0) {
			return "customer/customer_add";
		} else {
			return "customer/customer_list";
		}

	}
	
	// 数据回显给修改界面
	@RequestMapping("/customerAction_toEdit")
	public String getCustomerById(CustomerInfo customerInfo,Model model) {
		// 根据id查询数据
		CustomerInfo ci = userService.getCustomerById(customerInfo.getCustomerId());
		System.out.println(ci);
		model.addAttribute("ci",ci);
		return "customer/customer_edit";
	}
	
	// 数据回显给详情界面
	@RequestMapping("/customerAction_toDetail")
	public String getCustomerToDetail(CustomerInfo customerInfo,Model model) {
		// 根据id查询数据
		CustomerInfo ci = userService.getCustomerById(customerInfo.getCustomerId());
		model.addAttribute("ci",ci);
		return "customer/customer_detail";

	}
	
	// 修改用户信息
	@RequestMapping("/CustomerUpdateServlet")
	public String updateCustomer(CustomerInfo customerInfo,Model model) {
		Integer line = userService.updateCustomer(customerInfo);
		if (line > 0) {
			return "customer/customer_list";
		}else {
			return "customer/customer_edit";
		}
	}
	
	// 删除用户信息
	@RequestMapping("/customerAction_delete")
	public String deleteCustomer(Integer customerId,Model model) {
		Integer line = userService.deleteCustomer(customerId);
		if (line > 0) {
			return "customer/customer_list";
		}else {
			return "customer/customer_edit";
		}
	}
	
	// 客户类型查询
	@RequestMapping("/customer_type_list")
	public String getCustomerType(Model model) {
		List<CustomerType> ct = userService.getCustomerType();
		model.addAttribute("ct",ct);
		return "customer/customer_type_list";
		
	}
	// 添加客户类型
	@RequestMapping("/customerType_add")
	public String customerType(CustomerType customerType) {
		Integer line = userService.addcustomerType(customerType);
		if (line == 0) {
			return "customer/customer_type_add";
		} else {
			return "customer/customer_type_list";
		}

	}
	// 删除客户类型
	@RequestMapping("/deleteCustomerTypeById")
	public String deleteCustomerTypeById(Integer typeId) {
		Integer line = userService.deleteCustomerTypeById(typeId);
		if (line > 0) {
			return "customer/customer_type_list";
		}else {
			return "frame/main";
		}
		
		
	}
	
	// 查询客户状态
	@RequestMapping("/customer_status_list")
	public String getCustomerCondition(Model model) {
		List<CustomerCondition> cc = userService.getCustomerCondition();
		model.addAttribute("cc",cc);
		return "customer/customer_status_list";
		
	}
	
	// 添加客户状态
	@RequestMapping("/customerCondition_add")
	public String addCustomerCondition(CustomerCondition customerCondition) {
		Integer line = userService.addCustomerCondition(customerCondition);
		if (line == 0) {
			return "customer/customer_status_add";
		} else {
			return "customer/customer_status_list";
		}
	}
	
	// 删除客户类型
	@RequestMapping("/deleteCustomerConditionById")
	public String deleteCustomerConditionById(Integer conditionId) {
		Integer line = userService.deleteCustomerConditionById(conditionId);
		if (line > 0) {
			return "customer/customer_status_list";
		}else {
			return "frame/main";
		}
		
		
	}
		
	// 查询客户来源
	@RequestMapping("/customer_source_list")
	public String getCustomerSource(Model model) {
		List<CustomerSource> cs = userService.getCustomerSource();
		model.addAttribute("cs",cs);
		return "customer/customer_source_list";
		
	}
	
	// 添加客户来源
	@RequestMapping("/customerSource_add")
	public String addCustomerSource(CustomerSource customerSource) {
			Integer line = userService.addCustomerSource(customerSource);
			if (line == 0) {
				return "customer/customer_source_add";
			} else {
				return "customer/customer_source_list";
			}
		}
	
	
	// 删除客户类型
	@RequestMapping("/deleteCustomerSourceById")
	public String deleteCustomerSourceById(Integer sourceId) {
		Integer line = userService.deleteCustomerSourceById(sourceId);
		if (line > 0) {
			return "customer/customer_source_list";
		}else {
			return "frame/main";
		}
		
	}
	
	// 获取饼状图
	@RequestMapping("/getSourceBingZhuang")
	@ResponseBody
	public List<CustomerSourceBing> getSourceBingZhuang() {
		List<CustomerSourceBing> list = userService.getSourceBingZhuang();
		return list;
	}
	

	
}
