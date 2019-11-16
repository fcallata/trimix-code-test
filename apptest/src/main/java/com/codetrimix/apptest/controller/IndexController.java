package com.codetrimix.apptest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value="/")
	public void index(HttpServletResponse response) throws IOException{
		System.out.println("Entro el controlador");		
		response.sendRedirect("/persona");
	}
}
