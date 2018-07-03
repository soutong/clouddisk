package com.sxt.clouddisk.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.clouddisk.model.UserInfos;
import com.sxt.clouddisk.service.UserInfosService;
import com.sxt.clouddisk.service.impl.UserInfosServiceImpl;

@Controller
@RequestMapping("/user")
public class UserHandler {
	private UserInfosService us=new UserInfosServiceImpl();
	@RequestMapping("/register")
	public String register(UserInfos userInfos){
		int count = us.register(userInfos);
		if(count >0){
			return "redirect:/login.jsp";
		}else{
			return "redirect:/register.jsp";
		}
	}
	@RequestMapping("/login")
	public String login(String userName,String userPwd ,HttpServletRequest request){
		UserInfos userInfos = us.login(userName, userPwd);
		if(userInfos!=null){
			request.getSession().setAttribute("user", userInfos);
			return "redirect:/fileInfos/list.action";
		}else{
			return "redirect:/login.jsp";
		}
	}
	@RequestMapping("/validate")
	@ResponseBody
	public String validate(@RequestBody UserInfos userInfos){
		UserInfos userInfos2 = us.findByName(userInfos.getUserName());
		if(userInfos2!=null){
			return "false";
		}else{
			return "true";
		}
	}
}
