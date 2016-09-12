package com.loginsmstest.rest;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.loginsmstest.bd.MobileAccessDTO;
import com.loginsmstest.bd.User;

@Controller(value="/loginSMS")
public class UserController {
	
	
	@RequestMapping(value = "/waiting", method= RequestMethod.POST)
	public ModelAndView waiting(@RequestParam("tlfn") String tlfn) {
		ModelAndView result = new ModelAndView("login", "error", true);
		MobileAccessDTO aux = null;
		String token = null;
		if(null != User.findByTlfn(tlfn) ) {
			aux = new MobileAccessDTO(tlfn, false);
			token = UUID.randomUUID().toString();
			MobileAccessDTO.addAuxiliar(token, aux);
			result = new ModelAndView("waiting", "token", token);
			result.addObject("phone",tlfn);
		}
		return result;
	}
	
	@RequestMapping(value = "/validation",  method= RequestMethod.GET, params = {"token" })
	public ModelAndView validation(@RequestParam("token") String token) {
		ModelAndView result = new ModelAndView();
		MobileAccessDTO aux = MobileAccessDTO.findByToken(token);
		
		if(null != aux) {
			aux.setConfirmado(true);
			result = new ModelAndView("confirmation", "aux", aux);
		}
		return result;
	}
	

	private Boolean isConfirmed(String token) {
		
		MobileAccessDTO aux = MobileAccessDTO.findByToken(token);
		
		if(null != aux)
			return aux.isConfirmado();
		
		return Boolean.FALSE;
		
	}
	
	@RequestMapping(value = "/fullLogin") 
	public ModelAndView login(@RequestParam( value = "token") String token) throws InterruptedException {
		
		long init = System.currentTimeMillis();
		final long max = 15000;
		
		while (System.currentTimeMillis() - init < max && !isConfirmed(token)) {
			Thread.currentThread().sleep(5000);
		}
		
		ModelAndView result = new ModelAndView();
		if (isConfirmed(token)) {
			User user = User.findByToken(token);
			result = new ModelAndView("index", "user", user);
		} else {
			result = new ModelAndView("login", "error", true);
		}
		return result;
	}
}
