package com.sxt.clouddisk.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class CustomExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ex.printStackTrace();
		CustomException customException=null;
		if(ex instanceof CustomException){
			customException=(CustomException)ex;
		}else{
			new CustomException("Î´Öª´íÎó");
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("message",customException.getMessage());
		mv.setViewName("error");
		return mv;
	}

}
