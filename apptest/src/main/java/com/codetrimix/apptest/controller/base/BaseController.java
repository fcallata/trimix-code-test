package com.codetrimix.apptest.controller.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.codetrimix.apptest.service.PersonaService;

public class BaseController {

	@Autowired
	PersonaService personaService;
	
	public PersonaService getPersonaService(){
		return personaService;
	}
}
